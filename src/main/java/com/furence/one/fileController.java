package com.furence.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.furence.VO.FileVO;
import com.furence.VO.UserVO;
import com.furence.service.fileServiceInterface;
import com.furence.service.signServiceInterface;
import com.furence.validation.fileValid;

@Controller
public class fileController {
	@Inject
	private signServiceInterface signService;
	
	@Inject
	private fileServiceInterface fileService;
	
	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String fileupload(@RequestParam("uploadFile") MultipartFile file, Model model) throws Exception,IOException{
		fileValid valid=new fileValid();
		UserVO uservo=new UserVO();
		FileVO filevo=new FileVO();
		Map<Integer,String> map=new HashMap<Integer,String>();
		int failcount=0;
		
		String filename = file.getOriginalFilename();
		String uploadfolder = "C:\\tmp";
		File savefile = new File(uploadfolder, filename); // 경로, 업로드하는파일명
		String extension = filename.substring(filename.lastIndexOf("."), filename.length()); // 업로드할 확장자명
			if (extension.equals(".dbfile")) {
				file.transferTo(savefile); // DB파일인경우에만 폴더에 저장.
				BufferedReader reader = new BufferedReader(new FileReader(savefile));
				String one;
				while ((one = reader.readLine()) != null) {
					String[] filesplit=one.split("/");
					filevo.setTotal(1);		//total 카운트
					if(valid.columnCheck(one) && valid.dataCheck(one) && valid.nullCheck(one) 
							&& fileService.overlapCheck(filesplit[0])==0) {
							uservo.setId(filesplit[0]);
							uservo.setPwd(filesplit[1]);
							uservo.setName(filesplit[2]);
			
							String lev = filesplit[3];
							char l = lev.charAt(0); // 형변환
							uservo.setLevel(l);
			
							uservo.setDesc(filesplit[4]);
			
							String time = filesplit[5];
							Timestamp t = Timestamp.valueOf(time);
							uservo.setReg_date(t);
							
							int count=fileService.dbInsert(uservo);
							filevo.setSuccess(count);	//성공횟수 카운트
					}else {
						System.out.println("유효성검사 실패");
						filevo.setFail(1);	//실패횟수 카운트
						failcount=failcount+1;
						map.put(failcount,one);
					}
				}
				reader.close();
				filevo.setMap(map);
				model.addAttribute("filevo", filevo);
			}
		return "success";
	}
	
}

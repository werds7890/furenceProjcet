package com.furence.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.furence.service.signServiceInterface;
import com.furence.validation.fileValid;

@Controller
public class fileConroller {
	@Inject
	private signServiceInterface signService;

	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String fileupload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		fileValid valid=new fileValid();
		ArrayList<String> filelist = new ArrayList<String>();
		System.out.println(file);
		String filename = file.getOriginalFilename();
		String uploadfolder = "C:\\tmp";
		File savefile = new File(uploadfolder, filename); // 경로, 업로드하는파일명
		String extension = filename.substring(filename.lastIndexOf("."), filename.length()); // 업로드할 확장자명
		try {
			if (extension.equals(".dbfile")) {
				file.transferTo(savefile); // DB파일인경우에만 폴더에 저장.
				BufferedReader reader = new BufferedReader(new FileReader(savefile));
				String one;
				while ((one = reader.readLine()) != null) {
					if(valid.columnCheck(one) && valid.dataCheck(one) && valid.nullCheck(one)) {
						System.out.println("유효성검사완료");
					}else {
						System.out.println("유효성검사실패");
					}
				}
				reader.close();
			} else {
				throw new Exception("DB파일이아닙니다."); // 혹시나 DB파일이 아닌 파일이 전송될 경우 에러처리.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "success";
	}

	
	
	
	
	
	
//	public FileVO Receivefile(ArrayList<String> Filelist) throws Exception {
//		int cnt = 0;
//		UserVO uservo = new UserVO();
//		FileVO filevo = new FileVO();
//		filevo.setTotal(Filelist.size());
//
//		for (int i = 0; i < Filelist.size(); i++) {
//			String file[] = Filelist.get(i).split("/");
//			if (file.length == 6) {
//				uservo.setId(file[0]);
//				uservo.setPwd(file[1]);
//				uservo.setName(file[2]);
//
//				String lev = file[3];
//				char l = lev.charAt(0); // 형변환
//				uservo.setLevel(l);
//
//				uservo.setDesc(file[4]);
//
//				String time = file[5];
//				Timestamp t = Timestamp.valueOf(time);
//				uservo.setReg_date(t);
//
//				System.out.println(uservo.getId() + uservo.getPwd() + uservo.getName() + uservo.getLevel()
//						+ uservo.getDesc() + uservo.getReg_date());
//
//				int cnt2 = signService.Datainsert(uservo);
//				cnt = cnt + cnt2;
//
//				// insert성공한횟수
//			}
//
//		}
//		filevo.setSuccess(cnt); // 성공횟수
//		filevo.setFail(filevo.getTotal() - cnt); // 실패횟수
//		return filevo;
//	}
}
package com.furence.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.furence.VO.FileVO;
import com.furence.VO.UserVO;
import com.furence.service.signServiceInterface;
import com.furence.validation.fileValid;

@Controller
public class signController {
	@Inject
	private signServiceInterface signService;
	
	@RequestMapping(value="/user/signin", method=RequestMethod.GET)
	public String loginview() {
		return "login";
	}
	
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	@ResponseBody
	public int loginCheck(@RequestBody UserVO uservo,HttpServletRequest request) throws Exception{
		System.out.println("ID:"+uservo.getId());
		System.out.println("PWD:"+uservo.getPwd());
		int checkP = 0;
		UserVO loginData=signService.loginCheck(uservo);
		if(loginData!=null) {
			System.out.println("login ok!");
			checkP=1;
			HttpSession session=request.getSession();
			session.setAttribute("userId", loginData.getId());
		}else if(loginData==null){
			System.out.println("login fail!");
			checkP=0;
		}
		return checkP;
	}
	
	
	@RequestMapping(value="/user/signup", method=RequestMethod.GET)	//사용자 가입폼
	public String regiview() throws Exception{
		return "register";
	}
	
	@RequestMapping(value="/user/siginup", method=RequestMethod.POST)	//사용자 가입
	@ResponseBody
	public int chk(@RequestBody UserVO uservo) throws Exception{
		SimpleDateFormat conv=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=conv.format(uservo.getReg_date());
		String time2=time.substring(0,10)+" 00:00:00";
		Timestamp t=Timestamp.valueOf(time2);
		uservo.setReg_date(t);
		
		int count=signService.idOverlap(uservo);	//아이디중복체크
		if(count==0) {
			signService.userSignup(uservo);
		}else {
			count=1;
		}	
		return count;
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value="/user/dataLoad", method=RequestMethod.GET)
	public String dataload(Model model,UserVO uservo) throws Exception{
		model.addAttribute("loadData", signService.dataLoad(uservo));
		return "home";
	}
	

	
	
	
	
}

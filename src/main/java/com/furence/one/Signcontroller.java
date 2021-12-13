package com.furence.one;

import java.awt.Stroke;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.furence.VO.Filevo;
import com.furence.VO.Uservo;
import com.furence.service.SignserviceInterface;
import com.furence.validation.Filevalid;

@Controller
public class Signcontroller {
	@Inject
	private SignserviceInterface signService;
	
	@RequestMapping(value="/user/signin", method=RequestMethod.GET)
	public String loginview() {
		return "login";
	}
	
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> loginCheck(@RequestBody Uservo uservo,HttpServletRequest request) throws Exception{
		System.out.println("ID:"+uservo.getId());
		System.out.println("PWD:"+uservo.getPwd());
		Uservo loginData=signService.loginCheck(uservo);	//유저아이디와 비밀번호를 들고 select 해보고 그 결과를 resultType의 uservo로받아
		//매핑이 된다면 체크포인트1과 세션을 생성하여 세션에 값을 저장해준다.
		if(loginData!=null) {								
			System.out.println("login ok!");
			HttpSession session=request.getSession();
			session.setAttribute("userId", loginData.getId());
		}else if(loginData==null){	//매핑이 되지 않는다면 체크포인트를 0으로 선언
			System.out.println("login fail!");
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);	// int형으로 리턴
	}
	
	
	@RequestMapping(value="/user/signup", method=RequestMethod.GET)	//사용자 가입폼
	public String regiview() throws Exception{
		return "register";
	}
	
	@RequestMapping(value="/user/siginup", method=RequestMethod.POST)	//사용자 가입
	@ResponseBody
	public int chk(@RequestBody Uservo uservo) throws Exception{	//요청한 데이터를 uservo로 받아주고
		System.out.println(uservo.getReg_date());
		String cut=uservo.getReg_date()+" 00:00:00";
		uservo.setReg_date(cut);
		int count=signService.idOverlap(uservo);	//아이디중복체크
		if(count==0) {								//중복되는 아이디가 있는지 카운트 해보고 없다면 인서트한다.
			signService.userSignup(uservo);
		}else {
			count=1;								//중복되는 아이디가 있다면 카운트가 1
		}	
		return count;								//int로 반환
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value="/user/dataLoad", method=RequestMethod.GET)
	public String dataload(Model model,Uservo uservo) throws Exception{
		model.addAttribute("loadData", signService.dataLoad(uservo));	//데이터를 리스트로 전부 가져와서 리턴한다.
		return "home";
	}
	

	
	
	
	
}

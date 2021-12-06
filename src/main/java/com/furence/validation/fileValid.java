package com.furence.validation;

public class fileValid {
	//컬럼수체크
	public boolean columnCheck(String one) {
		String[] cut=one.split("/");
		if(cut.length==6) {
			return true;			
		}else {
			return false;
		}
	}
	//데이터크기체크
	public boolean dataCheck(String one) {
		String[]dataC=one.split("/");
		if(dataC[0].length()<=16 && dataC[1].length()<=32 && dataC[2].length()<=128 && dataC[3].length()<=1 && dataC[4].length()<=256) {
			return true;			
		}else {
			return false;
		}
	}
	//널체크
	public boolean nullCheck(String one) {
		String[]nCheck=one.split("/");
		if(!nCheck[0].equals("") && !nCheck[1].equals("") && !nCheck[2].equals("") && !nCheck[3].equals("") && !nCheck[5].equals("")) {
			return true;			
		}else {
			return false;
		}
	}
	
}

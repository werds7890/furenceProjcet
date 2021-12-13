package com.furence.VO;

import java.util.HashMap;
import java.util.Map;

public class Filevo {
	int success=0;
	int fail=0;
	int total=0;
	private Map<Integer,String> map;
	
	
	
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = this.success+success;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = this.fail+fail;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = this.total+total;
	}
	
	
}

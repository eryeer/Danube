package com.wxbc.test;

import com.wxbc.register.RegisterService;
import com.wxbc.register.XMLOrger;
import com.wxbc.util.CommonParams;
import com.wxbc.util.FileUtils;

public class RegTest {
	public static void main(String[] args) {
		RegisterService loginReg = new RegisterService();
		String loginToken = loginReg.regLogin(CommonParams.USERNAME, CommonParams.USERPASSWORD);
		System.out.println(loginToken);
		String result = loginReg.enregister("AR", loginToken, "testXML001", new XMLOrger().enregisterContent(), FileUtils.getBytes("C:/Users/eryeer/Desktop/git/agreement.zip"));
		System.out.println(result);
		
	}

}

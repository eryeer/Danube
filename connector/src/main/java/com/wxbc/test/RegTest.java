package com.wxbc.test;

import com.wxbc.register.RegisterService;
import com.wxbc.register.XMLOrger;
import com.wxbc.util.CommonParams;
import com.wxbc.util.FileUtils;

public class RegTest {
	public static void main(String[] args) {
		RegisterService service = new RegisterService();
		String loginToken = service.regLogin(CommonParams.USERNAME, CommonParams.USERPASSWORD);
		System.out.println(loginToken);
//		String result = service.initRegister("AR", loginToken, "testXML001", new XMLOrger().initRegisterContent(), FileUtils.getBytes("C:/Users/eryeer/Desktop/git/agreement.zip"));
		String result = service.AmendRegister("AR", loginToken, "00862307000107283848",
				"357jrrv7", "testXML002", new XMLOrger().amendRegisterContent(),
				FileUtils.getBytes("C:/Users/eryeer/Desktop/git/agreement.zip"));
		System.out.println(result);
	}

}

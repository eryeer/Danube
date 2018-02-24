package com.wxbc.test;

import com.wxbc.query.QueryService;
import com.wxbc.util.CommonParams;

import java.io.*;
import java.net.URL;

public class QueryTest {
	public static void main(String[] args) throws IOException {
		QueryService service = new QueryService();
		String loginToken = service.queryLogin(CommonParams.USERNAME, CommonParams.USERPASSWORD);
		System.out.println(loginToken);
		byte[] enquery = service.enquerySubject(loginToken, "1", "1000", "万向钱潮股份有限公司", "true");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/eryeer/Desktop/git/test.zip")));
		bos.write(enquery);
		bos.close();
		System.out.println("下载文件完成");
	}
}

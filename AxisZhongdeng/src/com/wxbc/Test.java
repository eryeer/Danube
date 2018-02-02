package com.wxbc;

import java.util.Arrays;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.Base64;

import javax.xml.namespace.QName;

import org.apache.axis.encoding.XMLType;

import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Service;

import com.wxbc.util.DESUtils;

public class Test {
	private static String username = "WXBCTEST";
	private static String userPassword = "WXBC12345";
	private static String key = "jkdj!@#$%";

	public static void main(String[] args) {
		try {
			System.setProperty("javax.net.ssl.trustStore", "D:/ws.trustStore");
			System.setProperty("javax.net.ssl.trustStorePassword", "netconfig");
			String url = "https://ws.zhongdengwang.org.cn/rs_test/services/LoginService?wsdl";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			QName qn = new QName(
					"https://ws.zhongdengwang.org.cn/rs_test/services/LoginService",
					"login");
			call.setOperationName(qn);
			call.addParameter("username", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("userPassword", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.setReturnType(XMLType.SOAP_BASE64BINARY);
			Object[] args1 = new Object[] {
					DESUtils.encrypt(username, key).getBytes(),
					DESUtils.encrypt(userPassword, key).getBytes() };
			Object ss = call.invoke(args1);
			byte[] responses = (byte[]) ss;
			String string = new String(responses);
			System.out.println(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// import org.apache.axis.client.Call;
// import org.apache.axis.client.Service;
//
//
//
// public class Test {
// public static void testDocument() {
//
// try {
//
// String url =
// "https://wsquery.zhongdengwang.org.cn/rsquery_test/services/LoginService?wsdl";
//
//
// //client.keystore和client.truststore路径根据自己情况填写
// System.setProperty("javax.net.ssl.trustStore", "D:/wsquery.trustStore");
// System.setProperty("javax.net.ssl.trustStorePassword", "netconfig");
// //关键是上面几行代码，下面是调用Webservice常规步骤
//
// Service service = new Service();
// Call call = (Call) service.createCall();
// call.setTargetEndpointAddress( new java.net.URL(url) );
//
//
// call.setOperationName( "sayHello" );
// String result = (String) call.invoke( new Object[] {} );
//
//
// System.out.println( result );
//
// }
//
// public static void main(String[] args) {
// testDocument();
// }
// }

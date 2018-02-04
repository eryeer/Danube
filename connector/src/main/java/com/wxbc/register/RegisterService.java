package com.wxbc.register;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import com.wxbc.util.CommonParams;
import com.wxbc.util.DESUtils;

public class RegisterService {

	public RegisterService() {
		System.setProperty("javax.net.ssl.trustStore",
				CommonParams.TRUST_STORE_REGISTER_PATH);
		System.setProperty("javax.net.ssl.trustStorePassword", "netconfig");
	}

	public String enregister(String registerType, String loginToken,
			String xmlFileName, String xmlFileContent, byte[] attachmentsZip) {
		try {
			String url = "https://ws.zhongdengwang.org.cn/rs_test/services/InitRegisterService";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			QName qn = new QName(
					"https://ws.zhongdengwang.org.cn/rs_test/services/InitRegisterService",
					"enregister");
			call.setOperationName(qn);
			call.addParameter("registerType", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("loginToken", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("xmlFileName", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("xmlFileContent", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("attachmentsZip", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.setReturnType(XMLType.SOAP_BASE64BINARY);
			Object[] args1 = new Object[] {
					registerType.getBytes(),
					DESUtils.encrypt(loginToken, CommonParams.KEY_REGISTER)
							.getBytes(),
					xmlFileName.getBytes("utf-8"),
					DESUtils.encrypt(xmlFileContent, CommonParams.KEY_REGISTER)
							.getBytes(), attachmentsZip };
			Object ss = call.invoke(args1);
			byte[] responses = (byte[]) ss;
			String result = new String(responses);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String regLogin(String username, String userPassword) {
		try {
			String url = "https://ws.zhongdengwang.org.cn/rs_test/services/LoginService";
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
					DESUtils.encrypt(CommonParams.USERNAME,
							CommonParams.KEY_REGISTER).getBytes(),
					DESUtils.encrypt(CommonParams.USERPASSWORD,
							CommonParams.KEY_REGISTER).getBytes() };
			Object ss = call.invoke(args1);
			byte[] responses = (byte[]) ss;
			return new String(responses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

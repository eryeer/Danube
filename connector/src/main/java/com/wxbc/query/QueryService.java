package com.wxbc.query;

import com.wxbc.util.CommonParams;
import com.wxbc.util.DESUtils;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class QueryService {
	
	public QueryService() {
		System.setProperty("javax.net.ssl.trustStore",
				CommonParams.TRUST_STORE_QUERY_PATH);
		System.setProperty("javax.net.ssl.trustStorePassword", "netconfig");
	}

	public byte[] enquerySubject(String loginToken, String querytype, String depttype,
			String name, String confirm) {
		try {
			String url = "https://wsquery.zhongdengwang.org.cn/rsquery_test/services/QuerySubjectService?wsdl";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			QName qn = new QName(
					"https://wsquery.zhongdengwang.org.cn/rsquery_test/services/QuerySubjectService",
					"enquery");
			call.setOperationName(qn);
			call.addParameter("loginToken", XMLType.SOAP_BASE64BINARY, ParameterMode.IN);
			call.addParameter("querytype", XMLType.SOAP_BASE64BINARY, ParameterMode.IN);
			call.addParameter("depttype", XMLType.SOAP_BASE64BINARY, ParameterMode.IN);
			call.addParameter("name", XMLType.SOAP_BASE64BINARY, ParameterMode.IN);
			call.addParameter("confirm", XMLType.SOAP_BASE64BINARY, ParameterMode.IN);
			call.setReturnType(XMLType.SOAP_BASE64BINARY);
			Object[] args1 = new Object[] {
					DESUtils.encrypt(loginToken, CommonParams.KEY_A_QUERY).getBytes(),
					DESUtils.encrypt(querytype, CommonParams.KEY_B_QUERY).getBytes(),
					DESUtils.encrypt(depttype, CommonParams.KEY_B_QUERY).getBytes(),
					DESUtils.encrypt(name, CommonParams.KEY_B_QUERY).getBytes(),
					DESUtils.encrypt(confirm, CommonParams.KEY_B_QUERY).getBytes()
					};
			Object ss = call.invoke(args1);
			return (byte[]) ss;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public String queryLogin(String username, String userPassword) {
		try {
			String url = "https://wsquery.zhongdengwang.org.cn/rsquery_test/services/LoginService";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(url);
			QName qn = new QName(
					"https://wsquery.zhongdengwang.org.cn/rsquery_test/services/LoginService",
					"login");
			call.setOperationName(qn);
			call.addParameter("username", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.addParameter("userPassword", XMLType.SOAP_BASE64BINARY,
					ParameterMode.IN);
			call.setReturnType(XMLType.SOAP_BASE64BINARY);
			Object[] args1 = new Object[] {
					DESUtils.encrypt(CommonParams.USERNAME,
							CommonParams.KEY_A_QUERY).getBytes(),
					DESUtils.encrypt(CommonParams.USERPASSWORD,
							CommonParams.KEY_A_QUERY).getBytes() };
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

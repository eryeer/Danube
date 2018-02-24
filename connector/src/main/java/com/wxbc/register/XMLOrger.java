package com.wxbc.register;

import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLOrger {
	public static void main(String[] args) {
		XMLOrger xmlOrger = new XMLOrger();
		String content = xmlOrger.amendRegisterContent();
		System.out.println(content);
	}

	public String amendRegisterContent(){
		// 创建Document对象
		Document document = DocumentHelper.createDocument();
		Element register = document.addElement("register");
		Element authperson = register.addElement("authperson");
		authperson.setText("尔康");
		Element title = register.addElement("title");
		title.setText("TestAmend001");
		Element amenditems = register.addElement("amenditems");
		amenditems.addElement("debtoritem");
		//====出质人====//
		Element debtors = register.addElement("debtors");
		Element debtor = debtors.addElement("debtor");
		debtor.addAttribute("id", "1");
		Element debtortype = debtor.addElement("debtortype");
		debtortype.setText("02");
		Element debtorname = debtor.addElement("debtorname");
		debtorname.setText("上海非专用测试有限公司");
		Element certificatecode1 = debtor.addElement("certificatecode");
		certificatecode1.setText("123456789987654321");
		Element industryregistrationcode1 = debtor.addElement("industryregistrationcode");
		industryregistrationcode1.setText("123456789987654321");
		Element corporationname1 = debtor.addElement("corporationname");
		corporationname1.setText("赵大军");
		Element industrycode1 = debtor.addElement("industrycode");
		industrycode1.setText("C");
		Element corporationscale1 = debtor.addElement("corporationscale");
		corporationscale1.setText("10");
		Element address1 = debtor.addElement("address");
		Element nationality1 = address1.addElement("nationality");
		nationality1.setText("CHN");
		Element province1 = address1.addElement("province");
		province1.setText("220000");
		Element city1 = address1.addElement("city");
		city1.setText("220100");
		Element detailaddress1 = address1.addElement("detailaddress");
		detailaddress1.setText("岸边路202号");
		Element agreements = register.addElement("agreements");
		Element agreement = agreements.addElement("agreement");
		Element agreementname = agreement.addElement("agreementname");
		agreementname.setText("agreement.jpg");
		try {
			return outputXmltoString(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String initRegisterContent() {
		// 创建Document对象
		Document document = DocumentHelper.createDocument();
		Element register = document.addElement("register");
		Element businesstype = register.addElement("businesstype");
		businesstype.setText("A00102");
		Element timelimit = register.addElement("timelimit");
		timelimit.setText("0.5");
		Element title = register.addElement("title");
		title.setText("TestDoc001");
		//====出质人====//
		Element debtors = register.addElement("debtors");
		Element debtor = debtors.addElement("debtor");
		debtor.addAttribute("id", "1");
		Element debtortype = debtor.addElement("debtortype");
		debtortype.setText("02");
		Element debtorname = debtor.addElement("debtorname");
		debtorname.setText("上海专用测试有限公司");
		Element certificatecode1 = debtor.addElement("certificatecode");
		certificatecode1.setText("123456789987654321");
		Element industryregistrationcode1 = debtor.addElement("industryregistrationcode");
		industryregistrationcode1.setText("123456789987654321");
		Element corporationname1 = debtor.addElement("corporationname");
		corporationname1.setText("赵大军");
		Element industrycode1 = debtor.addElement("industrycode");
		industrycode1.setText("C");
		Element corporationscale1 = debtor.addElement("corporationscale");
		corporationscale1.setText("10");
		Element address1 = debtor.addElement("address");
		Element nationality1 = address1.addElement("nationality");
		nationality1.setText("CHN");
		Element province1 = address1.addElement("province");
		province1.setText("220000");
		Element city1 = address1.addElement("city");
		city1.setText("220100");
		Element detailaddress1 = address1.addElement("detailaddress");
		detailaddress1.setText("岸边路202号");
		//====质权人====//
		Element debtees = register.addElement("debtees");
		Element debtee = debtees.addElement("debtee");
		debtee.addAttribute("id", "1");
		Element debteetype = debtee.addElement("debteetype");
		debteetype.setText("02");
		Element debteename = debtee.addElement("debteename");
		debteename.setText("上海质权测试有限公司");
		Element certificatecode2 = debtee.addElement("certificatecode");
		certificatecode2.setText("gggfffgggfffgggfff");
		Element industryregistrationcode2 = debtee.addElement("industryregistrationcode");
		industryregistrationcode2.setText("gggfffgggfffgggfff");
		Element corporationname2 = debtee.addElement("corporationname");
		corporationname2.setText("王小丽");
		Element industrycode2 = debtee.addElement("industrycode");
		industrycode2.setText("C");
		Element corporationscale2 = debtee.addElement("corporationscale");
		corporationscale2.setText("10");
		Element address2 = debtee.addElement("address");
		Element nationality2 = address2.addElement("nationality");
		nationality2.setText("CHN");
		Element province2 = address2.addElement("province");
		province2.setText("220000");
		Element city2 = address2.addElement("city");
		city2.setText("220100");
		Element detailaddress2 = address2.addElement("detailaddress");
		detailaddress2.setText("岸边路202号");
		//====质押财产====//
		Element pledgeinfo = register.addElement("pledgeinfo");
		Element collateraldescribe = pledgeinfo.addElement("collateraldescribe");
		collateraldescribe.setText("hfusahdfuaisduhf");
		//====应收账款附件====//
		Element agreements = register.addElement("agreements");
		Element agreement = agreements.addElement("agreement");
		Element agreementname = agreement.addElement("agreementname");
		agreementname.setText("agreement.jpg");
		try {
			return outputXmltoString(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private String outputXmltoString(Document document) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		StringWriter stringWriter = new StringWriter();
		XMLWriter writer = new XMLWriter(stringWriter, format);
		// 设置不自动进行转义
		writer.setEscapeText(false);
		writer.write(document);
		writer.close();
		String content = stringWriter.toString();
		return content;

	}

}

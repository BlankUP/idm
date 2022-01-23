package com.idm.test;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Optional;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/**
 * 给xml工具类增加行号
 */
public class Test000 {
	public static void main(String[] args) throws DocumentException {
		String dd = "<Application>\r\n" + 
				"<ApplyInfo apply_event_type=\"2\"/>\r\n" + 
				"<ExtInfo/>\r\n" + 
				"<DecisionResponse>\r\n" + 
				"		<Decision apply_id=\"NA\" credit_limit=\"-999.0\" credit_lock_time=\"1900-01-01\" decision_id=\"NA\" eff_date=\"1900-01-01\" exp_date=\"1900-01-01\" final_decision=\"NA\" refuse_code_list=\"NA\" ret_code=\"104\" rule_code_list=\"NA\" version_id=\"v1.0.1_20200822\"/>\r\n" + 
				"		<DerivedVars DerivedDou1=\"-999.0\" DerivedDou2=\"-999.0\" DerivedDou3=\"-999.0\" DerivedDou4=\"-999.0\" DerivedDou5=\"-999.0\" DerivedInt1=\"-999\" DerivedInt2=\"-999\" DerivedInt3=\"-999\" DerivedInt4=\"-999\" DerivedInt5=\"-999\" DerivedStr1=\"NA\" DerivedStr2=\"NA\" DerivedStr3=\"NA\" DerivedStr4=\"NA\" DerivedStr5=\"NA\"/>\r\n" + 
				"	</DecisionResponse>\r\n" + 
				"<ProcessingHistory>\r\n" + 
				"		<DecisionFlowHistory>\r\n" + 
				"			<DecisionFlowStep ImplementationName=\"返回变量值初始化\" ImplementationType=\"Funciton\" StepIndex=\"1\"/>\r\n" + 
				"		</DecisionFlowHistory>\r\n" + 
				"	</ProcessingHistory>\r\n" + 
				"<MessageList/>\r\n" + 
				"</Application>";
		InputStream stringToInputStream = Transfer.StringToInputStream(dd);
		Locator locator = new LocatorImpl();
		DocumentFactory docFactory = new DocumentFactoryWithLocator(locator);
		SAXReader reader = new GokuSAXReader(docFactory, locator);
//		Document doc = reader.read(new File("C:\\Users\\86132\\Desktop\\常用\\output.xml"));
		Document doc = reader.read(stringToInputStream);
		System.out.println(doc.asXML());
		Element rootElement = doc.getRootElement();
		Iterator elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			Element next = (Element)elementIterator.next();
			System.out.println(((GokuElement) next).getLineNumber());
			
			Iterator elementIterator1 = next.elementIterator();
			while (elementIterator1.hasNext()) {
				Element next1 = (Element)elementIterator1.next();
				System.out.println(((GokuElement) next1).getLineNumber());
				
			}
		}
		System.out.println(((GokuElement) rootElement).getLineNumber());
	}

}

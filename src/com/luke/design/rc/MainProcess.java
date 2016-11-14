package com.luke.design.rc;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class MainProcess {

	/**
	 * 责任链的好处是，所有的过滤器的名称，可以写在配置文件中，程序读出，然后用反射方法New出，添加到过滤链中，一个循环可以实现
	 * 这样就可以动态的增加或是减少过滤器，不用修改主程序。
	 * 所有的过滤器，只要实现接口Filter就可以了。
	 */
	
	public static void main(String[] args) {

		String strMain = "测试字符串， <Script>， 敏感字，继续测试程序。";
		FilterChain fc = new FilterChain();

		try {
			//读取XML文档，得到所有需要加载的Filter，这些Filter可以直接在XML中修改，并改变顺序。
			File f = new File("FiltersList.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			
			//得到Filter tag，读取其中的类名
			NodeList nl = doc.getElementsByTagName("Filter");
			for (int i = 0; i < nl.getLength(); i++) {
				
				//这里使用了反射，动态new出新类，并添加到FilterChain中。
				fc = fc.addFilter((Filter) Class.forName(
						doc.getElementsByTagName("Value").item(i)
								.getFirstChild().getNodeValue()).newInstance());
			}
			
			//模拟HTTP请求，创建一个请求对象和一个返回对象。
			Request req = new Request();
			Response reps = new Response();
			
			//将要处理的字符串交给请求对象处理。
			req.setRequestStr(strMain);
			reps.setResponseStr("response");
			
			//使用责任链设计思想，使用所有加载的filter过滤字符串。
			fc.doFilter(req, reps, fc);
			
			System.out.println(req.getRequestStr());
			System.out.println(reps.getResponseStr());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.ouyang.velocity;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

public class SimpleVelocityTest {

	public Template initTemplate() throws Exception {
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.put("file.resource.loader.class",
		"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");     
		ve.init(p);
		return ve.getTemplate("/vm/simple-velocity.vm");
	}
	
	public VelocityContext wrapVelocityContext(){
		VelocityContext context = new VelocityContext();
		context.put("name", "Ouyang");
		context.put("date", new Date());
		List<String> list = new ArrayList<String>();
		list.add("要梳理配置");
		list.add("要梳理系统与之间关系");
		list.add("要梳理改造改造......");
		context.put("list", list);
		return context;
	}
	@Test
	public void testOutputString() throws Exception {
		Template t = initTemplate();
		VelocityContext context = wrapVelocityContext();
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		System.out.println(writer.toString());
	}
	
	@Test
	public void testOutputHtml() throws Exception {
		Template t = initTemplate();
		VelocityContext context = wrapVelocityContext();
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("d:/dev/test.html"),"UTF-8");
		out.write(writer.toString());
		out.close();
		System.out.println("ok................");
	}
}

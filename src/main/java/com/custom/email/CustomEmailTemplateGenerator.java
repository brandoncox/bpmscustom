package com.custom.email;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public final class CustomEmailTemplateGenerator {

	public static String templateizeEmail(String taskName) {
		
		 Properties props = new Properties();
		 props.setProperty("resource.loader", "class");
	     props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	     VelocityEngine velocityEngine = new VelocityEngine(props);
		
		velocityEngine.init(props);
		
		System.out.println(velocityEngine);
		    
		Template t = velocityEngine.getTemplate("SimpleEmail.vm");
		     
		VelocityContext context = new VelocityContext();
		context.put("taskName", taskName);
		     
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println(writer.toString());
		return writer.toString();
	}
	
	public static void main (String[] args) {
		CustomEmailTemplateGenerator.templateizeEmail("somename");
	}
}

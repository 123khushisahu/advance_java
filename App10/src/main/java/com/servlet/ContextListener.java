package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//@WebListener
public class ContextListener implements ServletContextListener,ServletContextAttributeListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("CONTEXT OBJECT SYSTEM!!!");
		ServletContext context=sce.getServletContext();
		System.out.println("project is deployed into:"+context.getServerInfo());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context object destroyed!!");
		
	}
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("attribute added to the context object");
		System.out.println("ATTRIBUTE NAME"+scae.getName());
		ServletContextAttributeListener.super.attributeAdded(scae);
	}
	public void attributeDestroyed() {
		System.out.println("attribute removed fromcontext object");

	}
	
		{
	}

}

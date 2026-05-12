package com.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{
	public void sessinCreated(HttpSessionEvent hse) {
		System.out.println("SESSION CREATED");
		

	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SESSION DESTROYED");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent 	hsbe) {
		System.out.println("ATTRIBUTE ADDED"+hsbe.getName());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		System.out.println("ATTRIBUTE REMOVED FROM THE SESSION"+hsbe.getName());
		
			}

}

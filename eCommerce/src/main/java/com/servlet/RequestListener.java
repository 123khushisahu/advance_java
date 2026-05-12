package com.servlet;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;//ctrl+shift+o

//@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("REQUEST OBJECT INITIALIZED!!!!");
		
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("REQUEST OBJECT DESTROYED");
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ATTRIBUTE ADDED TO THE OBJECT");
		System.out.println("ATTRIBUTE NAME"+srae.getName());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ATTRIBUTE FROM THE REQUEST OBJECT");
		System.out.println("ATTRIBUTE NAME"+srae.getName());
	}
	

}

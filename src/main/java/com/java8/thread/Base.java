package com.java8.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Base  {

	//@Autowired
	private Derived derived;
	/*
	 * @Autowired public void setDerived(Derived derived) { this.derived = derived;
	 * }
	 */
	
	
	  @Autowired public Base(Derived derived) { this.derived = derived; }
	 
	
}

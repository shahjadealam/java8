package com.java8.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Derived
{
	
	@Autowired
	private Base base;
	/*
	 * @Autowired public void setBase(Base base) { this.base = base; }
	 */
	
	  @Autowired public Derived(@Lazy Base base) { this.base = base; }
	 
	
	
	
}

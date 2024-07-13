package com.loki.basic.dsa.designpatterns;

import java.io.Serializable;



public class Singleton implements Serializable {

	//private static final Singleton INSTANCE = new Singleton();
	private static final long serialVersionUID = 1L;
	
	private static class singleLoader{
		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton(){ 
		if (singleLoader.INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}}

	public static Singleton getInstance(){
		return singleLoader.INSTANCE;
	}
	
	// only one instance will be created
	private Singleton readResolve(){
		return singleLoader.INSTANCE;
	}

	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("can not create clone of the singleton class");
	}

}

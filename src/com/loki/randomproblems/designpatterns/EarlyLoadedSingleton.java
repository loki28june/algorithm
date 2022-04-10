package com.loki.randomproblems.designpatterns;

import java.io.Serializable;

public final class EarlyLoadedSingleton implements Cloneable , Serializable{
	private static final long serialVersionUID = 1L;
	private static final EarlyLoadedSingleton _instance = new EarlyLoadedSingleton();

	private EarlyLoadedSingleton() {
		if (_instance != null) {
			throw new IllegalStateException("Instance already created");
		}
	}

	public static EarlyLoadedSingleton getInstance() {
		return _instance;
	}

	public Object Clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public EarlyLoadedSingleton readResolve(){
		return _instance;
	}


}

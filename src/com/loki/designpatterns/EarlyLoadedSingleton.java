package com.loki.designpatterns;

public final class EarlyLoadedSingleton {
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


}

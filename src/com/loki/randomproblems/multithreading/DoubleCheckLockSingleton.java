package com.loki.randomproblems.multithreading;

public final class DoubleCheckLockSingleton {

	private static final long serialVersionUID = 1L;
	private volatile static DoubleCheckLockSingleton INSTANCE;
	

	// taking care of code break due to reflection
	private DoubleCheckLockSingleton() {
		if (INSTANCE != null) {
			throw new IllegalStateException("already instatntiated");
		}

	}

	// take care of the clone
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("clone of this class cannot be created");

	}

	
	// return single copy of object on deserialization
	public DoubleCheckLockSingleton readResolve() {
		return INSTANCE;
	}

	public static DoubleCheckLockSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckLockSingleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckLockSingleton();
				}
			}
		}
		return INSTANCE;

	}

	public static void main(String[] args) {
		

	}

}

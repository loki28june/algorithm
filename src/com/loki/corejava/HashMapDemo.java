package com.loki.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>(32);
		
		map.put(1,"lokesh");
		map.put(2,"anurraj");
		map.put(3, "vicky");
		
		Set<Entry<Integer, String>> set = map.entrySet();
		
		for(Map.Entry<Integer, String> pair : set){
			System.out.println("key is => " + pair.getKey());
			System.out.println("value is => " + pair.getValue());
		}
		

	}

}

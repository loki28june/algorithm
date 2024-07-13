package com.loki.basic.dsa.corejava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class PropertyWriteDemo {

	public static void main(String[] args) {
		
		ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
		
		OutputStream out = null;
		try {
			out = new FileOutputStream("config.properties");
			Properties p = new Properties();
			p.setProperty("database_url", "jdbc:mysql//localhost:3306");
			p.setProperty("user", "lokesh");
			p.setProperty("password","lokesh123");
			
			p.store(out,null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			
			if(out != null)
				try{
					out.close();
				}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		

	}

}

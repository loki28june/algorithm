package com.loki.corejava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {


	public static void readFile(){
		File file = new File("D:\\loki.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			StringBuilder sb = new StringBuilder();

			String line;
			while((line =br.readLine()) != null){
				sb.append(line);
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	public static void writeToFile(String filename){
		String content = "hey bro what's going on";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true))){
			bw.write(content);
			bw.write("\n");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static boolean createFile(String filename) {

		File f;
		if(null != filename){
			f = new File(filename);
		}
		else{
			f = new File("D:\\loki.txt");
		}
		try {
			if (f.createNewFile()) {
				System.out.println("file created");
			} else {
				System.out.println("file already exists or operation failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static void fileSeparator(){
		String filename = "demo.txt";
		String workingDir = System.getProperty("user.dir");
		String absPath = workingDir + File.separator + filename;
		// or 
		// File file = new File(workingDir, filename);
		System.out.println(absPath);
		createFile(absPath);
	}
	
	public static void delete(String f){
		File file = new File(f);
		if(file.exists()){
			file.delete();
		}
	}

	public static void main(String[] args) {
		// createFile(null);
		/// fileSeparator();
		// readFile();
		//writeToFile("D:\\loki.txt");
		//delete("D:\\loki.txt");
		System.out.println(System.getProperty("user.dir"));
	}

}

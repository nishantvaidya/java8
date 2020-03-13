package com.test.java8;

import java.io.File;
import java.io.FileFilter;

public class Lambda {
	
	public static void main(String[] args) throws InterruptedException {
		FileFilter filter = new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
		File dir = new File("C:/workspace-mars/java_8_examples/src/com/test");
		File[] files = dir.listFiles((File file) -> file.getName().endsWith(".java"));
		for(File f : files){
			System.out.println(f.getAbsolutePath());
		}
		Runnable run = new Runnable(){
			@Override
			public void run() {
				for(int i = 0 ; i<3; i++){
				System.out.println(
						"Hello world from therad [" +
						Thread.currentThread().getName() +
						"]");
			}
			}
		};
		Runnable run1 = () -> {
			for(int i = 0 ; i<3; i++){
				System.out.println(
						"Hello world from therad [" +
						Thread.currentThread().getName() +
						"]");
			};
		};
		Thread t = new Thread(run1);
		t.start();
		t.join();
	}
	
	
	
	

}

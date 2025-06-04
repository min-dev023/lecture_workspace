package com.sinse.ThreadApp;

public class ThreadB extends Thread{
	public void run() {
		for(int i = 0; i < 30; i++) {
        	System.out.println("B");
        }
	}
}

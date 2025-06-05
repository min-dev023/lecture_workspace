package com.sinse.ThreadApp.ani;

import javax.swing.JProgressBar;

public class ProgressThread extends Thread{
	
	JProgressBar bar;
	int n;
	int velX;
	
	
	public ProgressThread(JProgressBar bar, int velX) {
		this.bar = bar;
		this.velX = velX;
	}
	
	public void run() {
		while(n <= 100) {
			try {
				Thread.sleep(10);
				bar.setValue(n);
				n = n + velX;
				System.out.println(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

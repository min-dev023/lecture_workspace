package com.sinse.ThreadApp.ani;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameAni2 extends JFrame{
	JPanel p_center;
	
	Image[] imgArray = new Image[18];
	Thread thread;
	
	int n = 0;
	
	public FrameAni2() {
		createImg(); // 패널이 그림을 그리기 전에 배열을 완성해야 하므로
		
		p_center = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.drawImage(imgArray[n], 200, 200, 100, 100, p_center);
			}
		};
		
		thread = new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						n++;
						if(n >= imgArray.length) n = 1;
						p_center.repaint();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		};
		
		
		p_center.setBackground(Color.BLUE);
		
		thread.start(); // jvm에게 runnable 상태로의 진입을 부탁. --> jvm는 os에게 native 쓰레드 생성을 요청
		// 조립
		this.add(p_center);
		
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createImg() {
		for(int i = 0; i < 18; i++) {
			URL url = this.getClass().getClassLoader().getResource("hero/image" + (i+1) + ".png");
			try {
				BufferedImage buffrImg = ImageIO.read(url);
				Image img = buffrImg.getScaledInstance(213,  200, Image.SCALE_SMOOTH);
				imgArray[i] = buffrImg; // 배열의 i번째 요소로, 이미지 넣기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new FrameAni2();
	}
}

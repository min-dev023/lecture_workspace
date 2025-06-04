package com.sinse.ThreadApp.ani;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sinse.ThreadApp.ani.ImageUtil;

public class FrameAni extends JFrame{
	JPanel p_center;
	JPanel p_img;
	ImageUtil imageUtil = new ImageUtil();
	Image image;
	Thread thread;
	
	int num = 1;
	
	public FrameAni() {
		p_center = new JPanel();
		
		
		
		
		draw();
		thread = new Thread() {
			// 개발자는 쓰레드로 구현하고 싶은 코드를 run() 메서드 안에 넣어두어야 한다.
			public void run() {
				while(true) {

					draw();
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		
	
		
		// 스타일
		p_img.setPreferredSize(new Dimension(100, 100));
		
		p_center.setBackground(Color.BLUE);
		
		// 조립
		p_center.add(p_img);
		
		
		this.add(p_center);
		
		thread.start();
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void draw() {
		System.out.println(num);
		if(num >= 18) {
			num = 1;
		}
		num++;
		image = imageUtil.getImage("hero/image" + num + ".png", 100, 100);
	
		
		p_img = new JPanel() { // 익명 내부 클래스
			protected void paintComponent(Graphics g) {
				super.paintComponent(g); // super를 남겨야 update()에 지워진 배경을 스스로 복구함.
				
				g.drawImage(image, 0, 0, 100, 100, p_img);
			}
		};
		p_center.repaint();
	}
	
	public static void main(String[] args) {
		new FrameAni();
	}
}

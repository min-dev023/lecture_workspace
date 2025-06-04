package com.sinse.ThreadApp.ani;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 사각형을 이동시켜보자 (지우고 그리기를 반복)

public class RectMove extends JFrame{
	JPanel p_north;
	JPanel p_center;
	JButton bt;
	int x, y;
	
	Thread thread;
	
	public RectMove() {
		p_north = new JPanel();
		p_center = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.fillRect(10 + x, 10 + y, 50, 50);
			}
		};
		
		thread = new Thread() {
			// 개발자는 쓰레드로 구현하고 싶은 코드를 run() 메서드 안에 넣어두어야 한다.
			public void run() {
				while(true) {
					move();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		
		
		bt = new JButton("동작");
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		p_north.add(bt);
		p_north.setBackground(Color.YELLOW);
		this.add(p_north, BorderLayout.NORTH);
		this.add(p_center);
		
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void move() {
		x++;
		y++;
		p_center.repaint(); // update() 지우고, paint() 호출
	}
	
	public static void main(String[] args) {
		new RectMove();
	}
}

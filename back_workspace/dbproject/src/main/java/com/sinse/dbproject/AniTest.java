package com.sinse.dbproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AniTest extends JFrame{
	/* 자바의 모든 컴포넌트는 스스로를 그린다.. 하지만 개발자가 그림을 뺏어도 되는
	 * 컴포넌트는 주로 내용이 비어있는 컨테이너 유형... */
	
	JButton bt;
	JPanel p_center;
	int x;
	int y;
	
	public AniTest() {
//		bt = new JButton("이동");
		bt = new JButton() {
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.RED);
				g.fillRect(0, 0, 70, 30);
			}
		};
		
		p_center = new JPanel() {
			public void paint(Graphics g) {
				super.paint(g); // 지우지 말기
				
				g.drawRect(x, y, 200, 200);
			}
		};
		
		add(bt, BorderLayout.NORTH);
		add(p_center);
		
		bt.addActionListener(new ActionListener(){ // 익명 내부 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 20;
				y += 20;
				p_center.repaint();
			}
		});
		
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AniTest();
	}
}

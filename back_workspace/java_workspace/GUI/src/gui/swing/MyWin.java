/*
AWT는 자바의 초창기 GUI 패키지임은 맞지만, os마다 다른 디자인으로 실행되었음. (mac, win)
Swing은 os 즉 플랫폼에 상관없이 중립적인 Look&Feel 디자인을 유지한다.
요즘은 Swing처럼 os에 어울리지 않는 java 최적화 디자인을 지양함. 따라서 javaFX가 지원됨.
Swing은 기존의 awt를 계승했기 때문에 우리가 사용해왔던 awt 컴포넌트 명에 J접두어만 붙인다.
*/
package gui.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  MyWin extends JFrame implements ActionListener
{
	JTextArea area;
	JPanel p_south;
	JButton bt;
	
	public MyWin() {
		area = new JTextArea(4, 15); // 행, 열
		p_south = new JPanel();
		bt = new JButton("환경설정");
		
		// area에 배경 추가
		area.setBackground(Color.YELLOW);
		
		add(area); // 센터에 부착
		p_south.add(bt); // 남쪽 패널에 버튼 부착
		add(p_south, BorderLayout.SOUTH);
		
		bt.addActionListener(this); // 리스너 구현한 자의 인스턴스
		
		//setSize(300, 400);
		setBounds(500, 500, 300, 400);
		setVisible(true);
	}
	
	// 부모의 메서드 오버라이딩
	public void actionPerformed(ActionEvent e){
		System.out.println("버튼누름");
		// this 란? 인스턴스가 자가 자신을 가리키는 레퍼런스 변수명이다.
		// 개발자가 마음대로 정한 이름이 아니라, 시스템에서 정해놓은 레퍼런스 변수명
		new Config(this);
	}
	
	public static void main(String[] args) 
	{
		new MyWin();
	}
}

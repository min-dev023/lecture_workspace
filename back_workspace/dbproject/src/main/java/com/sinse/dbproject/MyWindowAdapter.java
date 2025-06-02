package com.sinse.dbproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * KeyListener, WindowListener 등 재정의할 메서드가 3개 이상되는 인터페이스의 경우,
 * 개발자 대신 이미 java api 차원에서, 즉 우리 대신 리스너 인터페이스를 구현해놓은 중간 객체들을 
 * 가리켜 어댑터 라고 한다. (마치 전자제품과 220v사이의 완충 장치의 역할과 동일)
 * - 우리 대신 메서드를 재정의해놓았기 때문에 개발자는 구현 의무가 없음
 * */
public class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.out.println("창을 닫음");
	}
}

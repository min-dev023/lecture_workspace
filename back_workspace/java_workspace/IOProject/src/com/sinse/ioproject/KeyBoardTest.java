package com.sinse.ioproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardTest {
	public static void main(String[] args) {
		// 모든 프로그래밍 언어에서는 os가 이미 제공하는 표준 스트림에 대해서는
		// 개발자가 직접 생성 및 관리하지 않아도 된다. why? 이미 os 부팅 시 부터 준비가 되어있으므로
		// 자바에서의 우리가 지금까지 써왔던 System.out 표준 출력스트림이므로 그냥 가져다 쓰면 됨
		// System.in 을 이용하면 키보드로부터 들어온 데이터를 입력받을 수 있다.
		// 주의! 사용 후 우리 것이 아니므로 닫지 않는다.
		
		InputStream is = System.in; // 입력 스트림의 최상위 객체인 그냥 입력 스트림을 받는다
		InputStreamReader reader = new InputStreamReader(is); // 파일전용, 키보드, 스캐너...
		
		int data = -1;
		try {
			while(true) {
				data =	reader.read();  
				// read()는 실행부가 입력이 발생할 때까지 대기 상태에 빠지므로, 무한반복문에 사용가능
				System.out.print((char)data);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.sinse.ioproject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// 대량의 데이터를 읽어보자
public class StreamTuning {
	FileInputStream fis; // 바이트 기반 입력 스트림
	
	// 효율성을 떠나, 한글이 깨지지 않고 나오게 하기 위해 기존 스트림에 문자 기반 스트림을 덧씌우자
	InputStreamReader reader; // 한 문자씩 읽음..
	
	// 한 줄을 만날 때까지는 입력을 보류하다가, 한 줄의 끝인 줄바꿈 특수문자를 만나면 그제서야 한번 읽어들이는
	// 즉 버퍼를 이용한 문자열 처리 전용 입력 스트림으로 업그레이드
	BufferedReader buffr;
	InputStreamReader is;
	
	String name = "C:/lecture_workspace/back_workspace/java_workspace/IOProject/res/memo.txt";
	
	public StreamTuning() {
		try {
			fis = new FileInputStream(name);
			
			// 빨대 업그레이드
			reader = new InputStreamReader(fis);
			
			is = new InputStreamReader(fis);
			// 버퍼 처리된 빨대로 업그레이드
			buffr = new BufferedReader(is);
			
			//int data = -1;
			int count = 0; // 읽은 횟수 체크용 변수
			
			String data = null;
			
			while(true) {
				//data = fis.read();
				//data = reader.read();
				data += buffr.readLine();
				if(data == null) break;
				System.out.print(data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffr != null) {
				try {
					buffr.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new StreamTuning();
	}

}

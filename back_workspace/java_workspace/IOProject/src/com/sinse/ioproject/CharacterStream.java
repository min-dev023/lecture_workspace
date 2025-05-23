package com.sinse.ioproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 스트립의 분류
 * 1) 방향
 * 	- 입력
 * 	- 출력
 * 2) 데이터 처리 방법
 * 	- 바이트 : 1byte씩 -> 근본
 * 	- 문자 : 1문자씩 (문자 이해 스트림)
 * 	- 버퍼기반 
 * */
public class CharacterStream {
	
	// 바이트 기반 스트림의 특징 : 입력 ~~InputStream, 출력 ~~OutputStream
	// 문자 기반 스트림 : 입력~~ Reader, 출력 ~~Writer
	FileInputStream fis; // 파일을 대상으로 한 바이트 기반의 입력 스트림
	FileOutputStream fos; // 파일을 대상으로 한 바이트 기반의 출력 스트림
	InputStreamReader is; // 기존에 존재하는 바이트 기반의 입력 스트림에 덧붙여 사용
	OutputStreamWriter os; // 기존에 존재하는 바이트 기반의 출력스트림에 덧붙여 사용
	// 결론 : 모든 스트림의 기반 스트림은 바이트 기반 스트림이다!
	// 바이트 기반의 스트림만 존재한다면 얼마든지, 문자기반으로 업그레이드 할 수 있음
	
	// 아래의 두 클래스는 파일에 국한되므로, 파일 관련된 작업에만 유용하므로, 범용성 떨어짐
	
	FileReader reader; // 파일을 대상으로 한 문자 기반 입력 스트림(문자 깨지지 않음)
								// 1byte씩 읽어들이는 것이 아니라, 한 문자씩 읽음(문자 안깨짐)
	FileWriter writer;
	
	String name = "C:/lecture_workspace/back_workspace/java_workspace/IOProject/res/memo.txt";
	String name2 = "C:/lecture_workspace/back_workspace/java_workspace/IOProject/res/memo_copy.txt";
	
	public CharacterStream() {
		try {
			fis = new FileInputStream(name);
			fos = new FileOutputStream(name2);
			
			is = new InputStreamReader(fis); // 빨대가 2단계로 업그레이드
			os = new OutputStreamWriter(fos);
			
			// 실행중인 프로그램으로 메모장을 구성하는 데이터를 입력해보자.
			int data = -1;
			
			while(true) {
				// data = fis.read(); // 한 알갱이
				data = is.read(); // 한 문자 (1 byte)
				
				if(data == -1) break;
				
				// 읽어들인 데이터를 다시내뱉기.. 빈 empty 파일을 대상으로.
				//fos.write(data);
				os.write(data);
				System.out.print((char)data);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			*/
			if(is != null) {
				try {
					is.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
			if(os != null) {
				try {
					os.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new CharacterStream();
	}
}

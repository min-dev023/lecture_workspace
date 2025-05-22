/*
메모장과 같은 텍스트 파일이 아닌, 이미지 동영상 등의 바이너리 파일을 읽기.
*/
package gui.io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class  BinaryLoader
{
	FileInputStream fis; // 파일을 대상으로 한 입력 스트림
	FileOutputStream fos;
	String name = "C:/lecture_workspace/back_workspace/java_workspace/res/ha.png";
	String target = "C:/lecture_workspace/back_workspace/java_workspace/res/ha.png";
	
	public BinaryLoader() {
		// 컴파일 시 예외 처리를강요하는 예외 방식을 가리켜 강제된 예외라 함
		try {
			fis = new FileInputStream(name);
			fos = new FileOutputStream(target);
			int data = -1;
			
			while (true) {
				data = fis.read(); // 1byte 읽기. 호출 시마다 다음 데이터 접근
				
				if(data == -1) break;
				System.out.println(data);
				// 읽어들인 바이트 데이터를 내뱉는 빨대를 이용해 출력
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch(IOException e) {
			System.out.println("입출력 도중 에러가 발생했습니다.");
		} finally {
			if(fos != null){
				try {
					fos.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			
			if(fis != null){
				try {
					fis.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}
	}
	
	public static void main(String[] args) 
	{
		// 실행중인 프로그램으로 데이터를 읽어들여야 하므로, 입력 스트림 객체가 필요
		new BinaryLoader();
	}
}

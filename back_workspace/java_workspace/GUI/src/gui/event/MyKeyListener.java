/*
OS를 거쳐 JVM으로부터 전달되는 키보드 이벤트를 청취하기 위한 객체인 KeyListener를 재정의.
*/
package gui.event;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class MyKeyListener implements KeyListener // Is-A
{

		// KeyListener가 보유한 추상메서드를 재정의 {} 붙여보자
		
		public void keyTyped(KeyEvent e) {

		}
		public void keyPressed(KeyEvent e) {
			System.out.println("눌렀음");
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("눌렀다 떼었음");
		}
		
}

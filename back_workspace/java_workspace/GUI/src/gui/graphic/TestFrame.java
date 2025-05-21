/*
그래픽 프로그래밍 시, 알고 있으면 도움되는 비유
[현실]							[프로그래밍]
1) 화가							컴포넌트
2) 붓(그리는 행위)				컴포넌트가 보유한 그리는 메서드
3) 팔레트, 기타 도구			paint(Graphics g)
4) 그려질 대상					컴포넌트 자신

모든 컴포넌트는 스스로를 그린다...
버튼이 스스로 그림을 그릴 때 뺏어보기
*/
package gui.graphic;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

class TestFrame extends JFrame
{
	MyButton bt; // 같은 자료형이므로 가능.
	ImgPanel ip; // 내가 재정의한 패널
	
	public TestFrame() {
		bt = new MyButton("커스텀버튼");
		ip = new ImgPanel();
		
		setLayout(new FlowLayout());
		add(bt);
		add(ip);
		
		this.setSize(300,400);
		this.setVisible(true);
		
		// 윈도우 창을 닫을 때, 프로세스 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new TestFrame();
	}
}

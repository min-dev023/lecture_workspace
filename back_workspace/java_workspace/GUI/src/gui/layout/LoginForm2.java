package gui.layout;
import java.awt.*;

public class LoginForm2
{
	public static void main(String[] args) 
	{
		Frame frame = new Frame("로그인");
		
		Panel panel_s = new Panel(); 
		Panel panel_c = new Panel(); 
		
		Label label_id = new Label("ID");
		Label label_pw = new Label("Password");
		TextField tf_id = new TextField(15);
		TextField tf_pw = new TextField(15);
		Button bt_login = new Button("login");
		Button bt_join = new Button("join");
		
		// 크기 설정
		/* 처음 보는 객체 대한 대처법 
			1) 객체명으로 기능 예측, 예측이 안되면 조사.
			2) 사용하기 위해 메모리 올리는 법을 파악(객체 유형은 3가지)
				- 일반 클래스 : new 생성자()
				- 추상 클래스 : 자식으로 구현한 후 자식을 new 생성자()
				- 인터페이스 : 자식으로 구현한 후 자식을 new 생성자()
		*/
		Dimension d = new Dimension(100, 25);
		label_id.setPreferredSize(d);
		label_pw.setPreferredSize(d);
		tf_id.setPreferredSize(d);
		tf_pw.setPreferredSize(d);
		
		// 조립
		panel_c.add(label_id);
		panel_c.add(tf_id);
		panel_c.add(label_pw);
		panel_c.add(tf_pw);
		
		// 중앙 패널을 윈도우에 부착
		frame.add(panel_c);
		
		panel_s.add(bt_login);
		panel_s.add(bt_join);
		
		frame.add(panel_s, BorderLayout.SOUTH);
		
		// 윈도우 설정
		frame.setSize(300, 135);
		frame.setVisible(true);
	}
}

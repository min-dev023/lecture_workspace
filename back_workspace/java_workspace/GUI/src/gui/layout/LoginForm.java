package gui.layout;
import java.awt.*;

public class LoginForm
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
		
		// 2층에 2호수
		panel_c.setLayout(new GridLayout(2, 2)); 
		panel_c.add(label_id);
		panel_c.add(tf_id);
		panel_c.add(label_pw);
		panel_c.add(tf_pw);
		
		panel_s.add(bt_login);
		panel_s.add(bt_join);
		
		frame.add(panel_c, BorderLayout.CENTER);
		frame.add(panel_s, BorderLayout.SOUTH);
		
		frame.setSize(220, 135);
		frame.setVisible(true);
	}
}

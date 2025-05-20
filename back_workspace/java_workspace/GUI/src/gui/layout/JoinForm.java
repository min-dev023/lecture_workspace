package gui.layout;

import java.awt.*;

// JoinForm은 extends를 선언하는 순간부터 is-a관계에 의해서
// 곧 Frame 되어버림 따라서 JoinForm 을 대상으로 new 하면 윈도우가 생성되는 것임.
class JoinForm extends Frame
{
	// 필요한 재료들을 has-a 관계로 보유하자
	Label label_header;
	Label label_id;
	TextField tf_id;
	Label label_pw;
	TextField tf_pw;
	Label label_name;
	TextField tf_name;
	
	Button bt_login;
	Button bt_join;
		
	Panel panel_n;
	Panel panel_c;
	Panel panel_s;
	
	
	public JoinForm(){
		label_header = new Label("회원가입");
		label_id = new Label("ID");
		tf_id = new TextField(15);
		label_pw = new Label("Password");
		tf_pw = new TextField(15);
		label_name = new Label("Name");
		tf_name = new TextField(15);
		
		bt_login = new Button("login");
		bt_join = new Button("join");
			
		panel_n = new Panel(); 
		panel_c = new Panel(); 
		panel_s = new Panel();
		
		// 스타일 적용
		label_header.setBackground(Color.YELLOW);
		tf_id.setBackground(Color.YELLOW);
		tf_pw.setBackground(Color.YELLOW);
		tf_name.setBackground(Color.YELLOW);
		
		// 조립
		// 제목을 북쪽에 부착
		panel_n.add(label_header);
		add(panel_n, BorderLayout.NORTH);
		
		// 센터 영역
		Dimension d = new Dimension(110, 25);
		label_id.setPreferredSize(d);
		tf_id.setPreferredSize(d);
		label_pw.setPreferredSize(d);
		tf_pw.setPreferredSize(d);
		label_name.setPreferredSize(d);
		tf_name.setPreferredSize(d);
		
		panel_c.add(label_id);
		panel_c.add(tf_id);
		panel_c.add(label_pw);
		panel_c.add(tf_pw);
		panel_c.add(label_name);
		panel_c.add(tf_name);
		
		add(panel_c, BorderLayout.CENTER);
		
		// 남쪽 처리
		panel_s.add(bt_login);
		panel_s.add(bt_join);
		add(panel_s, BorderLayout.SOUTH);
		
		MemberListener mb_l = new MemberListener(bt_login, bt_join, this);
		
		// 로그인 버튼과 리스너 연결
		bt_login.addActionListener(mb_l);
		
		// 가입 버튼과 리스너 연결
		bt_join.addActionListener(mb_l);
		
		this.setSize(300, 200);
		this.setVisible(true);
	}
	
	
	// 회원가입과 관련된 컴포넌트가 전부 회원가입 폼 클래스에 존재하므로
	// 폼에 대한 유효성 체크 또한 가입 폼 클래스에서 진행하는 것이 효율적.
	public void checkForm(){
		if(tf_id.getText().equals("")) {
			System.out.println("아이디를 입력하세요.");
		}
		if(tf_pw.getText().length() < 1) {
			System.out.println("비밀번호를 입력하세요.");
		}
		if(tf_name.getText().equals("")) {
			System.out.println("이름을 입력하세요.");
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		new JoinForm();
	}
}

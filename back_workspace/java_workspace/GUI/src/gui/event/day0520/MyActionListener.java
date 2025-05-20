package gui.event.day0520;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class MyActionListener implements ActionListener
{
	// 사용자가 액션 이벤트를 일으키면 OS로부터 이벤트 정보를 받은 JVM은
	// 해당 이벤트 정보를 알맞은 이벤트 객체로 인스턴스화 시킴
	// 그리고 생성된 이벤트 인스턴스는, 재정의 메서드인 actionPerformed()
	// 메서드로 전달해준다. 개발자는 자신이 알고싶은 이벤트 정보를 ActionEvent로부터
	// 모든 것을 알아낼 수 있다.
	// js 에서의 addEventListener("click", (e)=>{}); e와 동일
	
	Button btn1;
	Button btn2;
	
	// 메서드를 통해 다른 클래스에 존재하던 버튼들을 전달받음 (생성자 주입 == injection)
	public MyActionListener(Button btn1, Button btn2) {
		this.btn1 = btn1;
		this.btn2 = btn2;
	}
	
	public void actionPerformed(ActionEvent e){
		// 이벤트를 일으킨 주체를 가리켜 이벤트 소스 event source
		Object obj = e.getSource(); // 버튼을 가리킴
		//System.out.println(obj); // java.awt.Button[button0,126,36,21x23,label=A]
		
		if(obj == btn1){
			System.out.println("A를 눌렀음");
		} else if(obj == btn2){
			System.out.println("B를 눌렀음");
		}		
	}
}

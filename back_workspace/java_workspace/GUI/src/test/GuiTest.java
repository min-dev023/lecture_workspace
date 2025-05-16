/*
GUI = Graphic User Interface 그림으로 조작하는 프로그램
CLI = Command Line Interface 명령으로 조작하는 프로그램

Java의 그래픽 관련 API는 java.awt 패키지에 들어있음
모든 데스크탑 기반의 GUI 프로그램에서 최상단에 존재하는 그래픽 컴포넌트는 윈도우다.
java에서는 윈도우는 상직적 존재에 불과하고 그 바로 하위에 Frame으로 대신함..
*/
package test;
import java.awt.*;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;

class GuiTest 
{
	public static void main(String[] args) 
	{
		// html에서 요소들을 부모 컨테이너에 추가하듯 자바도 마찬가지로
		//GUI  적 요소들을 윈도우라는 컨테이너에 부착해야 눈에 보임
		Frame f = new Frame(); // 윈도우 생성
		
		// 버튼이 너무 크게 나오는 이유는, 아직 배치(레이아웃) 방법을 지정하지 않았기 때문. 즉 디폴트 레이아웃이 적용되어 있음
		f.setLayout(new FlowLayout());
		// html 등에서 익숙하게 봐왔던 UI 컴포넌트 요소들을 자바 버전으로 생성하여 확인해보자
		Button bt = new Button("btn");
		TextField t = new TextField(20);
		Choice ch1 = new Choice();
		ch1.add("@naver.com");
		ch1.add("@gmail.com");
		ch1.add("@daum.net");
		TextArea area = new TextArea(12, 20);
		
		Checkbox[]  chArray = new Checkbox[3]; // 반드시 크기 지정
		chArray[0] = new Checkbox("Java", true);
		chArray[1] = new Checkbox("Django", false);
		chArray[2] = new Checkbox("Oracle", true);
		
		for(int i = 0 ; i < chArray.length; i++){
			f.add(chArray[i]);
		}
		Label la = new Label("제목 등 일반 텍스트");
		
		// 메뉴바와 메뉴 만들기
		Menu  m_file, m_edit, m_style, m_view, m_help;
		m_file = new Menu("파일");
		m_edit = new Menu("편집");
		m_style = new Menu("서식");
		m_view = new Menu("보기");
		m_help = new Menu("도움말");
		
		MenuBar bar = new MenuBar(); // 메뉴들이 얹혀질 막대기 컨테이너
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
		
		f.setMenuBar(bar);
		
		// 프레임에 버튼 부착
		f.add(bt);
		f.add(t);
		f.add(ch1);
		f.add(area);
		f.add(la);
		
		// 메뉴바와 메뉴 만들기
		
		// 자바의 윈도우를 사용하려면, 너비, 높이를 지정해야 한다..
		f.setSize(600,500);
		// 또한, 윈도우의 디폴트 보기 옵션은 비활성화되어 잇어서 눈에 보이지 않음
		f.setVisible(true);
		// 따라서 활성화 시켜야 함.
	}
}

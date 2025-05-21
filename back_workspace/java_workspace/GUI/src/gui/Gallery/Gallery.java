package gui.gallery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Gallery extends JFrame implements ActionListener
{
	JPanel p_north;
	//Panel p_center;
	JButton bt_prev, bt_next;
	JLabel la_title;
	Toolkit kit; // 시스템의 이미지를 개발자 대신 얻어다 주는 객체
	MyCanvas myCanvas; // 커스텀해서 만든 패널로 교체
	
	// 자바 스크립트와는 달리 대부분의 언어는 배열의 고정 배열이므로 반드시 배열 선언시 크기 명시.
	Image[] imgArray = new Image[9];
	int index = 0; // 이미지 배열을 접근하기 위한 인덱스.. 즉 몇번째 이미지를 보고 싶은지 결정
	
	public Gallery() {
		// 북쪽 타이틀
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		la_title = new JLabel("제목");
		bt_next = new JButton("다음");
		kit = Toolkit.getDefaultToolkit(); // 툴킷의 인스턴스 얻기 클래스 메서드
		
		myCanvas = new MyCanvas();
		myCanvas.setBackground(Color.YELLOW);
			
		p_north.setSize(600,50);
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		this.add(p_north, BorderLayout.NORTH);
		
		this.add(myCanvas);
		
		// 초기 이미지 보여주기
		createImage();
		
		// 패널에 초기에 보여질 이미지 1개을 전달.
		myCanvas.setImage(imgArray[index]);
		
		// 이전 버튼과 리스너 연결
		bt_prev.addActionListener(this);
		// 다음 버튼과 리스너 연결
		bt_next.addActionListener(this);
		
		this.setSize(600,500);
		this.setVisible(true);
		
	}
	
	// 멤버 변수로 선언된 이미지 배열에 이미지 인스턴스 9개 준비해놓아야
	// 프로그램 가동과 동시에 사용자가 사용할 수 있다.
	public void createImage() {
		String[] path = {
			"animal1.jpg",
			"animal2.jpg",
			"animal3.jpg",
			"animal4.jpg",
			"animal5.jpg",
			"animal6.jpg",
			"animal7.jpg",
			"animal8.jpg",
			"animal9.jpg"
		};
		
		//kit.getImage("경로");
		String strPath = "C:/lecture_workspace/back_workspace/java_workspace/res/geographic/";
		for(int i = 0; i < path.length; i++) {
			// 툴킷으로부터 이미지인스턴스 9개를 생성하여 image배열에 넣기
			// 주의) 디렉터리 경로 붙이기.
			imgArray[i] = kit.getImage(strPath + path[i]);
		}
	}
	// p_center 영역에 이미지 출력하기
	// 그래픽 프로그래밍에서 컴포넌트의 약간의 변화라도 생기면 그 그림은 지워지고,
	// 다시 그려져야 하는데, 개발자가 처리하는 것이 아니라, 시스템 내부에서 알아서 렌더링 담당하게 됨.
	// 컴포넌트에 변경이 생기면 다음의 과정을 거쳐서 그래픽이 구현된다.
	/*
	[AWT]
	최초 컴포넌트 등장 시 paint()에 의해 눈에 보여짐
	사용자가 컴포넌트의 그림에 변화를 주게 되면, jvm은 기존 그림을 지워야하므로
	update() 메서드를 호출하여 그림을 깨끗이 지움.. 그리고 내부적으로 paint() 메서드를
	호출하여 변경된 그림을 화면에 보여준다.
	
	[Swing]
	사용자가 컴포넌트에 변화를 주게 되면 update() 메서드가 호출되는 것이 아니라
	paintComponent()를 호출하여 화면을 깨끗이 지운다. 변경된 그림을 다시
	보여주기 위해 스스로 paint() 호출
	*/
	public void showImage(int num) {
		if (num == 1)
		{
			index--; // 다음 사진 일 경우 인덱스 증가
			if (index < 0) {index = (imgArray.length -1);}
			
			System.out.println("--" + index);
		} else if (num == 2)
		{
			index++; // 다음 사진 일 경우 인덱스 증가
			if (index >= imgArray.length) {index = 0;}
			
			System.out.println("++" + index);
		}
		
		myCanvas.setImage(imgArray[index]);
		myCanvas.repaint();
		// 변경된 이미지를 보기 위해서는 사용자의 윈도우 조작이 아니라
		// 개발자가 프로그래밍 적으로 지우고 다시 그릴 것을 요청한다.
		// 이때 호출되는 메서드가 repaint(). 즉 다시 그려줄 것을 부탁하는 메서드... 
		// 개발자는 절대로 paint()를 직접 호출해서는 안됨.
		// Why? 그림은 시스템이 알아서 그리기 때문.
		// repaint() --> update(AWT)					 --> paint()
		//				  --> paintComponent(Swint) --> paint()
	}
	
	public void actionPerformed(ActionEvent e) {
		// 이벤트를 일으킨 컴포넌트를 가리켜 이벤트 소스라고 함.
		Object obj = e.getSource();
		
		// 버튼 인스턴스의 주소값만 비교하면 되므로, 굳이 형변환 필요 없음.
		if(obj == bt_prev) {
			showImage(1);
		} else if(obj == bt_next){
			showImage(2);
		}
	}
	
	public static void main(String[] args) 
	{
		new Gallery();
	}
}

package gui.layout;
/*
GUI 프로그래밍을 윈도우 프로그래밍이라고도 함
모든 UI 컴포넌트는 윈도우 안에서 구현되므로...

컴포넌트란? 재사용 가능한 객체 단위(예- gui 분야에서는 버튼, 체크박스 등)
[java 컴포넌트의 유형]
- 남을 포함할 수 있는 유형(컨테이너형)
	ex) Frame
		특징 : 남을 포함하려다 보니, 어떻게 배치할지를 고민 함
			따라서 컨테이너형에는 배치 관리자(Layout Manager)가 지원됨
			컨테이너 유형은 개발자가 배치관리자를 지정하지 않아도, 시스템에서 기본으로 적용되는
			배치관리자가 있음 ex) Frame의 경우 BordeLayout이 적용
		배치관리자 종류 :
			1) BorderLayout() - 동,서,남,북,센터의방향을 갖는 배치
					각 방향에 들어가는 컴포넌트는 자신의 크기를 잃어버리고, 확장해버림. -> 따라서 큰버튼이 만들어짐
			2) FlowLayout() - 위치가 결정되지 않고 컨테이너에 따라 흘러다님
					단 방향성이 있어서 수평방향의 흐름 또는 수직방향의 흐름 둘 중 하나임
			3) GridLayout() - 행과 열의 배치 방식
					각 행, 열에 배치되는, 즉 셀에 들어가는 컴포넌트가 자신의 크기를 잃어버리고 확장해버림
			4) CardLayout() - 오직 하나의 카드만 보여지는 배치 방식
					화면 전환 시 사용됨
- 남에게 포함 당할 수 있는 유형 (비주얼 컴포넌트형)
	ex) 버튼, 체크박스, 초이스, 윈도우 안에 포함되는 모든 것들

*/
import java.awt.Frame;
import java.awt.*;

public class LayoutTest
{
	public static void main(String[] args) 
	{
		//윈도우 생성
		Frame frame = new Frame("배치 학습");
		
		Panel panel_s = new Panel(); 
		// 위도우 안에 소속되는 컨테이너형 컴포넌트
		// 따라서 다른 컴포넌트를 포함할 수 있다. Panel도 컨테이너형이므로
		// 배치관리자가 지원되며, 개발자가 지정하지 않으면 디폴트가 FlowLayout
		Panel panel_c = new Panel(); 
		
		Button bt_center_1 = new Button("CENTER1");
		Button bt_center_2 = new Button("CENTER2");
		Button bt_west = new Button("WEST");
		Button bt_south = new Button("SOUTH");
		
		panel_s.add(bt_south); // 패널에 버튼 부착
		panel_c.add(bt_center_1);
		panel_c.add(bt_center_2);

		// 상수는 public static final로 선언되었고, 클래스 소속이므로 인스턴스 생성없이
		// 사용 가능함 따라서.. BorderLayout이 보유한 상수명으로 접근 가능
		frame.add(bt_west, BorderLayout.WEST); // 두번째 매개변수로 상수를 지정
		frame.add(panel_s, BorderLayout.SOUTH);
		frame.add(panel_c, BorderLayout.CENTER);

		frame.setSize(500, 400);
		// 윈도우는 보이고, 안보이게 하는 기능이 있기 때문에 디폴트는 안보임
		frame.setVisible(true);
	}
}

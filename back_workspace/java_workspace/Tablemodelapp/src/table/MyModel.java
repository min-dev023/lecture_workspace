package table;

import javax.swing.table.AbstractTableModel;

/*
 * JTable 개발분야에서 전해 내려오는 많이 알려진 개발 방법(=패턴) 중 하나인 MVC 패턴을 구현한 컴포넌트이다. 하지만 완벽하지 X
 * why? MC의 역할을 동시에 수행하므로 데이터를 보유할 뿐만 아니라, 그 데이터를 디자인 영역에 반영하는 코드도 포함되어 있기 때문에
 * 결론) 중요한 것은 JTable과 데이터를 분리시켜 놓은 기술임*/
public class MyModel extends AbstractTableModel {
	
	// 회원정보 (층, 호를 표현하기 위한 이차원 배열 형태의 데이터가 필요)
	String[][] rows = new String[100][3];
	String[] columns = {"ID", "Name", "Tel"};

	// 테이블에 보여질 총 레코드 수
	public int getRowCount() {
		return rows.length;
	}

	// 테이블을 구성하는 컬럼 수
	public int getColumnCount() {
		return columns.length;
	}
	
	// 컬럼의 이름을 반환해주는 메서드
	// 아래의 메서드는 컬럼 수만큼 반복하면서 호출되는데 , 이때 매개변수로 넘겨받는 col의 값은 자동 증가하면서 전달되어짐.
	public String getColumnName(int col) {
		return columns[col];
	}

	// getValueAt() 메서드는 getRowCount() * getColumn() 수만큼 호출하면서
	// 표를 이루는 각 셀(행, 열)의 좌표마다 어떠한 값을 넣을지 return이 결정함.
	public Object getValueAt(int row, int col) {
//		System.out.println("row = " + row + ", col = " + col);
		return rows[row][col];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		System.out.println(row + "행, " + col + "열은 수정 가능 합니다.");
		return true;
	}
}

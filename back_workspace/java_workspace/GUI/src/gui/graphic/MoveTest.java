package gui.graphic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveTest extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt;
	MovePanel p_center;
	
	public MoveTest(){
		p_north = new JPanel();
		bt = new JButton("이동");
		p_center = new MovePanel();
		
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt.addActionListener(this); // 버튼과 리스너 연결
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 100, 600,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// MovePanel의 빨간색 원을 이동 시키기
		p_center.move();
		p_center.repaint(); // 다시 그리자. 주의) 절대 paint(Graphics g) 호출 금지
		
		/* MovePanel의 x, y를 증가 시키기
		
		int x = p_center.getX();
		x++;
		p_center.setX(x);
		
		int y = p_center.getY();
		y++;
		p_center.setY(y); */
	}
	
	public static void main(String[] args) {
		new MoveTest();
	}
}
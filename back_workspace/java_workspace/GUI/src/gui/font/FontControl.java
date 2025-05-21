package gui.font;

import java.awt.*;
import java.awt.event.*;

public class FontControl extends Frame
{
	FontStyle f_s; // 메인 .java
	Panel p_south;
	Button b_font;
	TextField t_size; // 폰트 크기
	// 폰트 색상
	
	public FontControl(FontStyle f_s) {
		this.f_s = f_s;
		
		// content
		t_size = new TextField();
		t_size.setBackground(Color.BLUE);
		
		// 사이즈 조절
		//Dimension d = new Dimension(250, 25);
		//t_size.setPreferredSize(d);
		
		add(t_size);
		
		// south
		p_south = new Panel();
		b_font = new Button("적용");
		
		p_south.add(b_font);
		add(p_south, BorderLayout.SOUTH);
		
		//실행
		setSize(300,400);
		setVisible(true);
	}
}

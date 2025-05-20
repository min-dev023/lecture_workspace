package gui.font;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontStyle extends Frame implements ActionListener
{
	TextArea t_content;
	Button b_font;
	Panel p_south;
	FontControl f_c;
	
	
	public FontStyle() {
		t_content = new TextArea();
		p_south = new Panel();
		b_font = new Button("서식");
		
		t_content.setBackground(Color.YELLOW);
		add(t_content);
		
		p_south.add(b_font);
		add(p_south, BorderLayout.SOUTH);
		
		b_font.addActionListener(this);
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("버튼 작동");
		f_c = new FontControl(this);
	}
	
	public static void main(String[] args) 
	{
		new FontStyle();
	}
}

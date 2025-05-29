package shop.page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

// 쇼핑몰에서 모든 페이지들의 최상위 객체인 그냥 Page를 정의한다
public class Page extends JPanel{
	JLabel la_title;
	
	public Page(String title) {
		la_title = new JLabel("쇼핑몰의 메인 페이지");
		la_title.setFont(new Font("Arial Black", Font.BOLD, 30));
		
		add(la_title);
//		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(800, 650));
		setVisible(false);
	}
}

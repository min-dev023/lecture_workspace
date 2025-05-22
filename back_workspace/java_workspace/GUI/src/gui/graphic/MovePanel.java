package gui.graphic;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class MovePanel extends JPanel
{
	private int x;
	private int y;
	
	public void move(){
		x++;
		y++;
	}
	// JPanel의 paint() 메서드를 오버라이딩
	public void paint(Graphics g) {
		// 채워진 원 그리기
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 45, 45); // fillOval(int x, int y, int width, int height)
	}
	
	/*
	public int getX(){return x;};
	public void setX(int x){this.x = x;}
	public int getY(){return y;};
	public void setY(int x){this.y = y;}
	*/	
}
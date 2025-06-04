package com.sinse.shopadmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sinse.shop.common.config.Config;
import com.sinse.shopadmin.security.model.Admin;

public class AppMain extends JFrame{
	JPanel p_north;
	JPanel p_west; // 사이드 메뉴 영역
	JPanel p_container; // 페이지가 교체될 영역
	JLabel la_user; // 현재 로그인한 유저
	
	JLabel la_product;
	JLabel la_order;
	JLabel la_member;
	JLabel la_cs;
	JLabel la_config;
	Connection con;
	Admin admin;

	public AppMain(Connection con, Admin admin) {
		this.con = con;
		this.admin = admin;
		
		p_north = new JPanel();
		p_west = new JPanel();
		p_container = new JPanel();
		
		la_user = new JLabel();
		
		la_product = new JLabel("상품관리");
		la_order = new JLabel("주문관리");
		la_member = new JLabel("회원관리");
		la_cs = new JLabel("고객센터");
		la_config = new JLabel("환경설정");
		
		// 스타일
		p_north.setPreferredSize(new Dimension(Config.UTIL_WIDTH, Config.UTIL_HEIGHT));
		p_north.setBackground(Color.CYAN);
		
		p_west.setPreferredSize(new Dimension(Config.SIDE_WIDTH, Config.SIDE_HEIGHT));
		p_west.setBackground(Color.YELLOW);
		
		// 조립
		add(p_north, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, Config.ADMINMAIN_WIDTH, Config.ADMINMAIN_HEIGHT);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new AppMain();
//	}

}

package com.sinse.shopadmin.member.view;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityTest {
	// javaSE는 이미 암호화 알고리즘 함수를 보유하고 있다.
	public static void main(String[] args) {
		String pass = "minzino"; 
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = md.digest(pass.getBytes("UTF-8"));
			
			System.out.println(hash.length); // 32
			
			// 잘게 쪼개진 바이트를 16진수 문자열로 변환
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < hash.length; i++) {
				// byte 데이터를 16진수로 변경하는 과정에서, byte 값 안에 음수가 존재할 경우
				// byte 데이터형이 int형으로 변경되면서, 부호 비트가 자동으로 붙게되는데,
				// 이 부호비트는 암호화에 사용되지 않으므로 제거해야함.. 이때 제거하는 연산은
				// 16진수 0xff 와 & 비트 연산자 중 and 연산자를 이용한다
				// 참고로 ) 바이트데이터가 int형으로 변경되는 이유는 java 언어에서
				String hex = Integer.toHexString(0xff & hash[i]); // 0xff 음수를 제거
				System.out.print(hex + " ");
				if(hex.length() < 2) sb.append("0");
				sb.append(hex); // 스트링 누적
			}
			System.out.println();
			System.out.println(sb.toString());
			
			for(int i = 0; i < hash.length; i++) {
				String hex2 = Integer.toHexString(hash[i]); // 0xff 음수를 제거
				System.out.print(hex2 + " ");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

package com.sinse.dbproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// 컬렉션 프레임워크가 지원하는 순서없는 객체 중 하나인 Set을 학습
		// <> 다이아몬드 연산자, java 7부터 스스로 추정하므로 자료형 생략 가능
		Set<String> set = new HashSet<>();
		
		set.add("BMW");
		set.add("Benz");
		set.add("Audi");
		set.add("genesis");
		
		// 순서 없는 Set은 크기를 알 수는 있지만, 직접적으로 for문을 돌릴 수 없다
		// 풀어놓아야함
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) { // 다음 요소가 존재할 때 까지...
			String obj = it.next(); // 현재 위치에서 다음 요소로 접근
			System.out.println(obj);
		}
	}

}

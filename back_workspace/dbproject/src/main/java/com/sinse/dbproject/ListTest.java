package com.sinse.dbproject;

import java.util.ArrayList;
import java.util.List;

/* Collection(집합, 모음)
java에서 객체들을 모아서 처리할 때 유용한 방법을 지원해주는 api 집합을 가리켜
Collection Framework이라 함 == 자료구조
[사물이 모여진 모습 유형]
- 순서 있는 집합 : 배열, List(우리가 알고있던 그 배열과 비슷), Queue(선입선출) -> 중복 허용 O
- 순서 업는 집합 : Set, Map(key, value) -> 중복 허용 X
*/

public class ListTest {
	public static void main(String[] args) {
		/* 자바의 컬렉션 프레임워크는 java.util 패키지에서 지원하며
		 * 그 중, 순서있는 집합을 처리하는데 대표적인 List에 대해 알아본다
		 * List vs 배열
		 * 공통점 - 순서를 가지며 인덱스로 접근 가능
		 * 차이점 - 배열은 생성 시, 반드시 크기를 명시
		 * 		컬렉션의 대상은 오직 객체만을 대상으로...
		 * 컬렉션 프레임워크는 최상위 인터페이스들의 메서드를 주로 사용하기 때문에
		 * 하위의 어떠한 구현 객체를 사용하더라도, 메서드 사요이 일관성이 있다.
		 * 담을 때는 거의 add, 길이는 거의 Size()
		 * <자료형>을 명시하면, 컴파일러가 다른 자료형을 거부한다. 즉 컴파일 타임에 자료형 체크
		 * 이를 "제너릭(Generic) 타입"이라고 한다.
		 * */
		
		List<String> list = new ArrayList(); //크기가 자유롭게 들어나는 배열(js랑 동일)
		list.add("apple");
		list.add("banana");
		list.add("grape");
		list.add("orange");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 5부터 개선 for(improved for)
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
}

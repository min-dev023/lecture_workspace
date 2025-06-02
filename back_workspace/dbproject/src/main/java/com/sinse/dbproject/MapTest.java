package com.sinse.dbproject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// 컬렉션 프레임워크 중 순서가 없는 유형 중 Map!
		Map<String, String> map = new HashMap<>();
		
		map.put("a1", "가나초콜릿");
		map.put("a2", "허쉬초콜릿");
		map.put("a3", "abc초콜릿");
		
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key); // 기존 맵에서 key를 이용하여 접근
			
			System.out.println(value);
		}
	}

}

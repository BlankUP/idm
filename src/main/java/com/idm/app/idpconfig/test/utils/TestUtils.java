package com.idm.app.idpconfig.test.utils;

import org.springframework.stereotype.Component;
import sun.text.resources.cldr.bg.FormatData_bg;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Component
public class TestUtils {
	 private static int sf = 0;
	    public void testTask(){
	        sf++;
	        System.out.println("10秒输出一次。。。。。sf:"+sf);
			System.out.println(" ");
		}

	/**
	 *
	 * @param dff
	 * @param dd
	 * @return
	 */
		public String test(String dff,short dd){
	    	return "fd";
		}

	public static void main(String[] args) {
//		ArrayList<Object> arrayList = new ArrayList<>();
//		arrayList.add("1");
//		arrayList.add("2");
//		arrayList.add("3");
//		arrayList.add("4");
//		for(int i = 0;i<arrayList.size();i++){
//			System.out.println(arrayList.contains("1"));
//		}
//		Iterator<Object> iterator = arrayList.iterator();
//		while (iterator.hasNext()){
//			String next = (String)iterator.next();
//			System.out.println(next);
//
//		}
		Map<String, Object> map = new HashMap<>();
		for (int i = 0;i<100;i++){
			map.put("key"+i,i);
		}
//
//		for (Map.Entry entry : map.entrySet()){
//			System.out.println(entry.getKey()+" ："+entry.getValue());
//		}
//		Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
//		while (iterator.hasNext()){
//			Map.Entry<String, Object> next = iterator.next();
//			System.out.println(next.getKey()+":"+next.getValue());
//		}

		for (String key : map.keySet()){
			System.out.println("key:"+key);
		}
		for (Object values : map.values()){
			System.out.println("value:"+values);
		}
	}


}

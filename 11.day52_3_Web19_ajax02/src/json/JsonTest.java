package json;


import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import bean.Stock;

public class JsonTest {
	
	/**
	 * {'code':'600015','name':'shandong highway','price':10}
	 */
	private static void test1() {

		Stock s = new Stock();
		s.setCode("600015");
		s.setName("shandong highway");
		s.setPrice(10);
		JSONObject jsonObj = (JSONObject) JSONObject.wrap(s);
		String jsonStr = jsonObj.toString();
		
		
		
		System.out.println(jsonStr);
		
	}
	
	
	/**
	 * [{'code':'600015','name':'shandong highway','price':10},
	 * {'code':'600015','name':'shandong highway','price':10},
	 * {'code':'600015','name':'shandong highway','price':10}]
	 */
	public static void test2() {
		List<Stock> stocks = new ArrayList<Stock>();
		for(int i = 0; i<3; i++){
			Stock s = new Stock();
			s.setCode("60001" + i);
			s.setName("shandong highway" + i);
			s.setPrice(10);
			stocks.add(s);
		}
		JSONArray jsonArr = new JSONArray(stocks.toArray());
		String jsonStr = jsonArr.toString();
		System.out.println(jsonStr);
		
		
	}
	
	


	public static void main(String[] args) {
		test1();
		test2();
	}
}






























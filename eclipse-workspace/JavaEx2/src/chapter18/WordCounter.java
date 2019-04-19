package chapter18;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter {
	Map<String, Integer> map;
	List<String> list;
	
	public WordCounter(List<String> list) {
		super();
		this.list = list;
		
		map = new HashMap<>();		
	}
	
	public void parse() {
		for(String line : list) {
			StringTokenizer tokenizer = new StringTokenizer(line, 
														" \t,\"\'.?!");
			while(tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				if(map.containsKey(token)) {	// 예전에 등장했던 단어
					int count = map.get(token);
					count++;
					map.put(token, count);					
				} else {	// 처음 등장한 단어
					map.put(token, 1);
				}				
			}
		}
	}
	
	public void printResult(PrintStream out) {
		for(String key : map.keySet()) {
			out.println(key + " : " + map.get(key));
		}
	}
	
	
	public void printResult(PrintStream out, 
							Comparator<Map.Entry<String, Integer>> c) {
		// Map.Entry 리스트 만들기
		List<Map.Entry<String, Integer>> entries
									= new ArrayList<>(map.entrySet());
		// 정렬하기 
		Collections.sort(entries, c);
		for(Map.Entry<String, Integer> entry : entries) {
			out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}	
}





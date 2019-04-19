package edu.autocar.tourguide;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.TourGuide;

public class FileRead {
	public static void main(String[] args) {
		
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try (	FileReader fr = new FileReader("c:/temp/tour100.txt");
				BufferedReader br = new BufferedReader(fr);
		){
			String line;
			br.readLine();
			while((line=br.readLine())!=null) {
				
				List<String> list = new ArrayList<>();
				list.add(line.split("\t")[0]);
				list.add(line.split("\t")[1]);
				list.add(line.split("\t")[2]);
				list.add(line.split("\t")[3]);
				list.add(line.split("\t")[4]);
				list.add(line.split("\t")[5]);
				System.out.println(list);
				
//				StringTokenizer stk = new StringTokenizer(line,"\t");
//				
//				Tour t = Tour.builder()
//							.tourspot(stk.nextToken())
				
				
				
				
//				line = line.replaceAll("\"","");
//				String[] tokens = line.split("\t");
//				Tour t = getTourguide(tokens);
				
							
				TourGuide t = getTourGuide(list);
				dao.insert(t);
				ConnectionProvider.getSqlSession().commit();
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TourGuide getTourGuide(List list) throws Exception {
		
		String name = (String) list.get(0);
		String city = (String) list.get(1);
		String region = (String) list.get(2);
		String content = (String) list.get(3);
		String site = (String) list.get(4);
		String homepage = (String) list.get(5);
		
		return TourGuide.builder()
						.name(name)
						.city(city)
						.region(region)
						.content(content)
						.site(site)
						.homepage(homepage)
						.build();
	}

}

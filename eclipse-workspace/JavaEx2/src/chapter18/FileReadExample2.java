package chapter18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReadExample2 {

	public static void main(String[] args) {
		File file = new File("c:/temp/test.txt");
		try {
			List<String> lines = Files.readAllLines(file.toPath());
			WordCounter wc = new WordCounter(lines);
			wc.parse();
			wc.printResult();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}

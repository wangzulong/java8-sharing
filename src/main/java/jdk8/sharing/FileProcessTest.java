package jdk8.sharing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessTest {

	public static void main(String[] args) throws IOException {

		String result = processFile((BufferedReader br) -> br.readLine());
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		return p.process(br);
		
	}

}

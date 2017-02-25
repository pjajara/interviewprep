package edu.sjsu.java.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		System.out.println(System.getProperty("java.io.tmpdir"));
		FileReader fr = null;
		BufferedReader br = null;
		String fs = System.getProperty("file.separator");
		StringBuilder sb = new StringBuilder();
		File f = new File("");
		try {
			fr = new FileReader("c:" + fs + "temp" + fs + "useless0.txt");
			br = new BufferedReader(fr);

			while (br.readLine() != null) {
				sb.append(br.readLine());
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

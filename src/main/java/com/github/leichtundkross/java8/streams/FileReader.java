package com.github.leichtundkross.java8.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

	public String readFile(String filename) throws IOException {
		String content;

		try (InputStream in = FileReader.class.getClassLoader().getResourceAsStream(filename);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			content = sb.toString();
		}

		return content;
	}

	public String readFileWithJava8(String filename) throws IOException {
		String content;
		try (InputStream in = FileReader.class.getClassLoader().getResourceAsStream(filename);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			br.lines().forEach(line -> sb.append(line));
			content = sb.toString();
		}

		return content;
	}
}

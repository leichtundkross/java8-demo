package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class FileReaderTest {

	@Test
	public void readFile() throws IOException {
		String content = new FileReader().readFile("hello.txt");

		assertEquals("Hello World", content);
	}

	@Test
	public void readFileWithJava8() throws IOException {
		String content = new FileReader().readFileWithJava8("hello.txt");

		assertEquals("Hello World", content);
	}
}

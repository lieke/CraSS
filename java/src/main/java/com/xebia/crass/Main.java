package com.xebia.crass;

import java.io.IOException;
import java.util.Arrays;

import com.xebia.crass.wordcount.WordCountingTwitterListener;

public class Main {
	public static void main(String args[]) throws IOException {
		WordCountingTwitterListener counter = new WordCountingTwitterListener();
		TwitterStreamConsumer consumer = new TwitterStreamConsumer(Arrays.<TwitterListener>asList(counter));
		
		consumer.start();
	}
}

package com.xebia.crass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.xebia.crass.wordcount.WordCountingTwitterListener;

public class Main {
	protected static final String OUTPUT_DIR = "/Users/friso/Desktop/counts";

	public static void main(String args[]) throws IOException, InterruptedException {
		WordCountingTwitterListener counter = new WordCountingTwitterListener();
		TwitterStreamConsumer consumer = new TwitterStreamConsumer(Arrays.<TwitterListener>asList(counter));
		
		consumer.start();
		
		while (true) {
			Thread.sleep(1000 * 600);
			System.out.println(counter.getCounts());
			writeCountsToCsv(counter.getCounts());
		}
	}

	private static void writeCountsToCsv(final Map<String, Map<String, Long>> counts) {
		Thread writerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Set<String> languages = counts.keySet();
				for (String language : languages) {
					File file = new File(OUTPUT_DIR, "counts." + language + "." + System.currentTimeMillis() + ".csv");
					try {
						FileWriter writer = new FileWriter(file);
						Set<Entry<String, Long>> entrySet = counts.get(language).entrySet();
						for (Map.Entry<String, Long> entry : entrySet) {
							writer.write("'" + entry.getKey() + "','" + entry.getValue().toString() + "'");
						}
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
 				}
			}
		});
		
		writerThread.start();
	}
}

package com.xebia.crass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.xebia.crass.wordcount.WordCountingTwitterListener;

public class Main {
	protected static final String OUTPUT_DIR = "/Users/friso/Desktop/counts";

	public static void main(String args[]) throws IOException, InterruptedException {
		WordCountingTwitterListener counter = new WordCountingTwitterListener();
		
		// To add Cassandra counter, uncomment line below:
		//
		//CassandraTwitterListener counter = new CassandraTwitterListener("localhost", 9160, "Keyspace1");
		
		TwitterStreamConsumer consumer = new TwitterStreamConsumer(Arrays.<TwitterListener>asList(counter));
		
		consumer.start();
		
		while (true) {
			for (int i = 0; i < 6; i++) {
				Thread.sleep(1000 * 10);
				System.out.println("Read " + consumer.getTweetCount() + " tweets!");
			}
			writeCountsToCsv(counter.getCounts());
		}
	}

	private static void writeCountsToCsv(final Map<String, Map<String, WordCountingTwitterListener.TwoLongs>> map) {
		Thread writerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
				String time = fmt.format(new Date());
				
				Set<String> languages = map.keySet();
				for (String language : languages) {
					File file = new File(OUTPUT_DIR, "counts." + language + "." + time + ".csv");
					try {
						FileWriter writer = new FileWriter(file);
						Set<Entry<String, TwoLongs>> entrySet = map.get(language).entrySet();
						for (Map.Entry<String, TwoLongs> entry : entrySet) {
							writer.write("\"" + entry.getKey().replace("\"", "\"\"") + "\"," + entry.getValue().getCount() + "\n");
						}
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
 				}
				System.out.println("Written CSVs!");
			}
		});
		
		writerThread.start();
	}
}

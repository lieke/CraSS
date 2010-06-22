package com.xebia.crass;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		//WordCountingTwitterListener counter = new WordCountingTwitterListener();
		CassandraTwitterListener counter = new CassandraTwitterListener("localhost", 9160, "Keyspace1");
		
		TwitterStreamConsumer consumer = new TwitterStreamConsumer(Arrays.<TwitterListener>asList(counter));
		
		consumer.start();
	}
}

package com.xebia.crass.wordcount;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import com.xebia.crass.TwitterListener;
import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

public class WordCountingTwitterListener implements TwitterListener {
	private static final int TWENTY_SECONDS = 1000 * 20;

	public class TwoLongs {
		private volatile long count;
		private volatile long time;
		public long getCount() {
			return count;
		}
		public long getTime() {
			return time;
		}
		
		@Override
		public String toString() {
			return "" + count;
		}
	}
	protected static final long ONE_MINUTE = 1000 * 60;
	private final Map<String, Map<String,TwoLongs>> counts;
	
	public WordCountingTwitterListener() {
		counts = new ConcurrentHashMap<String, Map<String,TwoLongs>>();
		Thread cleanupThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(TWENTY_SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Collection<Map<String,TwoLongs>> maps = counts.values();
				
				for (Map<String,TwoLongs> map : maps) {
					
					for (Iterator<Map.Entry<String,TwoLongs>> itr = map.entrySet().iterator(); itr.hasNext(); ) {
						Map.Entry<String,TwoLongs> next = itr.next();
						if (next.getValue().getCount() == 1 && next.getValue().getTime() < (System.currentTimeMillis() - ONE_MINUTE)) {
							itr.remove();
						}
					}
				}
			}
		});
		cleanupThread.setDaemon(true);
		cleanupThread.start();
	}
	
	@Override
	public void delete(Deletion delete) {
	}

	@Override
	public void tweet(Tweet tweet) {
		String language = tweet.getUser().getLang();
		String text = tweet.getText();
		StringTokenizer tokenizer = new StringTokenizer(text);
		while (tokenizer.hasMoreTokens()) {
			updateCountForLanguageAndWord(language, tokenizer.nextToken());
		}
	}
	
	private void updateCountForLanguageAndWord(String language, String word) {
		Map<String,TwoLongs> countsForLanguage = counts.get(language);
		if (countsForLanguage == null) {
			countsForLanguage = new ConcurrentHashMap<String,TwoLongs>();
			counts.put(language, countsForLanguage);
		}
		
		TwoLongs value = countsForLanguage.get(word);
		if (value == null) {
			value = new TwoLongs();
			value.count = 1L;
			value.time = System.currentTimeMillis();
			countsForLanguage.put(word, value);
		} else {
			value.count++;
			value.time = System.currentTimeMillis();
		}
	}

	public Map<String, Map<String, TwoLongs>> getCounts() {
		return counts;
	}
}

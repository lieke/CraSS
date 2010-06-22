package com.xebia.crass.wordcount;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.xebia.crass.TwitterListener;
import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

public class WordCountingTwitterListener implements TwitterListener {
	private final Map<String, Map<String,Long>> counts;
	
	public WordCountingTwitterListener() {
		counts = new HashMap<String, Map<String,Long>>();
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
		Map<String,Long> countsForLanguage = counts.get(language);
		if (countsForLanguage == null) {
			countsForLanguage = new HashMap<String,Long>();
			counts.put(language, countsForLanguage);
		}
		
		Long count = countsForLanguage.get(word);
		if (count == null) {
			countsForLanguage.put(word, 1L);
		} else {
			countsForLanguage.put(word, count + 1);
		}
	}
}

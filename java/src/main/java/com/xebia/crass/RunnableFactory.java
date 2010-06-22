package com.xebia.crass;

import com.xebia.crass.model.Tweet;

public interface RunnableFactory {
	public Runnable newRunnable(Tweet tweet);
}

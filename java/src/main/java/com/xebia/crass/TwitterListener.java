package com.xebia.crass;

import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

/**
 * Implementors must make the methods return instantly (or close to that). Be
 * sure to do time-consuming processing in another thread.
 * 
 */
public interface TwitterListener {
	public void tweet(Tweet tweet);
	public void delete(Deletion delete);
}

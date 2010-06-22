package com.xebia.crass;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

public class MultithreadedQueueingTwitterListener implements TwitterListener {
	private final ExecutorService executor;
	private final BlockingQueue<Tweet> tweets;
	private final RunnableFactory factory;

	private volatile boolean stop;
	
	private final static Logger log = Logger.getLogger(MultithreadedQueueingTwitterListener.class);
	
	public MultithreadedQueueingTwitterListener(ExecutorService executor, RunnableFactory factory) {
		this.executor = executor;
		this.factory = factory;
		tweets = new LinkedBlockingQueue<Tweet>();
		
		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!stop) {
					try {
						Tweet tweet = tweets.take();
						MultithreadedQueueingTwitterListener.this.executor.execute(MultithreadedQueueingTwitterListener.this.factory.newRunnable(tweet));
					} catch (InterruptedException e) {
						log.warn("Caught exception when getting tweet from queue.", e);
					}
				}
			}
		});
		
		consumerThread.start();
	}
	
	@Override
	public void delete(Deletion delete) {
	}

	@Override
	public void tweet(Tweet tweet) {
		try {
			tweets.put(tweet);
		} catch (InterruptedException e) {
			log.warn("Caught exception when putting tweet in queue.", e);
		}
	}
	
	public synchronized void stop() {
		stop = true;
	}
}

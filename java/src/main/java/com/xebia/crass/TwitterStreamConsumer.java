package com.xebia.crass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

public class TwitterStreamConsumer {
	private final Thread thread;
	private volatile boolean stop;
	
	private static final Logger log = Logger.getLogger(TwitterStreamConsumer.class);
	private ObjectMapper objectMapper;
	private List<TwitterListener> listeners;
	
	public TwitterStreamConsumer(List<TwitterListener> listeners) {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				runConsumer();
			}
		}, "Twitter stream consumer thread.");
		
		this.listeners = listeners;
		objectMapper = new ObjectMapper();
	}
	
	private void runConsumer() {
		//TODO: remove hard coded username, password and URL.
		//TODO: use OAuth!
		while (!stop) {
			BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(new AuthScope("stream.twitter.com", 80), new UsernamePasswordCredentials("crazSS", "crazzy"));
			
			DefaultHttpClient client = new DefaultHttpClient();
			client.setCredentialsProvider(credentialsProvider);
			
			HttpGet get = new HttpGet("http://stream.twitter.com/1/statuses/sample.json");
			
			HttpResponse response;
			InputStream in = null;
			try {
				response = client.execute(get);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					in = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line;
					while (!stop && (line = reader.readLine()) != null) {
						handleTweet(line);
					}
				} else {
					//Don't know when this happens. The null check is copy-paste from the example.
					log.error("The response entity was null for the stream request.");
				}
			} catch (ClientProtocolException e) {
				log.error("Exception caught in consumer. Reconnecting...", e);
			} catch (IOException e) {
				log.error("Exception caught in consumer. Reconnecting...", e);
			} finally {
				IOUtils.closeQuietly(in);
			}
			// TODO: better way of handling disconnections as per the Twitter
			// API docs (i.e. wait for some secs if a 4xx or 5xx occurs and
			// increment the sleep duration between reconnection attempts on
			// consecutive failures).
		}
	}

	private void handleTweet(String tweetJson) {
		try {
			if ("".equals(tweetJson) || 
					tweetJson.startsWith("{\"limit\":")) {
				//don't handle limit for now
				//the blank lines can occur as keep-alive according to Twitter API doc
			} else if (tweetJson.startsWith("{\"delete\":")) {
				Deletion deletion = objectMapper.readValue(tweetJson, Deletion.class);
				for(TwitterListener listener : listeners) {
					listener.delete(deletion);
				}
			} else {
				Tweet tweet = objectMapper.readValue(tweetJson, Tweet.class);
				for(TwitterListener listener : listeners) {
					listener.tweet(tweet);
				}
			}
		} catch (JsonParseException e) {
			log.warn("Unparseble tweet! JSON: " + tweetJson, e);
		} catch (JsonMappingException e) {
			log.warn("Unparseble tweet! JSON: " + tweetJson, e);
		} catch (IOException e) {
			log.warn("Unparseble tweet! JSON: " + tweetJson, e);
		}
	}

	public synchronized void start() {
		if (thread.isAlive()) {
			log.warn("Attempt to start consumer while it was already running.");
		} else {
			stop = false;
			thread.start();
		}
	}
	
	public synchronized void stop() {
		if (!thread.isAlive()) {
			log.warn("Attempt to stop consumer while it was not running.");
		}
		
		stop = true;
	}
}

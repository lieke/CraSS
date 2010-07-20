package com.xebia.crass;

import static me.prettyprint.cassandra.utils.StringUtils.bytes;
import static me.prettyprint.cassandra.utils.StringUtils.string;

import java.util.StringTokenizer;

import me.prettyprint.cassandra.dao.Command;
import me.prettyprint.cassandra.service.Keyspace;

import org.apache.cassandra.thrift.ColumnPath;

import com.xebia.crass.model.Deletion;
import com.xebia.crass.model.Tweet;

public class CassandraTwitterListener implements TwitterListener {

	private static final String CF_NAME = "Standard2";
	protected static final String COLUMN_NAME = "wordcount";
	
	private final String host;
	private final int port;
	private final String keyspace;

	public CassandraTwitterListener(String host, int port, String keyspace) {
		this.host = host;
		this.port = port;
		this.keyspace = keyspace;
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
			try {
				updateCountForLanguageAndWord(language, tokenizer.nextToken());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void updateCountForLanguageAndWord(final String language, final String nextToken) throws NumberFormatException, Exception {
		final String key = getKey(language, nextToken);

		Integer currentCount = Integer.valueOf(execute(new Command<String>(){
			public String execute(final Keyspace ks) throws Exception {
				try {
					return string(ks.getColumn(key, createColumnPath(COLUMN_NAME)).getValue());
				} catch(Exception e) {
					return "0";
				}
			}
		}));

		final Integer newCount = currentCount+1;
		
		System.out.println("Storing key " + key + " with count " + newCount);
		
	    execute(new Command<Void>(){
	        public Void execute(final Keyspace ks) throws Exception {
	          ks.insert(key, createColumnPath(COLUMN_NAME), bytes(String.valueOf(newCount)));
	          return null;
	        }
	      });
		
	}

	protected <T> T execute(Command<T> command) throws Exception {
		return command.execute(host, port, keyspace);
	}

	protected ColumnPath createColumnPath(String columnName) {
		ColumnPath columnPath = new ColumnPath(CF_NAME);
		columnPath.setColumn(columnName.getBytes());
		return columnPath;
	}
		  
	private String getKey(String language, String nextToken) {
		return language + "-" + nextToken;
	}

}

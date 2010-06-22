package com.xebia.crass.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("geo")
	private TwitterGeoPoint geo;
	
	@JsonProperty("contributors")
	private String contributors;
	
	@JsonProperty("coordinates")
	private TwitterGeoPoint coordinates;
	
	@JsonProperty("in_reply_to_user_id")
	private String inReplyToUserId;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("in_reply_to_screen_name")
	private String inReplyToScreenName;
	
	@JsonProperty("place")
	private TwitterPlace place;
	
	@JsonProperty("favorited")
	private boolean favorited;
	
	@JsonProperty("truncated")
	private boolean truncated;
	
	@JsonProperty("in_reply_to_status_id")
	private String inReplyToStatusId;
	
	@JsonProperty("user")
	private TwitterUser user;
	
	@JsonProperty("retweeted_status")
	private Tweet retweetedStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TwitterGeoPoint getGeo() {
		return geo;
	}

	public void setGeo(TwitterGeoPoint geo) {
		this.geo = geo;
	}

	public String getContributors() {
		return contributors;
	}

	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	public TwitterGeoPoint getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(TwitterGeoPoint coordinates) {
		this.coordinates = coordinates;
	}

	public String getInReplyToUserId() {
		return inReplyToUserId;
	}

	public void setInReplyToUserId(String inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public TwitterPlace getPlace() {
		return place;
	}

	public void setPlace(TwitterPlace place) {
		this.place = place;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public boolean isTruncated() {
		return truncated;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	public String getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public void setInReplyToStatusId(String inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public TwitterUser getUser() {
		return user;
	}

	public void setUser(TwitterUser user) {
		this.user = user;
	}
	
	public Tweet getRetweetedStatus() {
		return retweetedStatus;
	}

	public void setRetweetedStatus(Tweet retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tweet [contributors=" + contributors + ", coordinates="
				+ coordinates + ", createdAt=" + createdAt + ", favorited="
				+ favorited + ", geo=" + geo + ", id=" + id
				+ ", inReplyToScreenName=" + inReplyToScreenName
				+ ", inReplyToStatusId=" + inReplyToStatusId
				+ ", inReplyToUserId=" + inReplyToUserId + ", place=" + place
				+ ", source=" + source + ", text=" + text + ", truncated="
				+ truncated + ", user=" + user + "]";
	}
}

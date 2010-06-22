package com.xebia.crass.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterUser {
	@JsonProperty("time_zone")
	private String timeZone;
	
	@JsonProperty("screen_name")
	private String screenName;
	
	@JsonProperty("profile_link_color")
	private String profileLinkColorCode;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("notifications")
	private String notifications;
	
	@JsonProperty("profile_background_image_url")
	private String profileBackgroundImageUrl;
	
	@JsonProperty("statuses_count")
	private int statusesCount;
	
	@JsonProperty("profile_sidebar_fill_color")
	private String profileSidebarFillColorCode;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("profile_background_tile")
	private boolean profileBackgroundTitle;
	
	@JsonProperty("contributors_enabled")
	private boolean contributorsEnabled;
	
	@JsonProperty("profile_sidebar_border_color")
	private String profileSidebarBorderColorCode;
	
	@JsonProperty("lang")
	private String lang;
	
	@JsonProperty("geo_enabled")
	private boolean geoEnabled;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("followers_count")
	private int followersCount;
	
	@JsonProperty("following")
	private String following;
	
	@JsonProperty("friends_count")
	private int friendsCount;
	
	@JsonProperty("protected")
	private boolean userProtected;
	
	@JsonProperty("verified")
	private boolean verified;
	
	@JsonProperty("profile_background_color")
	private String profileBackgroundColorCode;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("favourites_count")
	private int favoritesCount;
	
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("utc_offset")
	private long utcOffset;
	
	@JsonProperty("profile_text_color")
	private String profileTextColorCode;
	
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getProfileLinkColorCode() {
		return profileLinkColorCode;
	}

	public void setProfileLinkColorCode(String profileLinkColorCode) {
		this.profileLinkColorCode = profileLinkColorCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public String getProfileBackgroundImageUrl() {
		return profileBackgroundImageUrl;
	}

	public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
		this.profileBackgroundImageUrl = profileBackgroundImageUrl;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public String getProfileSidebarFillColorCode() {
		return profileSidebarFillColorCode;
	}

	public void setProfileSidebarFillColorCode(String profileSidebarFillColorCode) {
		this.profileSidebarFillColorCode = profileSidebarFillColorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isProfileBackgroundTitle() {
		return profileBackgroundTitle;
	}

	public void setProfileBackgroundTitle(boolean profileBackgroundTitle) {
		this.profileBackgroundTitle = profileBackgroundTitle;
	}

	public boolean isContributorsEnabled() {
		return contributorsEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
	}

	public String getProfileSidebarBorderColorCode() {
		return profileSidebarBorderColorCode;
	}

	public void setProfileSidebarBorderColorCode(
			String profileSidebarBorderColorCode) {
		this.profileSidebarBorderColorCode = profileSidebarBorderColorCode;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public boolean isUserProtected() {
		return userProtected;
	}

	public void setUserProtected(boolean userProtected) {
		this.userProtected = userProtected;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getProfileBackgroundColorCode() {
		return profileBackgroundColorCode;
	}

	public void setProfileBackgroundColorCode(String profileBackgroundColorCode) {
		this.profileBackgroundColorCode = profileBackgroundColorCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(long utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getProfileTextColorCode() {
		return profileTextColorCode;
	}

	public void setProfileTextColorCode(String profileTextColorCode) {
		this.profileTextColorCode = profileTextColorCode;
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
		TwitterUser other = (TwitterUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TwitterUser [contributorsEnabled=" + contributorsEnabled
				+ ", createdAt=" + createdAt + ", description=" + description
				+ ", favoritesCount=" + favoritesCount + ", followersCount="
				+ followersCount + ", following=" + following
				+ ", friendsCount=" + friendsCount + ", geoEnabled="
				+ geoEnabled + ", id=" + id + ", lang=" + lang + ", location="
				+ location + ", name=" + name + ", notifications="
				+ notifications + ", profileBackgroundColorCode="
				+ profileBackgroundColorCode + ", profileBackgroundImageUrl="
				+ profileBackgroundImageUrl + ", profileBackgroundTitle="
				+ profileBackgroundTitle + ", profileImageUrl="
				+ profileImageUrl + ", profileLinkColorCode="
				+ profileLinkColorCode + ", profileSidebarBorderColorCode="
				+ profileSidebarBorderColorCode
				+ ", profileSidebarFillColorCode="
				+ profileSidebarFillColorCode + ", profileTextColorCode="
				+ profileTextColorCode + ", screenName=" + screenName
				+ ", statusesCount=" + statusesCount + ", timeZone=" + timeZone
				+ ", url=" + url + ", userProtected=" + userProtected
				+ ", utcOffset=" + utcOffset + ", verified=" + verified + "]";
	}
}

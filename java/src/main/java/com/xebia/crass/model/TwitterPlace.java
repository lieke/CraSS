package com.xebia.crass.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterPlace {
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("bounding_box")
	private TwitterGeoPoly boundingBox;
	
	@JsonProperty("street_address")
	private String streetAddress;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("place_type")
	private String placeType;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TwitterGeoPoly getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(TwitterGeoPoly boundingBox) {
		this.boundingBox = boundingBox;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	@Override
	public String toString() {
		return "TwitterPlace [boundingBox=" + boundingBox + ", country="
				+ country + ", countryCode=" + countryCode + ", fullName="
				+ fullName + ", id=" + id + ", name=" + name + ", placeType="
				+ placeType + ", streetAddress=" + streetAddress + ", url="
				+ url + "]";
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
		TwitterPlace other = (TwitterPlace) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

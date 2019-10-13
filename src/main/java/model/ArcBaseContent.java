package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArcBaseContent implements Serializable {

    private String _id;
    private String type;
    private String subtype;
    private String version;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("publish_date")
    private String publishDate;

    @SerializedName("first_publish_date")
    private String firstPublishDate;

    @SerializedName("last_updated_date")
    private String lastUpdatedDate;

    @SerializedName("display_date")
    private String displayDate;

    private String[] channels;

    @SerializedName("canonical_url")
    private String canonicalUrl;

    @SerializedName("short_url")
    private String shortUrl;

    private String location;
    private ArcGeo geo;

    private ArcAddress address;
    private String copyright;

    private String status;

    private ArcCredits credits;

    private ArcHeadlines headlines;

//    private ArcTaxonomy taxonomy; TODO

//    private ArcContentRestrictions content_restrictions; TODO

//    private String alignment; TODO

    private String language; //The value should follow IETF BCP47

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getFirstPublishDate() {
        return firstPublishDate;
    }

    public void setFirstPublishDate(String firstPublishDate) {
        this.firstPublishDate = firstPublishDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getChannels() {
        return channels;
    }

    public void setChannels(String[] channels) {
        this.channels = channels;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArcGeo getGeo() {
        return geo;
    }

    public void setGeo(ArcGeo geo) {
        this.geo = geo;
    }

    public ArcCredits getCredits() {
        return credits;
    }

    public void setCredits(ArcCredits credits) {
        this.credits = credits;
    }

    public ArcAddress getAddress() {
        return address;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setAddress(ArcAddress address) {
        this.address = address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public ArcHeadlines getHeadlines() {
        return headlines;
    }

    public void setHeadlines(ArcHeadlines headlines) {
        this.headlines = headlines;
    }
}

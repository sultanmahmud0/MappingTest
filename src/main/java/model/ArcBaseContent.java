package model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@SuperBuilder
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

}

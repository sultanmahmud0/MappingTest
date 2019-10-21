package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArcBaseContent implements Serializable {

    String _id;
    String type;
    String subtype;
    String version;

    @SerializedName("created_date")
    String createdDate;

    @SerializedName("publish_date")
    String publishDate;

    @SerializedName("first_publish_date")
    String firstPublishDate;

    @SerializedName("last_updated_date")
    String lastUpdatedDate;

    @SerializedName("display_date")
    String displayDate;

    String[] channels;

    @SerializedName("canonical_url")
    String canonicalUrl;

    @SerializedName("short_url")
    String shortUrl;

    String location;
    ArcGeo geo;

    ArcAddress address;
    String copyright;

    String status;

    ArcCredits credits;

    ArcHeadlines headlines;

//    ArcTaxonomy taxonomy; TODO

//    ArcContentRestrictions content_restrictions; TODO

//    String alignment; TODO

    String language; //The value should follow IETF BCP47

}

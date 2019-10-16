package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArcAddress implements Serializable {

    @SerializedName("post_office_box")
    private String postOfficeBox;

    @SerializedName("extended_address")
    private String extendedAddress;

    private String locality;
    private String region;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("country_name")
    private String countryName;
}

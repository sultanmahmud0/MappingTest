package model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;

@Data
public class ArcImage extends ArcBaseContent implements Serializable {

    @SerializedName("image_type")
    private String imageType;

    @SerializedName("alt_text")
    private String altText;

    @SerializedName("focal_point")
    private ArcImageFocalPoint focalPoint;

    private String subtitle;
    private String caption;
    private String url;

    private int width;
    private int height;

    private boolean licensable;

    @SerializedName("additional_properties")
    private Map<String,Object> additionalProperties;
}

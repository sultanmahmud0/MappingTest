package model;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ArcImage extends ArcBaseContent implements Serializable {

    @SerializedName("image_type")
    String imageType;

    @SerializedName("alt_text")
    String altText;

    @SerializedName("focal_point")
    ArcImageFocalPoint focalPoint;

    String subtitle;
    String caption;
    String url;

    int width;
    int height;

    boolean licensable;

    @SerializedName("additional_properties")
    Map<String,Object> additionalProperties;
}

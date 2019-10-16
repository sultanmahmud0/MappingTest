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

//    public String getImageType() {
//        return imageType;
//    }
//
//    public void setImageType(String imageType) {
//        this.imageType = imageType;
//    }
//
//    public String getAltText() {
//        return altText;
//    }
//
//    public void setAltText(String altText) {
//        this.altText = altText;
//    }
//
//    public ArcImageFocalPoint getFocalPoint() {
//        return focalPoint;
//    }
//
//    public void setFocalPoint(ArcImageFocalPoint focalPoint) {
//        this.focalPoint = focalPoint;
//    }
//
//    public String getSubtitle() {
//        return subtitle;
//    }
//
//    public void setSubtitle(String subtitle) {
//        this.subtitle = subtitle;
//    }
//
//    public String getCaption() {
//        return caption;
//    }
//
//    public void setCaption(String caption) {
//        this.caption = caption;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public boolean isLicensable() {
//        return licensable;
//    }
//
//    public void setLicensable(boolean licensable) {
//        this.licensable = licensable;
//    }
//
//    public Map<String, Object> getAdditionalProperties() {
//        return additionalProperties;
//    }
//
//    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
//        this.additionalProperties = additionalProperties;
//    }
}

package model;

import com.google.gson.annotations.SerializedName;

public class ArcCredits {

    private ArcCreditsBy[] by;

    @SerializedName("photos_by")
    private ArcCreditsBy[] photosBy;

    public ArcCreditsBy[] getBy() {
        return by;
    }

    public void setBy(ArcCreditsBy[] by) {
        this.by = by;
    }

    public ArcCreditsBy[] getPhotosBy() {
        return photosBy;
    }

    public void setPhotosBy(ArcCreditsBy[] photosBy) {
        this.photosBy = photosBy;
    }
}
package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArcCredits implements Serializable {

    private ArcCreditsBy[] by;

    @SerializedName("photos_by")
    private ArcCreditsBy[] photosBy;
}

package model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ArcCredits implements Serializable {

    private ArcCreditsBy[] by;

    @SerializedName("photos_by")
    private ArcCreditsBy[] photosBy;
}

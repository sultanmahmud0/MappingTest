package model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ArcGeo implements Serializable {
    private float latitude;
    private float longitude;
}

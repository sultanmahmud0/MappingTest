package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArcGeo implements Serializable {
    private float latitude;
    private float longitude;
}

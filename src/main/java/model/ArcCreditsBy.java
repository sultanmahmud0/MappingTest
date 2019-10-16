package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArcCreditsBy implements Serializable {

    private String byline;
    private String name;
    private String type;
    private String version;
}

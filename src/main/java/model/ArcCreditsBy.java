package model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ArcCreditsBy implements Serializable {

    private String byline;
    private String name;
    private String type;
    private String version;
}

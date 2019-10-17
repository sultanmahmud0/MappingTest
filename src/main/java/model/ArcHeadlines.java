package model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ArcHeadlines implements Serializable {
    private String basic;
}

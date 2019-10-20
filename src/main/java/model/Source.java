package model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString(callSuper = true)
@Builder
public class Source {

    private String sourceId;
    private int sourceNumber;
    private boolean sourceStatus;

    private String childTitle;
    private boolean childStatus;
    private String childPlace;
}

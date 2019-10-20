package model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString(callSuper = true)
@Builder
public class Source {

    String sourceId;
    int sourceNumber;
    boolean sourceStatus;

    String childTitle;
    boolean childStatus;
    String childPlace;

    Map<String,Object> sourceMap;
    Task task;
}

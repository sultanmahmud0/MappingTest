package model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Source {

    String sourceId;
    int sourceNumber;
    boolean sourceStatus;

    String subTitle;
    Map<String,Object> sourceMap;
}

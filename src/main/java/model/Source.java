package model;

import lombok.*;

import java.util.Date;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Source {

    private long id;
    private Date date;
    private Map<String,Object> sourceMap;
}

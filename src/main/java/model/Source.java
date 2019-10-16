package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class Source {

    private long id;
    private Date date;
    private Map<String,Object> sourceMap;
}

package model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;

@Value
@Builder
public class ArcAdditionalProperties implements Serializable {
    private Map<String, Object> data;
}

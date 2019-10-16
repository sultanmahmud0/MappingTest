package model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class ArcAdditionalProperties implements Serializable {
    private Map<String, Object> data = new HashMap<>();
}

package model;

import java.util.HashMap;
import java.util.Map;

public class ArcAdditionalProperties {

    private Map<String, Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

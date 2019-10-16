package model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Aspect implements Serializable {
	private Map<String, Object> data = new HashMap<>();
	private Map<String, String> customAttributes = new HashMap<>();
}

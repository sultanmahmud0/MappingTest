package model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Aspect {

	private Map<String, Object> data = new HashMap<>();
	private Map<String, String> customAttributes = new HashMap<>();
}

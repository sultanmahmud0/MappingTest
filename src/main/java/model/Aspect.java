package model;

import java.util.HashMap;
import java.util.Map;

public class Aspect {

	private Map<String, Object> data = new HashMap<>();
	private Map<String, String> customAttributes = new HashMap<>();
	
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, String> getCustomAttributes() {
		return customAttributes;
	}

	public void setCustomAttributes(Map<String, String> customAttributes) {
		this.customAttributes = customAttributes;
	}
}

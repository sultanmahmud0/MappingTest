package model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class DocData implements Serializable {
	
	private String id;
	private String version; 
	private Meta meta;
	private Map<String, Aspect> aspects = new HashMap<>();
}

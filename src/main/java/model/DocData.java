package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DocData implements Serializable {
	
	private String id;
	private String version; 
	private Meta meta;
	private Map<String, Aspect> aspects = new HashMap<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, Aspect> getAspects() {
		return aspects;
	}
	public void setAspects(Map<String, Aspect> aspects) {
		this.aspects = aspects;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}

package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DocData implements Serializable {
	
	private String id;
	private String version; 
	private Meta meta;
	private Map<String, Aspect> aspects;
}

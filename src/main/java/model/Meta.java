package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Meta implements Serializable {
    private String modificationTime; 
    private String originalCreationTime;
}

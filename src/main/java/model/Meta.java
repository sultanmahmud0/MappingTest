package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Meta implements Serializable {
    private String modificationTime; 
    private String originalCreationTime;
}

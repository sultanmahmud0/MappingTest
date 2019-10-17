package model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ArcImageFocalPoint implements Serializable {

    private int x;
    private int y;
}

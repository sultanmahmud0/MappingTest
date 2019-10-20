package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    boolean taskStatus;
    String taskName;
}

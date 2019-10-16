package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Target {

    private String uid;
    private String msg;
    private String date;
    private boolean hiddenStatus;
    private String hiddenPlace;
}

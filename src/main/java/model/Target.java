package model;

import lombok.*;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Target {

    private String uid;
    private String msg;
    private String date;
    private boolean hiddenStatus;
    private String hiddenPlace;
}

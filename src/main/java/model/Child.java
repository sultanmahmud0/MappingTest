package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Child extends Parent {

    String secondaryTitle;
    boolean secondaryStatus;
    String secondaryPlace;
    Order secondaryOrder;
    String taskNumber;
    String template;
    String type;
}

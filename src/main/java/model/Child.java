package model;

import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Child extends Parent {

    private String secondaryTitle;
    private boolean secondaryStatus;
    private String secondaryPlace;

    public Child(){
    }

    public Child(String id, int number, boolean status, String secondaryTitle, boolean secondaryStatus, String secondaryPlace) {
        super(id, number, status);
        this.secondaryTitle = secondaryTitle;
        this.secondaryStatus = secondaryStatus;
        this.secondaryPlace = secondaryPlace;
    }

    protected Child(String id, int number, boolean status){
        super(id, number, status);
    }
}

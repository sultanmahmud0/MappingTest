package model;

import lombok.*;

@Data
@ToString(callSuper = true)
public class Child extends Parent {

    private String subTitle;
    private boolean secondaryStatus;

    public Child(){
    }

    public Child(String id, int number, boolean status,String subTitle,boolean secondaryStatus){
        super(id,number,status);
        this.subTitle = subTitle;
        this.secondaryStatus = secondaryStatus;
    }

    protected Child(String id, int number, boolean status){
        super(id,number,status);
    }
}

package model;

import lombok.*;

@Data
public abstract class Parent {

    private String id;
    private int number;
    private boolean status;

    public Parent(){
    }

    protected Parent(String id, int number, boolean status) {
        this.id = id;
        this.number = number;
        this.status = status;
    }
}

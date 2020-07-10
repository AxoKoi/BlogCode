package com.axokoi.misc.post20200713;

public class Child extends Parent{

    {
        System.out.println("Child first initialization block");
    }
    public Child() {
        System.out.println("Child Constructor without argument");
    }

    public Child(int value) {
        super(value);
        System.out.println("Child Constructor with argument");
    }

    {
        System.out.println("Child second initialization block");
    }
}

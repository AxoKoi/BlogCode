package com.axokoi.misc.post20200713;

public class Parent {

    {
        System.out.println("Parent initialization block");
    }

    public Parent() {
        System.out.println("Parent Constructor without argument");
    }

    public Parent(int value) {
        System.out.println("Parent Constructor with argument");
    }
}

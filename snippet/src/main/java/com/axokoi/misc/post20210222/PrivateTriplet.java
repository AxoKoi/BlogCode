package com.axokoi.misc.post20210222;

public class PrivateTriplet {
   static final Integer staticValue = 5;
   private int x = -1;
   private final int y = -2;
   private final Integer z = 10;

   private PrivateTriplet(int x) {
      this.x = x;
   }

   private void display() {
      System.out.println(" x = " + x + " / y = " + y + " / z = " + z + " / staticValue = " + staticValue);
   }
}

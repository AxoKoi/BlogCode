package com.axokoi.misc.post20210229;

public class Calculator {

   private int internalMultiplier = 1;

   public int compute(int value, int partialSum) {
      value = (15 * value - 3) * value;
      internalMultiplier = MultiplierProvider.get();
      return value * performSubtraction(value, partialSum);
   }

   private int performSubtraction(int value, int partialSum) {
      return internalMultiplier * (partialSum - 5 * value);
   }
}

package com.axokoi.misc.post20210229;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorTestWithBefore {

   private Method methodToTest;
   private Calculator calculator;

   @Before
   public void init() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
      calculator = new Calculator();

      Class<Calculator> clazz = Calculator.class;
      Field internalMultiplier = clazz.getDeclaredField("internalMultiplier");
      internalMultiplier.setAccessible(true);
      internalMultiplier.set(calculator, 1);

      methodToTest = clazz.getDeclaredMethod("performSubtraction", int.class, int.class);
      methodToTest.setAccessible(true);
   }

   @Test
   public void valueIsZeroTest() throws InvocationTargetException, IllegalAccessException {
      int value = 10;
      int result = (int) methodToTest.invoke(calculator, value, 0);
      Assert.assertEquals(-50, result);
   }

   @Test
   public void partialSumIsZero() throws InvocationTargetException, IllegalAccessException {
      int partialSum = 5;
      int result = (int) methodToTest.invoke(calculator, 0, partialSum);
      Assert.assertEquals(partialSum, result);
   }

   @Test
   public void performSubtraction() throws InvocationTargetException, IllegalAccessException {
      int value = 10;
      int partialSum = 5;
      int result = (int) methodToTest.invoke(calculator, value, partialSum);
      Assert.assertEquals(-45, result);
   }

}

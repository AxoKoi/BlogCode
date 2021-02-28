package com.axokoi.misc.post20210229;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorTest {


   @Test
   public void performSubtraction() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

      Calculator calculator = new Calculator();

      Class<Calculator> clazz = Calculator.class;
      Field internalMultiplier = clazz.getDeclaredField("internalMultiplier");
      internalMultiplier.setAccessible(true);
      internalMultiplier.set(calculator, 1);

      Method methodToTest = clazz.getDeclaredMethod("performSubtraction", int.class, int.class);
      methodToTest.setAccessible(true);

      int result = (int) methodToTest.invoke(calculator, 1, 15);
      Assert.assertEquals(10, result);
   }
}
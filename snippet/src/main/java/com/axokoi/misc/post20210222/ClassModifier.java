package com.axokoi.misc.post20210222;

import java.lang.reflect.*;

public class ClassModifier {


   public static void main(String[]args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {


      Class<PrivateQuartet> clazz = (Class<PrivateQuartet>) Class.forName("com.axokoi.misc.post20210222.PrivateQuartet");

      Method displayMethod = clazz.getDeclaredMethod("display");
      displayMethod.setAccessible(true);

      Constructor<PrivateQuartet> constructor = clazz.getDeclaredConstructor(Integer.TYPE);
      constructor.setAccessible(true);

      PrivateQuartet privateQuartet = constructor.newInstance(3);
      displayMethod.invoke(privateQuartet);

      Field yField = clazz.getDeclaredField("y");
      yField.setAccessible(true);
      yField.set(privateQuartet, 5000);

      Field zField = clazz.getDeclaredField("z");
      zField.setAccessible(true);
      zField.set(privateQuartet, 1000);

      displayMethod.invoke(privateQuartet);

      Field staticField = clazz.getDeclaredField("staticValue");
      staticField.setAccessible(true);
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(staticField, staticField.getModifiers() & ~Modifier.FINAL);
      staticField.set(null, 50);
      displayMethod.invoke(privateQuartet);
   }

}


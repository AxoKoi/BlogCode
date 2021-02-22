package com.axokoi.misc.post20210222;

import java.lang.reflect.*;

public class ClassModifier {


   public static void main(String[]args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {


      Class<PrivateTriplet> clazz = (Class<PrivateTriplet>) Class.forName("com.axokoi.misc.post20210222.PrivateTriplet");

      Method displayMethod = clazz.getDeclaredMethod("display");
      displayMethod.setAccessible(true);

      Constructor<PrivateTriplet> constructor = clazz.getDeclaredConstructor(Integer.TYPE);
      constructor.setAccessible(true);

      PrivateTriplet privateTriplet = constructor.newInstance(3);
      displayMethod.invoke(privateTriplet);

      Field yField = clazz.getDeclaredField("y");
      yField.setAccessible(true);
      yField.set(privateTriplet, 5000);

      Field zField = clazz.getDeclaredField("z");
      zField.setAccessible(true);
      zField.set(privateTriplet, 1000);

      displayMethod.invoke(privateTriplet);

      Field staticField = clazz.getDeclaredField("staticValue");
      staticField.setAccessible(true);
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(staticField, staticField.getModifiers() & ~Modifier.FINAL);
      staticField.set(null, 50);
      displayMethod.invoke(privateTriplet);
   }

}


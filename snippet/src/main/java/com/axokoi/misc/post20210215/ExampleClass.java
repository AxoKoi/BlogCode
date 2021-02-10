package com.axokoi.misc.post20210215;

import java.util.Arrays;

public class ExampleClass {

   public Integer publicInteger = 20;
   private Integer privateInteger = 10;

   public ExampleClass() {
   }

   private ExampleClass(Integer x, Integer y) {
      this.publicInteger = x;
      this.privateInteger = y;
   }

   public Integer add() {
      return privateInteger + publicInteger;
   }

   private Integer multiply() {
      return privateInteger * publicInteger;
   }

   public static void main(String[] args) throws NoSuchMethodException {
      /*Magic come here*/
      Class<ExampleClass> clazz = ExampleClass.class;

      System.out.println("-- Constructores públicos---");
      Arrays.stream(clazz.getConstructors()).forEach(System.out::println);
      System.out.println("");

      System.out.println("-- Constructores privados---");
      Arrays.stream(clazz.getDeclaredConstructors()).forEach(System.out::println);
      System.out.println("");

      System.out.println("-- Atributos públicos---");
      Arrays.stream(clazz.getFields()).forEach(System.out::println);
      System.out.println("");

      System.out.println("-- Atributos privados---");
      Arrays.stream(clazz.getDeclaredFields()).forEach(System.out::println);
      System.out.println("");

      System.out.println("-- Métodos públicos---");
      Arrays.stream(clazz.getMethods()).forEach(System.out::println);
      System.out.println("");

      System.out.println("-- Métodos privados---");
      Arrays.stream(clazz.getDeclaredMethods()).forEach(System.out::println);
   }

}

package com.cjme.AccessModifiers.p2;

import com.cjme.AccessModifiers.p1.A;

public class C extends A {

  public static void main(String[] args) {
    A aObject = new A();
    System.out.println(aObject.d);

    C cObject = new C();
    System.out.println(cObject.c);
    System.out.println(cObject.d);

  }

}

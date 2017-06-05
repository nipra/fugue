package com.masterclass.interruptjoin;

import static com.masterclass.interruptjoin.ThreadColor.ANSI_BLUE;

/**
 * Created by timbuchalka on 25/05/2016.
 */
public class AnotherThread extends Thread {

  @Override
  public void run() {
    System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      System.out.println(ANSI_BLUE + "Another thread woke me up");
      return;
    }

    System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
  }
}

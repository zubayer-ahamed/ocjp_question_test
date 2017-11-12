
package com.coderslab.test;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Question1 implements Runnable{

    @Override
    public void run() {
        System.out.println("run. ");
        throw new RuntimeException("Problem");
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Question1());
        t.start();
        System.out.println("main thread");
    }
    
    
    
    
    
}

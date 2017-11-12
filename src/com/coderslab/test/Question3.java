package com.coderslab.test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Question3 implements Runnable {

    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        System.out.println(Thread.currentThread().getName());
        synchronized (Thread.currentThread()) {
            System.out.println("hello");
            obj.wait();
            obj.notify();
        }
    }

    @Override
    public void run() {

        Thread.currentThread().setName("child thread");
        try {
            waitForSignal();
        } catch (InterruptedException ex) {
            Logger.getLogger(Question3.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("run. ");
        throw new RuntimeException("Problem");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("main thread");
        Question3 q3 = new Question3();
        q3.waitForSignal();

        Thread t = new Thread(new Question3());
        t.start();
        System.out.println("main thread answer");

    }

}

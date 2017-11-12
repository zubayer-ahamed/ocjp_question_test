package com.coderslab.test;

import java.util.logging.Level;
import java.util.logging.Logger;

class PingPong2{
    synchronized void hit(long n){
        for (int i = 1; i < 3; i++) {
            System.out.println(n + "-" + i + " ");
        }
    }
}

public class Question4 implements Runnable {

    static PingPong2 pp2 = new PingPong2();
    
    public static void main(String[] args) {
        new Thread(new Question4()).start();
        new Thread(new Question4()).start();
        
    }

    @Override
    public void run() {
        pp2.hit(Thread.currentThread().getId());
    }

}

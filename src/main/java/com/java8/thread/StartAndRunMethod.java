package com.java8.thread;

import java.util.function.Supplier;

/**
 * @author nagpalh
 * 
 * Actually Thread.start() creates a new thread and have its own execution scenario.
 *  Thread.start() internally calls the run() method asynchronously,
 *  which changes the state of new Thread to Runnable.
 * 
 * But Thread.run() does not create any new thread. 
 *  Instead it execute the run method in the current running thread synchronously.
 *  If you are using Thread.run() then you are not using the features of multi-threading at all.
 */
public class StartAndRunMethod
{
    static int count = 0;


    public static void main(String[] args) throws InterruptedException
    {

        Thread simpleThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("in run method : " + ++count);
            }
        });

        // Note : 1) run() method is implemented in runnable interface so calling it is nothing related to threads or threading....
        //           It is just like calling a simple method. 
        //           So, calling it will not create any new thread instead it is executed under same current thread.
        //        2) When we call start() method it creates a new thread and it internally calls run() method
        //           and the run() method is executed by that new thread.
        //        3) So, simply we can call run() method any number of times as it's just a simple method call that execute within same thread.
        //           but we can't call start() method more than once, ie can't start same new thread twice.
        //        4) Q) If run() method is under runnable interface so how we are able to call it using Thread Object??
        //           A) Because Thread class implements runnable interface.

        // run() method can be called multiple times
        simpleThread.run();
        simpleThread.run();
        simpleThread.run();
        simpleThread.run();

        // start() method cann't be called more than once
        simpleThread.start();
        //simpleThread.start(); // illegalState Exception

        // Lazy Evaluation
        final Supplier<Integer> myInt;
        myInt = () -> 42;

        System.out.println("Supplier<Integer> : " + myInt + "\nInteger : " + myInt.get());
    }

}

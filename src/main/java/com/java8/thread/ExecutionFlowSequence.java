package com.java8.thread;

public class ExecutionFlowSequence
{
    public static void main(String[] args)
    {

        // We will start 3 Thread and Do Check which will run first or last multiple times?
        int[] arr = {2, 5, 4, 1, 7};
        Thread th1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                somework(arr);
                arr[2] = 20;
                System.out.println("Value converted");
            }


            private void somework(int[] arr)
            {
                for (int element : arr)
                    System.out.println("First Thread Element : " + element);
            }
        });

        Thread th2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("Second Thread arr[2] : " + arr[2]);
            }
        });

        // Start a new thread and perform someOperation and then change arr[2].
        th1.start();

        // Starts a new thread at the same time th1 is processing, and getting value of arr[2]
        th2.start();

        // Use of ThreadLocal<Object>
        ThreadLocal<Integer> intThread = new ThreadLocal<>();
        intThread.set(12);
        System.out.println(intThread.get());

    }
}

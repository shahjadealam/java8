package com.java8.functional.interfaces;

public class myFunctionalInterfaceClass
{
    public static void main(String[] args)
    {

        // 1) BiFunction   : It will take two parameter and return single value(any type)
        // 2) Function     : It will take one parameter and return single value(any type)

        // 3) BiPredicate  : It will take two parameter and return boolean result
        // 4) Predicate    : It will take one parameter and return boolean result

        // 5) Consumer     : It will take One parameter and return void 
        // 6) Supplier     : It will take zero parameter and return single result as Callable

        // 7) Binary       : It will take two parameter and return single value(same type)
        // 8) Unary        : It will take one parameter and return single value(same type)

        // For Coding examples, please visit "java8.method.reference" package

        // 9) Other Functional Interfaces : Runnable

        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("r1, Thread Running : " + Thread.currentThread().getName());
            }
        };

        Runnable r2 = () -> System.out.println("r2, Thread Running : " + Thread.currentThread().getName());

        r1.run();
        r2.run();
    }
}

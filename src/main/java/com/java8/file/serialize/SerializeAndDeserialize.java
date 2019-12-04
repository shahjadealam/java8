package com.java8.file.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java8.data.Employee;
import com.java8.data.Employee.Sex;

public class SerializeAndDeserialize
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // Basic Explanation :-
        // a) Only ObjectOutputStream allow us to write Object directly into file.
        //    Using 'writeObject(object)' function over it. 
        // b) Only ObjectInputStream allow us to read Object directly from file.
        //    Using 'readObject()' function over it. 

        // 1) Create Object and File
        Employee emp = new Employee("Himanshu", 1, "HCL", Sex.Male, 25000.0, "harry7777");
        File file = new File("Employee.txt");

        // 2) Create ObjectOutputStream of file to directly write object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(emp);

        // 3) Reading Object from file using ObjectInputStream 
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object obj = ois.readObject();

        // 4) Verify : password will be null as it is transient so will not serialize
        System.out.println(obj);

        // 5) Close Resources
        oos.close();
        ois.close();

    }

}

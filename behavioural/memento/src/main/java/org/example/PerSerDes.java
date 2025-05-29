package org.example;

import java.io.*;

public class PerSerDes {

    public void serialize(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Person person = new Person("abc", 10);
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deserialize(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Name : " + person.getName() + " , Age : " + person.getAge());
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {
        MyInstance myInstance1 = MyInstance.getInstance();

        MyInstance myInstance2 = MyInstance.getInstance();

        if(myInstance1 == myInstance2){
            System.out.println("Its an Singleton Object");
        }
    }
}
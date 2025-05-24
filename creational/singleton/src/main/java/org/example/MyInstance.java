package org.example;

public class MyInstance {

    public static volatile MyInstance myInstance;

    private MyInstance() {
    }

    public static MyInstance getInstance() {
        if(myInstance == null){
            synchronized (MyInstance.class){
                if(myInstance == null){
                    myInstance = new MyInstance();
                }
            }
        }
        return myInstance;
    }
}

package org.example;

public class Main {

    public static void main(String[] args) {
        String fileName = "perSer.txt";
        PerSerDes perSerDes = new PerSerDes();
        perSerDes.serialize(fileName);

        perSerDes.deserialize(fileName);
    }
}
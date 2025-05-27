package org.example;

public class Main {
    public static void main(String[] args) {

        EWSService ewsService = new EWSService();

        Command c1 = new AddMemberCommand("a@a.com", "spam", ewsService);
        c1.execute();

        Command c2 = new RemoveMemberCommand("abc@com", "spam1", ewsService);
        c2.execute();
    }
}
package org.example;

public class RemoveMemberCommand implements Command {

    private String emailAddress;

    private String listName;

    private EWSService receiver;

    public RemoveMemberCommand(String emailAddress, String listName, EWSService service) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.receiver = service;
    }

    @Override
    public void execute() {
        receiver.addMember(emailAddress, listName);
    }
}

package org.example;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.Sick)
                .from(LocalDate.now()).to(LocalDate.of(2018, 2, 28))
                .build();
        System.out.println(application);
        System.out.println("**************************************************");
        LeaveApprover approver = createChain();
        approver.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead lead = new ProjectLead(manager);
        return lead;
    }
}
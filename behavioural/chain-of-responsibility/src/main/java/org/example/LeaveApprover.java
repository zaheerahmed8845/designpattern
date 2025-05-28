package org.example;

public interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();

}

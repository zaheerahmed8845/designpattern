package org.example.account;

import org.example.entity.Address;
import org.example.enums.AccountStatus;


public class Admin extends Account {

    public Admin(String id,
                 String password,
                 Address address,
                 String email,
                 String phone) {
        super(id, password, AccountStatus.ACTIVE, address, email, phone);
    }

    public boolean blockMember(Member m) {
        if (m == null) return false;
        m.setStatus(AccountStatus.BLACKLISTED);
        return true;
    }

    public boolean unblockMember(Member m) {
        if (m == null) return false;
        m.setStatus(AccountStatus.ACTIVE);
        return true;
    }

    public boolean cancelMembership(Member m) {
        if (m == null) return false;
        m.setStatus(AccountStatus.CANCELED);
        return true;
    }
}

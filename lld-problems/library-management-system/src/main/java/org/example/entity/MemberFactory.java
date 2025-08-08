package org.example.entity;

import org.example.entity.user.Member;
import org.example.enums.AccountStatus;

public class MemberFactory {
    public static Member createMember(String id, String name) {
        Member member = new Member();
        member.id = id;
        Person p = new Person();
        p.name = name;
        member.person = p;
        member.status = AccountStatus.ACTIVE;
        return member;
    }
}

package org.example.component.decorator;

import org.example.component.ContentComponent;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ShareDecorator extends ContentDecorator {
    private final List<User> sharedBy = new ArrayList<>();

    public ShareDecorator(ContentComponent inner) {
        super(inner);
    }

    @Override
    public void share(User by) {
        super.share(by);
        sharedBy.add(by);
    }

    public List<User> getSharedBy() {
        return sharedBy;
    }
}

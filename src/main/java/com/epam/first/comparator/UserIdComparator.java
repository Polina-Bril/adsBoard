package com.epam.first.comparator;

import com.epam.first.entity.User;

import java.util.Comparator;

public class UserIdComparator  implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getUserId() - user2.getUserId();
    }
}
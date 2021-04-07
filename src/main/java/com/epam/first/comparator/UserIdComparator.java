package com.epam.first.comparator;

import com.epam.first.model.entity.User;

import java.util.Comparator;

public class UserIdComparator  implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return (int) (user1.getUserId() - user2.getUserId());
    }
}

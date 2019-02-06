package com.huallpa.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Nestor", new Date()));
        users.add(new User(2, "Juan", new Date()));
        users.add(new User(3, "Alberto", new Date()));
    }

    private static Integer cantUser = 3;

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++cantUser);
        }
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        for (User user:users) {
            if (user.getId() == id) {
                return  user;
            }
        }
        return null;
    }

    public User deleteById(Integer id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}

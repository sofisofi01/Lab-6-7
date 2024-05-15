package com.example.lab4.model.dao;

import com.example.lab4.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static int getUsers_count() {
        return users_count;
    }

    public static void setUsers_count(int users_count) {
        UserDAO.users_count = users_count;
    }

    private static int users_count;
    private static List<User> users;
    public UserDAO()
    {
        String[] names = {"SofiZav","Test1","Test2","Test3"};
        String[] passwords = {"qwerty","123","1234","12345"};
        String[] emails = {"sofi@gmail.com","test1@test.com","test2@test.com","test3@test.com"};
        users = new ArrayList<>();
        for (int users_count = 0; users_count < names.length; users_count++) {
            users.add(new User(users_count + 1, names[users_count], emails[users_count], passwords[users_count]));
        }
    }



    public List<User> index(){
        return users;
    }
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public static void save(User user) {
        user.setId(++users_count);
        users.add(user);
    }

    public void update(int id, User user) {
        User updatedUser = show(id);
        if (updatedUser != null) {
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
        }
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}

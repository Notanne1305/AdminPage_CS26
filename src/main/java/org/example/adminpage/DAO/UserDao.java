package org.example.adminpage.DAO;

import org.example.adminpage.Model.User;

public interface UserDao {

    void createUser(User user);
    boolean findUser(User user);

}


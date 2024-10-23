package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
//        userDao.saveUser("Bob", "Petrov", (byte) 20);
//        userDao.saveUser("Alex", "Ivanov", (byte) 25);
//        userDao.saveUser("Grisha", "Sidorov", (byte) 27);
        userDao.getAllUsers();
        userDao.cleanUsersTable();

    }
}

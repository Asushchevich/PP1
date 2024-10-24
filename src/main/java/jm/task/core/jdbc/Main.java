package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.xml.XMLStreamConstantsUtils;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
//        userDao.saveUser("Bob", "Petrov", (byte) 20);
//        userDao.saveUser("Alex", "Ivanov", (byte) 25);
//        userDao.saveUser("Grisha", "Sidorov", (byte) 27);
//        List<User> usersss = userDao.getAllUsers();
//        usersss.forEach(System.out::println);
//        userDao.cleanUsersTable();
        Util.getSessionFactory();


        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        List<User> usersss = userDaoHibernate.getAllUsers();
        usersss.forEach(System.out::println);
    }
}

//Аdd new methods
//1) saveUser
//2) getAllUser
//3) createUsersTable
//4) dropUsersTable
//5) removeUserById
//6) cleanUsersTable
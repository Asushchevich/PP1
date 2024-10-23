package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "CREATE TABLE IF NOT EXISTS user_list (" +
                    "id SERIAL PRIMARY KEY," +
                    "first_name VARCHAR(128) NOT NULL," +
                    "last_name VARCHAR(128) NOT NULL," +
                    "age INT NOT NULL)";
            stmt.execute(sql);
            System.out.println("Таблица создана.");
    } catch (SQLException e) {
        System.out.println("Не получилось создать таблицу: " + e.getMessage());
    }
    }

    public void dropUsersTable() {
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "DROP TABLE user_list";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "INSERT INTO user_list (first_name, last_name, age) " +
                    "VALUES ('" + name + "', '" + lastName + "', " + age + ")";

            stmt.executeUpdate(sql);
            System.out.println("Пользователь добавлен: " + name + " " + lastName);
        } catch (SQLException e) {
            System.out.println("Не удалось добавить человека: " + e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "DELETE FROM user_list WHERE id = " + id;

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить человека человека " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "SELECT * FROM user_list";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                byte age = rs.getByte("age");

                System.out.println("Получен пользователь: " + firstName + " " + lastName + ", возраст: " + age);

                User user = new User(firstName, lastName, age);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось вывести таблицу " + e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        try (   Connection conn = Util.getConnection();
                Statement stmt = conn.createStatement()){

            String sql = "DELETE FROM user_list";

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить все записи " + e.getMessage());
        }
    }
}

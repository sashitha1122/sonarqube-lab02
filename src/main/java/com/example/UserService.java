package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public boolean findUser(String username) throws SQLException {

    String sql = "SELECT 1 FROM users WHERE name = ?";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password);
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);

        try (ResultSet rs = ps.executeQuery()) {
            return rs.next(); // true if user exists
        }
    }
}

    // EVEN WORSE: another SQL injection
public boolean deleteUser(String username) throws SQLException {

    String sql = "DELETE FROM users WHERE name = ?";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password);
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // true if deleted
    }
}


}

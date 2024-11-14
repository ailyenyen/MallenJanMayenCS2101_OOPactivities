package src.models;

import java.sql.*;
import java.time.LocalDate;

public class User {
    private int userId;
    private String username;
    private String password;
    private LocalDate dateJoined;  // Store as LocalDate for just the date

    // Alternative constructor to set all details
    public User(int userId, String username, String password, Timestamp dateJoinedTimestamp) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.dateJoined = dateJoinedTimestamp.toLocalDateTime().toLocalDate();  // Convert to LocalDate
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDateJoined() {

        return dateJoined;
    }
}

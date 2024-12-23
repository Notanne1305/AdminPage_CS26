package org.example.adminpage.DaoImpl;

import org.example.adminpage.DatabaseConnection;
import org.example.adminpage.KioskDatabaseConnection;
import org.example.adminpage.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {

    public void createCategory(Category category) {
        String sql = "INSERT INTO foodcategories(name, img_src) VALUES (?, ?)";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getCategoryImage());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean checkDuplicateCategory(String categoryName) {
        String sql = "SELECT * FROM foodcategories WHERE name = ?";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

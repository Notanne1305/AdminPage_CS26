package org.example.adminpage.DaoImpl;

import org.example.adminpage.DatabaseConnection;
import org.example.adminpage.KioskDatabaseConnection;
import org.example.adminpage.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Category> getAllCategory(){
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM foodcategories";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("name"));
                category.setCategoryImage(rs.getString("img_src"));
                category.setCreatedAt(rs.getTimestamp("created_at"));
                category.setUpdatedAt(rs.getTimestamp("updated_at"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;

    }
    public List<String> getAllCategoryNames(){
        List<String> categories = new ArrayList<>();
        String sql = "SELECT name FROM foodcategories";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                categories.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

}

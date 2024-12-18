package org.example.adminpage.DaoImpl;

import org.example.adminpage.KioskDatabaseConnection;
import org.example.adminpage.Model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KioskDao {

public List<Food> getFoodsByCategoryId(int categoryId) {
        String sql = "SELECT * FROM Foods WHERE category_id = ?";
        List<Food> foods = new ArrayList<>();

        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("food_id"));
                food.setName(rs.getString("name"));
                food.setPrice(rs.getBigDecimal("price"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setImgSrc(rs.getString("img_src"));
                food.setStock(rs.getInt("stock"));
                food.setCreatedAt(rs.getTimestamp("created_at"));
                food.setUpdatedAt(rs.getTimestamp("updated_at"));
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foods;
    }
    public void updateStock(int foodId, int stock) {
        String selectSql = "SELECT stock FROM foods WHERE food_id = ?";
        String updateSql = "UPDATE foods SET stock = ? WHERE food_id = ?";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            selectStmt.setInt(1, foodId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int currentQuantity = rs.getInt("stock");
                int newQuantity = currentQuantity + stock;

                updateStmt.setInt(1, newQuantity);
                updateStmt.setInt(2, foodId);
                updateStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStockByFoodId(int foodId){
        String sql = "SELECT stock FROM foods WHERE food_id = ?";

        try(Connection conn = KioskDatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, foodId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt("stock");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public void subtractStock(int foodId, int stock) {
    String selectSql = "SELECT stock FROM foods WHERE food_id = ?";
    String updateSql = "UPDATE foods SET stock = ? WHERE food_id = ?";
    try (Connection conn = KioskDatabaseConnection.getConnection();
         PreparedStatement selectStmt = conn.prepareStatement(selectSql);
         PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

        selectStmt.setInt(1, foodId);
        ResultSet rs = selectStmt.executeQuery();

        if (rs.next()) {
            int currentQuantity = rs.getInt("stock");
            int newQuantity = currentQuantity - stock;

            if (newQuantity < 0) {
                newQuantity = 0; // Ensure stock does not go below zero
            }

            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, foodId);
            updateStmt.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
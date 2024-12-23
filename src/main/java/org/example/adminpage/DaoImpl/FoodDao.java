package org.example.adminpage.DaoImpl;

import org.example.adminpage.KioskDatabaseConnection;
import org.example.adminpage.Model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {

    public List<Food> getAllFood() {

        List<Food> foods = new ArrayList<>();
        String sql = "SELECT * FROM foods";
        try (Connection conn = KioskDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
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
}

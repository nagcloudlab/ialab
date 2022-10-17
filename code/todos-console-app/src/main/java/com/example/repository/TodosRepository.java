package com.example.repository;

import com.example.connection.ConnectionFactory;
import com.example.entity.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodosRepository {

    public void save(Todo todo) {
        {

            Connection connection = null;
            try {
                connection = ConnectionFactory.getConnection();
                // step-3 : create jdbc statements with SQL
                String sql = "insert into todos(title,completed,type,user_id) values(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, todo.getTitle());
                preparedStatement.setBoolean(2, false);
                preparedStatement.setString(3, todo.getType().toString());
                preparedStatement.setInt(4, todo.getUser().getId());
                //step-4 : execute statements & process results
                int affectedRow = preparedStatement.executeUpdate();
                if (affectedRow == 1)
                    System.out.println("New Todo saved");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


        }
    }

}

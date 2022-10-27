package com.example.repository;

import com.example.connection.ConnectionFactory;
import com.example.entity.Todo;
import com.example.entity.TodoType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTodoRepository {

    // C
    public void save(Todo todo) {

        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // step-3 : create jdbc statements with SQL
            String sql = "insert into todos(title,completed,type,user_id) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setBoolean(2, false);
            preparedStatement.setString(3, todo.getType().toString());
            preparedStatement.setInt(4, 1);
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

    // R
    public List<Todo> findAll() {
        Connection connection = null;
        List<Todo> todos = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();

            // step-3 : create jdbc statements with SQL
            String sql = "select * from todos";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //step-4 : execute statements & process results
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setCompleted(rs.getBoolean("completed"));
                todo.setType(TodoType.valueOf(rs.getString("type")));
                todos.add(todo);
            }
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
        return todos;
    }

    public Optional<Todo> findById(int id) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // step-3 : create jdbc statements with SQL
            String sql = "select * from todos where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //step-4 : execute statements & process results
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setCompleted(rs.getBoolean("completed"));
                todo.setType(TodoType.valueOf(rs.getString("type")));
                return Optional.of(todo);
            }

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
        return Optional.empty();
    }

    // U
    public void update(Todo todo) {

        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // step-3 : create jdbc statements with SQL
            String sql = "update todos set title=?,completed=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setBoolean(2, todo.isCompleted());
            preparedStatement.setInt(3, todo.getId());
            //step-4 : execute statements & process results
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1)
                System.out.println("New Todo Updated");
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

    // D
    public void deleteById(int id) {

        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // step-3 : create jdbc statements with SQL
            String sql = "delete from todos where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //step-4 : execute statements & process results
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1)
                System.out.println("Todo Deleted");
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

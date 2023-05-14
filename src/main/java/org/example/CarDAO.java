package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDAO {

    private DatabaseConnection databaseConnection;

    private static final String SELECT_ALL = "SELECT * from cars";


    public CarDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Car> getAllCars() {
        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            List<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String country = resultSet.getString(3);
                Car car = new Car(id, name, country);
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {

        }
        return new ArrayList<>();
    }

    public void insertCar(Car car) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "INSERT INTO cars VALUES (" + car.getId() + ", '" + car.getName() + "', '" + car.getCountry() + "')";
        statement.execute(query);
    }


    public void deleteCar(int id) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "DELETE FROM Cars WHERE id= (" + id + ")";
        statement.execute(query);
    }

    public void updateCar(int id, Car car) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "UPDATE cars SET id = " + car.getId() + " WHERE id=" + id;
        statement.execute(query);
        String query1 = "UPDATE cars SET name= " + "'" + car.getName() + "'" + " WHERE id=" + id;
        statement.execute(query1);
        String query2 = "UPDATE cars SET country=" + "'" + car.getCountry() + "'" + " WHERE id=" + id;
        statement.execute(query2);


    }


    public List<Car> getCar(int id) throws SQLException {
        {
            try (Connection connection = databaseConnection.getConnection();
                 Statement statement = connection.createStatement()) {
                String query = "SELECT * from cars WHERE id=" + id;
                ResultSet resultSet = statement.executeQuery(query);
                List<Car> cars = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    Car car = new Car(id, name, country);
                    cars.add(car);
                }
                return cars;
            } catch (SQLException e) {

            }
            return new ArrayList<>();
        }

    }
}
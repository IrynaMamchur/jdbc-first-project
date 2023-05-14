package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection
                = new DatabaseConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Irinal371");
        CarDAO carDAO = new CarDAO(databaseConnection);
       Car car = new Car(100, "qwerty", "ENGLAND");

        System.out.println(carDAO.getAllCars());
        carDAO.insertCar(car);
        System.out.println(carDAO.getAllCars());
        carDAO.deleteCar(100);
        System.out.println(carDAO.getAllCars());

      System.out.println(carDAO.getCar(1));

        Car car1 = new Car(4, "ghj", "German");
        carDAO.updateCar(4, car1);
        System.out.println(carDAO.getAllCars());
//
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Irinal371");
//        Statement statement = connection.createStatement();
////        //statement.execute("INSERT INTO cars VALUES (3, 'AUDI')");
//       ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
//
//        List<Car> carList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            String country = resultSet.getString(3);
//            Car car1 = new Car(id, name,country);
//            carList.add(car1);
//            System.out.println(id + " " + name + "  " + country);
//        }
//
//        System.out.println("Connected!");
//        System.out.println(carList);
//
//        // отобрать машины с ИД >2
//
////        while (resultSet.next()) {
////            int id = resultSet.getInt(1);
////            String name = resultSet.getString(2);
////            Car car = new Car(id, name);
////            if (id > 2) {
////                carList.add(car);
////                System.out.println(id + " " + name);
////            }
////
////        }
//
//       ResultSet resultSet1 = statement.executeQuery("SELECT * FROM cars WHERE ID>2");
//        System.out.println(resultSet1);
//        ResultSet resultSet2 = statement.executeQuery("SELECT country, count(*) FROM cars group by country");
//        while (resultSet2.next()) {
//            String country = resultSet2.getString(1);
//            int count = resultSet2.getInt(2);
//            System.out.println(country + " " + count);
//
//        }
//    }
    }
}
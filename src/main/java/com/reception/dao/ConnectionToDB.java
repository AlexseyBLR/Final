//package com.reception.dao;
//
//import java.sql.*;
//
//public class ConnectionToDB {
//    public static void main(String[] args) {
//
//    }
//
//    public Connection dd(){
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/receptioncompany", "root", "Maestro@96#");
//            if(!connection.isClosed()){
//                System.out.println("Connected!");
//            }
//
//
//
////            Statement statement = connection.createStatement();
////            ResultSet set = statement.executeQuery("SELECT * FROM user");
//
////            while (set.next()){
////                String s = set.getString("first_name");
////                System.out.println(s);
////            }
//
//
//        } catch (SQLException e) {
//            System.out.println("Error!");
//        }
//        return connection;
//    }
//}

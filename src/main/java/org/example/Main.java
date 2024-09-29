package org.example;

import helper.DbOperations;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        String name = "arda";
        String surname = "emreci";
        String mail = "deneme";
        String phone = "1234";
        String id ="4";

        DbOperations dbOperations = new DbOperations();
        dbOperations.insertInfo(name,surname,mail,phone);
        dbOperations.selectInfo();
        dbOperations.deleteInfo(id);

        System.out.println("Kadir was here");
    }
}
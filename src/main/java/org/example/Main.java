package org.example;

import helper.DbOperations;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static DbOperations dbOperations = new DbOperations();

    public static void main(String[] args) throws SQLException {
        start();

    }

    public static void start() throws SQLException {
        System.out.println("Bilgi Sistemine Hoşgeldiniz!");
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        System.out.println("1- kayıt göster - 2- kayıt ekle - 3- kayıt sil");


        int choose;
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        if (choose == 1) {
            System.out.println("Seçim 1");
            dbOperations.selectInfo();
        } else if (choose == 2) {
            scan = new Scanner(System.in);
            System.out.println("İsim giriniz :");

            String name = scan.nextLine();
            System.out.println("Soyad giriniz :");

            String surname = scan.nextLine();
            System.out.println("Mail giriniz :");

            String mail = scan.nextLine();
            System.out.println("Telefon numarası giriniz :");

            String phone = scan.nextLine();


            dbOperations.insertInfo(name, surname, mail, phone);
        } else if (choose == 3) {
            scan = new Scanner(System.in);
            System.out.println("Silmek istediğiniz ıd :");
            String id = scan.nextLine();
            dbOperations.deleteInfo(id);

        } else {
            System.out.println("Yanlış seçim yaptınız");
        }
        start();
    }


}
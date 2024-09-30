package helper;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.Scanner;

public class DbOperations {

    public void insertInfo(String name, String surname, String mail, String phone) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&&password=1234");
        String query = "INSERT INTO user (name, surname, mail, phone_number) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, mail);
        ps.setString(4, phone);

        ps.executeUpdate();
    }

    public void selectInfo() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&&password=1234");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM user");

        while (rs.next()) {
            System.out.println("*ID: " + rs.getInt("id") + " *NAME: " + rs.getString("name") + " *SURNAME: " + rs.getString("surname") + " *MAIL: " + rs.getString("mail") + " *NUMBER: " + rs.getString("phone_number"));
        }
    }

    public void deleteInfo(String id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&&password=1234");
        String query = "DELETE FROM user WHERE (id) = (?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        ps.executeUpdate();
    }

    public void loginInfo() {
        Scanner scan = new Scanner(System.in); // Scanner nesnesini burada oluşturuyoruz.

        // Kullanıcıdan bilgileri alıyoruz
        System.out.print("Adınızı giriniz: ");
        String name = scan.nextLine();

        System.out.print("Soyadınızı giriniz: ");
        String surname = scan.nextLine();

        System.out.print("Doğum tarihinizi giriniz (YYYY-MM-DD): ");
        String birthDate = scan.nextLine();

        System.out.print("Telefon numaranızı giriniz: ");
        String phone = scan.nextLine();

        // SQL sorgusu
        String query = "INSERT INTO user (name, surname, birth_date, phone_number) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&password=1234");
             PreparedStatement ps = connection.prepareStatement(query)) {

            // Kullanıcının girdiği değerleri sorguya ekliyoruz
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, birthDate);
            ps.setString(4, phone);

            // Sorguyu çalıştırıyoruz
            ps.executeUpdate();
            System.out.println("Kayıt başarıyla eklendi.");

        } catch (SQLException e) {
            System.out.println("Kayıt eklerken hata: " + e.getMessage());
        }
    }


}







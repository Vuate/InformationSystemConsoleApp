package helper;

import java.sql.*;

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
        System.out.println("Kullanıcı başarıyla eklendi !");
    }

    public static void selectInfo() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&&password=1234");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM user");

        System.out.println("Kullanıc Listesi:");
        while (rs.next()) {
            System.out.println("*ID: " + rs.getInt("id") + " *NAME: " + rs.getString("name") + " *SURNAME: " + rs.getString("surname") + " *MAIL: " + rs.getString("mail") + " *NUMBER: " + rs.getString("phone_number"));
        }
        connection.close();
    }

    public void deleteInfo(String id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/information_system?user=root&&password=1234");
        String query = "DELETE FROM user WHERE (id) = (?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Kullanıcı başarıyla silindi !");
        } else {
            System.out.println("Kullanıcı bulunamadı !!");
        }
        ps.close();
        connection.close();
    }
}
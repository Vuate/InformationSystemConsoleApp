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
    }
}

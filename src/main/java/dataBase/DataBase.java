package dataBase;

import java.sql.*;

public class DataBase {

    private String result;

    private String createQuery(String query, int id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_for_mail_ru?serverTimezone=UTC", "root", "Шыффс96Ыщдуы13");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                result = rs.getString(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public String getURL() throws SQLException {
        return createQuery("SELECT URL FROM webpages", 1);
    }

    public String getName() throws SQLException {
        return createQuery("SELECT name FROM User",1);
    }

    public String getPassword() throws SQLException {
        return createQuery("SELECT password FROM User", 1);
    }

    public String getEmail(int numberOfEmail) throws SQLException {
        return createQuery("SELECT email FROM Emails", numberOfEmail);
    }

    public String getText(int numberOfText) throws SQLException {
        return createQuery("SELECT text FROM message", numberOfText);
    }

    public String getWordsForTest() throws SQLException {
        return createQuery("SELECT word FROM test", 1);
    }
}

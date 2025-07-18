package usermanagement.dao;

import usermanagement.model.Address;
import usermanagement.model.Pharmacy;
import usermanagement.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PharmacyDao {
    public int registerPharmacy(Pharmacy pharmacy, Address address) {
        int status = 0;
        int insertedId = 0;

        UserDao userDao = new UserDao();

        // Register the user first
        // Create a User object from the Pharmacy object
        User user = new User();
        user.setUsername(pharmacy.getUsername());
        user.setPassword(pharmacy.getPassword());

        // Register the user
        userDao.registerUser(user);
        // Get the userId from the User object
        int userId = user.getUserId(); // Assuming the user ID is set after registration

        // Register address and get the address ID
        AddressDao addressDao = new AddressDao();
        addressDao.registerAddress(address);
        int addressId = address.getAddressId(); // Assuming the address ID is set after registration

        // Set the address ID in the Pharmacy object
        pharmacy.setUserId(userId);
        pharmacy.setAddressId(addressId);
        // Prepare the SQL statement for inserting the pharmacy

        String INSERT_PHARMACY_SQL = "INSERT INTO pharmacy (user_id, address_id, tax_num, name, phone_number, " +
                "fax_number, web_url, operating_hours) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "SicSemperTyrannis@@00");
            PreparedStatement ps = con.prepareStatement(INSERT_PHARMACY_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pharmacy.getUserId());
            ps.setInt(2, pharmacy.getAddressId());
            ps.setString(3, pharmacy.getTaxNum());
            ps.setString(4, pharmacy.getPharmacyName());
            ps.setString(5, pharmacy.getPhoneNumber());
            ps.setString(6, pharmacy.getFaxNumber());
            ps.setString(7, pharmacy.getWebURL());
            ps.setString(8, pharmacy.getOperatingHours());

            status = ps.executeUpdate();

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

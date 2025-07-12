package usermanagement.web;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;


import usermanagement.model.Address;
import usermanagement.model.Pharmacy;
import usermanagement.dao.PharmacyDao;

@WebServlet("/registerPharmacy")
public class PharmacyServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PharmacyDao pharmacyDao;

    public void init() {
        pharmacyDao = new PharmacyDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Servlet is working!");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pharmacyName = request.getParameter("pharmacyName");
        String taxNum = request.getParameter("taxNum");
        String streetAddress = request.getParameter("StreetAddress");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        int zipcode = Integer.parseInt(request.getParameter("Zipcode"));
        String phoneNumber = request.getParameter("phoneNumber");
        String faxNumber = request.getParameter("faxNumber");
        String webURL = request.getParameter("webURL");
        String operatingHours = request.getParameter("operatingHours");

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setUsername(username);
        pharmacy.setPassword(password);
        pharmacy.setPharmacyName(pharmacyName);
        pharmacy.setTaxNum(taxNum);
        pharmacy.setPhoneNumber(phoneNumber);
        pharmacy.setFaxNumber(faxNumber);
        pharmacy.setWebURL(webURL);
        pharmacy.setOperatingHours(operatingHours);

        Address address = new Address();
        address.setStreetName(streetAddress);
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zipcode);

        int status = pharmacyDao.registerPharmacy(pharmacy, address);

        if (status > 0) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

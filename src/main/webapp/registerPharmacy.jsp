<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Register Pharmacy</title>
</head>
<body>
<h2>Register Pharmacy</h2>
<form action="registerPharmacy" method="post">
  <fieldset>
    <legend>User Credentials</legend>
    <label for="username">Username:</label>
    <input type="text" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" name="password" required><br><br>
  </fieldset>

  <fieldset>
    <legend>Pharmacy Details</legend>
    <label for="pharmacyName">Pharmacy Name:</label>
    <input type="text" name="pharmacyName" required><br><br>

    <label for="taxNum">Tax Number:</label>
    <input type="text" name="taxNum" required><br><br>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" name="phoneNumber"><br><br>

    <label for="faxNumber">Fax Number:</label>
    <input type="text" name="faxNumber"><br><br>

    <label for="webURL">Website URL:</label>
    <input type="url" name="webURL"><br><br>

    <label for="operatingHours">Operating Hours:</label>
    <input type="text" name="operatingHours"><br><br>
  </fieldset>

  <fieldset>
    <legend>Address Information</legend>
    <label for="StreetAddress">Street Address:</label>
    <input type="text" name="StreetAddress" required><br><br>

    <label for="City">City:</label>
    <input type="text" name="City" required><br><br>

    <label for="State">State:</label>
    <input type="text" name="State" required><br><br>

    <label for="Zipcode">Zip Code:</label>
    <input type="number" name="Zipcode" required><br><br>
  </fieldset>

  <input type="submit" value="Register">
</form>
</body>
</html>

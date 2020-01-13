<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <h2>View Car</h2>

    <form id="viewCarForm" method="POST" action="fetchCarDetails">
        <select name="carId">
            <c:forEach  var="car" items="${cars}">
                <option value=${car.id}>"${car.carName} $${car.price}"</option>
            </c:forEach>
        </select>
        <input value="Submit Form" type="submit">
    </form>


    <c:if test="${carDAO != null}">

        <h3>"Car Details For ${carDAO.car.carName}"</h3>
        <p>"Total Price $${carDAO.car.price}"

        <h4>Chassis Details<h4>
        <p>"${carDAO.chassis.chassisName}"</p>
        <p>"$${carDAO.chassis.price}"</p>

        <h4>Engine Details<h4>
        <p>"${carDAO.engine.engineName}"</p>
        <p>"$${carDAO.engine.price}"</p>

        <h4>Tire Details<h4>
        <p>"${carDAO.tire.tireName}"</p>
        <p>"$${carDAO.tire.price}"</p>

    </c:if>


    </br>
    </br>

    <a href="/">Return Home</a>
</body>
</html>
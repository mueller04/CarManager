<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${carname}!</title>
    <link href="/style.css" rel="stylesheet">
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
    <h2 class="title">Build your car</h2>

    <p>The build fee is 90000 in addition to the cost of parts<p>

    <form id="carForm" method="POST" action="createCar">

        <p>Name your car</p>
        <input type="text" name="carName" />

        <p>chassis - price</p>
        <select name="chassisId">
            <c:forEach  var="singleChassis" items="${chassis}">
                <option value=${singleChassis.id}>"${singleChassis.chassisName} $${singleChassis.price}"</option>
            </c:forEach>
        </select>

        <p>engine - price</p>
        <select name="engineId">
            <c:forEach  var="engine" items="${engines}">
                <option value="${engine.id}">"${engine.engineName} $${engine.price}"</option>
            </c:forEach>
        </select>

        <p>tire - price</p>
        <select name="tireId">
            <c:forEach  var="tire" items="${tires}">
                <option value="${tire.id}">"${tire.tireName} $${tire.price}"</option>
            </c:forEach>
        </select>

        <input value="Submit Form" type="submit">
    </form>

    </br>

    <a href="/createChassis">Create Chassis</a>
    <a href="/createTire">Create Tire</a>
    <a href="/createEngine">Create Engine</a>
    <a href="/createCar">Create Car</a>

</body>
</html>
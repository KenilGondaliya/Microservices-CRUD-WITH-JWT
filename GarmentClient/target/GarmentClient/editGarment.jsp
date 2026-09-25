<%@page import="model.Garment"%>

<%

    Garment garment =
            (Garment) request.getAttribute("garment");

%>

<!DOCTYPE html>

<html>

<head>

    <title>Edit Garment</title>

</head>

<body>

<h2>Edit Garment</h2>

<form action="garments" method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="garmentid"
           value="<%=garment.getGarmentid()%>">


    Garment Name:

    <input type="text"
           name="garmentname"
           value="<%=garment.getGarmentname()%>"
           required>

    <br><br>


    Size:

    <input type="text"
           name="size"
           value="<%=garment.getSize()%>">

    <br><br>


    Category:

    <select name="category">

        <option value="Mens Wear"
            <%= "Mens Wear".equals(garment.getCategory())
                    ? "selected" : "" %>>

            Mens Wear

        </option>

        <option value="Women Wear"
            <%= "Women Wear".equals(garment.getCategory())
                    ? "selected" : "" %>>

            Women Wear

        </option>

        <option value="Children Wear"
            <%= "Children Wear".equals(garment.getCategory())
                    ? "selected" : "" %>>

            Children Wear

        </option>

    </select>

    <br><br>


    Description:

    <textarea name="description"><%=garment.getDescription()%></textarea>

    <br><br>


    Price:

    <input type="number"
           name="price"
           step="0.01"
           value="<%=garment.getPrice()%>"
           required>

    <br><br>


    Stock:

    <input type="number"
           name="stock"
           value="<%=garment.getStock()%>"
           required>

    <br><br>


    <button type="submit">
        Update Garment
    </button>

</form>

<br>

<a href="garments">
    Back to Garments
</a>

</body>

</html>
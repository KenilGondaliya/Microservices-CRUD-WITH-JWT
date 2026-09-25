<!DOCTYPE html>
<html>
<head>
    <title>Add Garment</title>
</head>

<body>

<h2>Add Garment</h2>

<form action="garments" method="post">

    <input type="hidden" name="action" value="add">

    Garment ID:
    <input type="number" name="garmentid" required>
    <br><br>

    Garment Name:
    <input type="text" name="garmentname" required>
    <br><br>

    Size:
    <input type="text" name="size">
    <br><br>

    Category:
    <select name="category">

        <option value="Mens Wear">
            Mens Wear
        </option>

        <option value="Women Wear">
            Women Wear
        </option>

        <option value="Children Wear">
            Children Wear
        </option>

    </select>

    <br><br>

    Description:
    <textarea name="description"></textarea>

    <br><br>

    Price:
    <input type="number"
           name="price"
           step="0.01"
           required>

    <br><br>

    Stock:
    <input type="number"
           name="stock"
           required>

    <br><br>

    <button type="submit">
        Add Garment
    </button>

</form>

<br>

<a href="garments">
    View All Garments
</a>

</body>
</html>
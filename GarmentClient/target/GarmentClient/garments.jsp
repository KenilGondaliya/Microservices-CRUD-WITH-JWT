<%@page import="java.util.List"%>
<%@page import="model.Garment"%>

<!DOCTYPE html>

<html>

<head>

    <title>Garment List</title>

</head>

<body>

<h2>Garment List</h2>

<a href="addGarment.jsp">
    Add New Garment
</a>

<br><br>

<table border="1" cellpadding="10">

    <tr>

        <th>ID</th>
        <th>Name</th>
        <th>Size</th>
        <th>Category</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Action</th>

    </tr>

<%

    List<Garment> garments =
            (List<Garment>) request.getAttribute("garments");

    if (garments != null) {

        for (Garment g : garments) {

%>

    <tr>

        <td>
            <%= g.getGarmentid() %>
        </td>

        <td>
            <%= g.getGarmentname() %>
        </td>

        <td>
            <%= g.getSize() %>
        </td>

        <td>
            <%= g.getCategory() %>
        </td>

        <td>
            <%= g.getDescription() %>
        </td>

        <td>
            <%= g.getPrice() %>
        </td>

        <td>
            <%= g.getStock() %>
        </td>

        <td>

            <!-- EDIT -->

            <a href="garments?action=edit&id=<%=g.getGarmentid()%>">
                Edit
            </a>

            |

            <!-- DELETE -->

            <form action="garments"
                  method="post"
                  style="display:inline">

                <input type="hidden"
                       name="action"
                       value="delete">

                <input type="hidden"
                       name="id"
                       value="<%=g.getGarmentid()%>">

                <button type="submit">
                    Delete
                </button>

            </form>

        </td>

    </tr>

<%

        }

    }

%>

</table>

</body>

</html>
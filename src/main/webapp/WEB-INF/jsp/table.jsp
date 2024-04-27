<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>TurboDataTable test</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container">
        <h3>Hello JPS!</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Product Line</th>
                    <th>Product Scale</th>
                    <th>Product Vendor</th>
                    </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.productCode}</td>
                        <td>${product.productName}</td>
                        <td>${product.productLine}</td>
                        <td>${product.productScale}</td>
                        <td>${product.productVendor}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

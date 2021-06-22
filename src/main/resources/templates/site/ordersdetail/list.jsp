<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{site/sitelayout.html}">

<head>

</head>

<body>
    <div class="container" layout:fragment="content">
        <div class="row my-5">
            <div class="col">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name Product</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Unit Price</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 1 -->
                        <tr th:each="orderdetail : ${orderdetails}">
                            <td>
                                [[${orderdetail.orderDetailId}]]
                            </td>
                            <td>
                                [[${orderdetail.product.name}]]
                            </td>
                            <td>
                                [[${orderdetail.quantity}]]
                            </td>
                            <td>
                                [[${orderdetail.unitPrice}]]
                            </td>
                            <td>
                                <a href="" class="btn btn-danger">Show</a>
                            </td>
                        </tr>
                        <!-- 2 -->

                    </tbody>
                </table>
            </div>
            <!--  -->

        </div>
    </div>

</body>

</html>
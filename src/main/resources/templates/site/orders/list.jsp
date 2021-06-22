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
                            <th scope="col">Đơn giá</th>
                            <th scope="col">Ngày đặt</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 1 -->
                        <tr th:each="order : ${orders}">
                            <td>
                                [[${order.orderId}]]
                            </td>
                            <td>
                                [[${order.amount}]]
                            </td>
                            <td>
                                [[${order.orderDate}]]
                            </td>
                            <td>
                                <p th:if="${order.status == 0}">Đang chờ xử lý</p>
                                <p th:if="${order.status == 1}">Đang chuyển hàng</p>
                            </td>
                            <td>
                                <a th:href="@{'/site/orderdetail/list/'+ ${order.orderId}}" class="btn btn-danger">Chi tiết</a>
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
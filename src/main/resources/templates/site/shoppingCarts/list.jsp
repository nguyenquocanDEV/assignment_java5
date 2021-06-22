<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{site/sitelayout.html}">


<body>
    <div class="container" layout:fragment="content">
        <div class="row my-5">
            <div class="col-8">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Sản phẩm</th>
                            <th scope="col">Giá</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Tạm tính</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 1 -->
                        <tr th:each="item : ${cartItem}">
                            <form th:action="@{/site/shoppingCart/update}" method="POST">
                                <td>
                                    <div class="row">
                                        <div class="col-3">
                                            <a href="">
                                                <img src="https://product.hstatic.net/1000283534/product/maudo_1_535bbbfad84744e8b5bc539594585c43.jpeg" alt="">
                                            </a>
                                        </div>
                                        <div class="col-9">
                                            <a href="">
                                                [[${item.name}]]
                                            </a>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <p>[[${item.unitPrice - item.discount/100 * item.unitPrice}]]</p>
                                </td>
                                <td>
                                    <input class="detail-number" type="hidden" name="productID" th:value="${item.productID}">
                                    <input class="detail-number" type="number" name="quantity" min="1" step="1" th:value="${item.quantity}" onblur="this.from.submit()">
                                </td>
                                <td>
                                    <p>[[${(item.unitPrice - item.discount/100 * item.unitPrice) * item.quantity}]]</p>
                                </td>
                                <td>
                                    <a th:href="@{'/site/shoppingCart/remove/'+ ${item.productID}}">
                                        <i class="fa fa-trash" aria-hidden="true"></i>
                                    </a>
                                </td>
                            </form>

                        </tr>
                        <!-- 2 -->

                    </tbody>
                </table>
            </div>
            <!--  -->
            <div class="col-4">
                <h5>Tổng thanh toán</h5>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Tổng tiền</td>
                            <td>[[${total}]]</td>
                        </tr>
                        <tr>
                            <td>Tổng số loại sản phẩm</td>
                            <td>[[${NoOfItems}]]</td>
                        </tr>
                    </tbody>
                </table>
                <div class="row ml-2">
                    <a th:href="@{'/site/orders/add/'+ ${total}}" class="btn btn-danger">Thanh toán ngay</a>
                </div>

            </div>
        </div>
    </div>

</body>

</html>
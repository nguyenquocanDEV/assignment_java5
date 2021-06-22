<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{site/sitelayout.html}">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
</head>

<body style="background-color: white;">

    <!--Logo-->
    <!--Thanh Menu-->
    <!--slide-->
    <!--content-->
    <div class="container" layout:fragment="content">
        <!--Sản phẩm mới nhất-->
        <div class="title">
            <h3>Sản phẩm </h3>
        </div>
        <div class="row my-5 box-product pt-5">
            <!--1-->
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 my-4" th:each="product, iStat : ${productPage}">
                <div class="thumbnail product pb-2">
                    <div class="anh">
                        <img src="https://product.hstatic.net/1000283534/product/maudo_1_535bbbfad84744e8b5bc539594585c43.jpeg" alt="" />
                    </div>
                    <div class="caption">
                        <a th:href="@{'/site/product/detail/'+ ${product.productID}}" class="btn btn-default text-center">
                            [[${product.name}]]
                        </a>
                    </div>
                    <div class="text-center">
                        <h5>
                            [[${product.unitPrice - product.discount/100 * product.unitPrice}]]
                        </h5>
                        <h6 style="text-decoration: line-through;">
                            [[${product.unitPrice}]]
                        </h6>
                    </div>
                </div>
            </div>
            <!--  -->
        </div>
        <!--phantrang-->

        <!--Sản phẩm bán chạy nhất-->

    </div>

</body>

</html>
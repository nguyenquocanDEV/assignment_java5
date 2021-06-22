<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{site/sitelayout.html}">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../site/css/css.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="../fontawesome-free-5.15.3-web/css/all.css" />
    <title>Chi tiết sản phẩm</title>
</head>

<body style="background-color: white;">



    <!--content-->
    <div class="container mt-5 mb-5" layout:fragment="content">
        <div class="row">
            <div class="col-5">
                <img class="image-detail" src="https://product.hstatic.net/1000283534/product/maudo_1_535bbbfad84744e8b5bc539594585c43.jpeg" alt="" />
            </div>

            <div class="col-5">
                <div class="title-detail">
                    <h5>[[${product.name}]]</h5>
                    <hr>
                    <h5>[[${product.unitPrice - product.discount/100 * product.unitPrice}]]<u>$</u></h5>
                    <ul>
                        <li>
                            [[${product.description}]]
                        </li>
                    </ul>
                    <i style="color: red;">* Thu cũ đổi mới -  Trợ giá tốt nhất</i> <br>
                    <i style="color: red;">* Giảm thêm tới 1% cho thành viên Smember</i>
                    <p class="my-3"><b>ĐẶT MUA NGAY</b> <br> Tình trạng: <br> Máy mới 100% , chính hãng Apple Việt Nam. <br> Đức Apple hiện là đại lý bán lẻ uỷ quyền iPhone chính hãng VN/A của Apple Việt Nam <br> Hộp bao gồm: <br> Thân máy, cáp USB-C to Lightning, sách
                        HDSD Bảo hành: <br> Bảo hành 12 tháng tại trung tâm bảo hành chính hãng Apple Việt Nam. 1 ĐỔI 1 trong 30 ngày nếu có lỗi phần cứng nhà sản xuất.(Chi tiết)</p>
                    <div class="row mx-3">
                        <!-- <label for="">SL: </label> -->
                        <!-- <input class="detail-number mr-auto ml-3" type="number" min="1" value="1" step="1" name="soluong">  -->
                        <a th:href="@{'/site/shoppingCart/add/'+${product.productID}}" type="button" class="btn btn-success">Thêm vào giỏ hàng</a>
                    </div>
                    <br>
                    <div class="row ml-2">
                        <a href="" class="btn btn-danger">Mua Ngay</a>
                    </div>

                </div>
            </div>
            <div class="col-2 text-center icon-box py-2">
                <img src="http://macshop.giaodienwebmau.com/wp-content/uploads/2020/12/free_deliverd.png" alt="">
                <p>Giảm thêm 500.000đ khi mua kèm Apple Watch Series 6 [HOT] Thu cũ lên đời giá cao - Thủ tục nhanh - Trợ giá lên tới 1.000.000đ</p>
                <hr>
                <img src="http://macshop.giaodienwebmau.com/wp-content/uploads/2020/12/giaohangngaysaukhidat.png" alt="">
                <p>Thanh toán online | Miễn phí giao hàng thu tiền</p>
                <hr>
                <img src="http://macshop.giaodienwebmau.com/wp-content/uploads/2020/12/doitra.png" alt="">
                <p>Bảo hành 12 tháng</p>
                <hr>
                <img src="http://macshop.giaodienwebmau.com/wp-content/uploads/2020/12/hoadon.png" alt="">
                <p>Trả góp 0% với thẻ tín dụng tại cửa hàng - Xem chi tiết Gọi miễn phí: 1800.2097 | Chat với tư vấn viên</p>
            </div>
        </div>
    </div>

    <!--Footer-->
</body>

</html>
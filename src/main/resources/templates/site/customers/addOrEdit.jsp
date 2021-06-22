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
    <title>Add new product</title>
</head>

<body style="background-color: white;">

    <!--Logo-->
    <!--Thanh Menu-->
    <!--slide-->
    <!--content-->
    <div class="container" layout:fragment="content">
        <h2 class="my-5">Add New Customer</h2>
        <section class="row">
            <div class="col my-4">
                <form action="/site/customers/saveOrUpdate" method="POST" class="mb-5" th:object="${customer}">
                    <div class="row">
                        <div class="col-5">
                            <div class="form-group">
                                <label for="customerId">CustomerId</label>
                                <input type="text" class="form-control" th:field="*{customerId}" id="customerId" placeholder="customerId" readonly>
                            </div>
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" th:field="*{name}" id="name" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <label for="email">email</label>
                                <input type="email" class="form-control" th:field="*{email}" id="email" placeholder="email">
                            </div>
                            <div class="form-group">
                                <label for="password">password</label>
                                <input type="password" class="form-control" id="password" th:field="*{password}" placeholder="password" value="123">
                                <!-- <p>[[${customer.password}]]</p>
                                <p>[[${password}]]</p> -->
                            </div>
                            <div class="form-group">
                                <label for="phone">phone</label>
                                <input type="text" class="form-control" th:field="*{phone}" id="phone" placeholder="phone">
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <button class="btn btn-success ml-3">New</button>
                        <button class="btn btn-primary ml-4">
                            <span th:if="${customer.isEdit}">Update</span>
                            <span th:if="${!customer.isEdit}">Save</span>
                        </button>
                        <!-- <button class="btn btn-danger ml-4">Delete</button> -->
                    </div>
                </form>
            </div>

        </section>
    </div>

    <!--Footer-->
    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function() {
            $(window).scroll(function() {
                if ($(this).scrollTop() > 300) {
                    $('header').addClass('sticky');
                } else {
                    $('header').removeClass('sticky');
                }
            });
        });
    </script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    -->

</body>

</html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{admin/layout.html}">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous" />

    <link rel="stylesheet" href="css/admin.css" />
</head>

<body>
    <main class="container">
        <div class="container" layout:fragment="content">

        <section class="row">
            <div class="col mt-4">
                <div class="card">
                    <div class="card-header">
                        <h2>List Product</h2>
                    </div>
                    <div class="card-body">
                        <div th:if="${message != null}" class="alert alert-primary" role="alert">
                            <i> [[${message}]] </i>
                        </div>
                        <div class="row mt-2 mb-2">
                            <div class="col">
                                <form th:action="@{/admin/products/search}">
                                    <div class="form-inline float-left">
                                        <label for="name"></label>
                                        <input type="text" class="form-control" name="name" id="name" aria-describedby="helpId" placeholder="Input name" />
                                        <button class="btn btn-outline-primary">Search</button>
                                    </div>
                                </form>
                                <div class="float-right">
                                    <a class="btn btn-outline-primary" th:href="@{/admin/products/add}">Add new</a>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-inverse">
                            <thead class="thead-inverse">
                                <tr>
                                    <th><input type="checkbox" class="form-check-input" /></th>
                                    <th></th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Unit Price</th>
                                    <th>Discount</th>
                                    <th>Status</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr th:each="item, iStat : ${products}">
                                    <td><input type="checkbox" class="form-check-inline" /></td>
                                    <td><img src="../../../static/images/asus.jpg" width="70" class="img-fluid" alt="" /></td>
                                    <td th:text="${item.name} "></td>
                                    <td th:text="${item.quantity} "></td>
                                    <td th:text="${item.unitPrice} "></td>
                                    <td th:text="${item.discount} "></td>
                                    <td th:text="${item.status} "></td>
                                    <td th:src="${item.image!= null ? '/admin/products/images/'+ item.image : '/images/noimage.jpg'}" alt=""></td>
                                    <td th:text="${item.category.name} "></td>

                                    <td>
                                        <a th:href="@{ '/admin/products/edit/' + ${item.productID}} " class="btn btn-outline-warning "><i class="fas fa-edit "></i></a>
                                        <a th:href="@{ '/admin/products/delete/' + ${item.productID}} " class="btn btn-outline-danger "><i class="fas fa-trash "></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        </div>

    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js " integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo " crossorigin="anonymous "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1 " crossorigin="anonymous "></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js " integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM " crossorigin="anonymous "></script>
</body>

</html>
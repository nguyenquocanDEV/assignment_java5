<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

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
    <header class="row text-center">
        <div class="col">
            <nav class="navbar navbar-expand-sm navbar-light bg-light">
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Category</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Order</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manage Profile</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>
        <section class="row">

            <div class="col-8 offset-2  mt-4">

                <form action="/admin/customers/saveOrUpdate" method="post"  th:object="${customer}">
                    <div class="card">
                        <div class="card-header">
                            <h2 th:text="${customer.isEdit ? 'Edit customer' : 'Add new customer'}"></h2>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-5">
                                    <input type="hidden" th:field="*{isEdit}">
                                    <div class="form-group">
                                        <label for="customerId">Customer ID</label>
                                        <input re type="text" class="form-control" th:field="*{customerId}" id="customerId" placeholder="customerId" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" th:field="*{name}" id="name" placeholder="Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" th:field="*{email}" id="email" placeholder="email">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" th:field="*{password}" id="password" placeholder="password">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">Phone</label>
                                        <input type="text" class="form-control" th:field="*{phone}" id="phone" placeholder="phone">
                                    </div>

                                </div>

                            </div>

                        </div>
                        <div class="card-footer text-muted ">
                            <a th:href="@{/admin/customers/}" class="btn btn-success">List</a>
                            <button class="btn btn-primary"><i class="fas fa-save "></i>
                                <span th:if="${customer.isEdit}">Edit</span>
                                <span th:if="${!customer.isEdit}">Save</span>
                            </button>
                            <a th:if="${customer.isEdit}" th:href="@{'/admin/customers/delete/' + ${customer.customerId}} " class="btn btn-danger float-right">Delete</a>
                        </div>
                </form>
                </div>

                </form>
            </div>
        </section>
        <footer class="row"></footer>
    </main>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
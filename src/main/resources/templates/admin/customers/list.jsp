<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous"/>

    <link rel="stylesheet" href="css/admin.css"/>
</head>

<body>
<main class="container">
    <header class="row text-center">
        <div class="col">
            <nav class="navbar navbar-expand-sm navbar-light bg-light">
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                        data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                        aria-label="Toggle navigation">
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
        <div class="col mt-4">
            <div class="card">
                <div class="card-header">
                    <h2>List Customer</h2>
                </div>
                <div class="card-body">
                    <div th:if="${message != null}" class="alert alert-primary" role="alert">
                        <i> [[${message}]] </i>
                    </div>
                    <div class="row mt-2 mb-2">
                        <div class="col">
                            <div class="float-right">
                                <a class="btn btn-outline-primary" th:href="@{/admin/customers/add}">Add new</a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-inverse">
                        <thead class="thead-inverse">
                        <tr>

                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr th:each="item, iStat : ${customers}">
                            <td th:text="${item.customerId} "></td>
                            <td th:text="${item.name} "></td>
                            <td th:text="${item.email} "></td>
                            <td th:text="${item.phone} "></td>

                            <td>
                                <a th:href="@{ '/admin/customers/edit/' + ${item.customerId}} "
                                   class="btn btn-outline-warning "><i class="fas fa-edit "></i></a>
                                <a th:href="@{ '/admin/customers/delete/' + ${item.customerId}} "
                                   class="btn btn-outline-danger "><i class="fas fa-trash "></i></a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

</body>

</html>
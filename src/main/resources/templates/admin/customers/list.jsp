<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{admin/layout.html}">

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
    <div class="container" layout:fragment="content">
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
                            <th>Password</th>
                            <th>Phone</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr th:each="item, iStat : ${customers}">
                            <td th:text="${item.customerId} "></td>
                            <td th:text="${item.name} "></td>
                            <td th:text="${item.email} "></td>
                            <td th:text="${item.password} "></td>
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
    </div>
</main>
</body>

</html>
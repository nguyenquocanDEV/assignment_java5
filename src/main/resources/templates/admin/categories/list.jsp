<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{admin/layout.html}">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">

    <link rel="stylesheet" href="css/admin.css">
</head>

<body>
<main class="container">
    <div class="container" layout:fragment="content">

        <section class="row">

            <div class="col-8 offset-2  mt-4">

                <div class="card">
                    <div class="card-header">
                        <h2>List Category</h2>
                    </div>
                    <div class="card-body">
                        <div th:if="${message != null}" class="alert alert-primary" role="alert">
                            <i> [[${message}]] </i>
                        </div>
                        <div class="row  mt-2 mb-2">
                            <div class="col">
                                <form th:action="@{/admin/categories/search}">
                                    <div class="form-inline float-left">
                                        <label for="name"></label>
                                        <input type="text" class="form-control" name="name" id="name"
                                               aria-describedby="helpId" placeholder="Input name">
                                        <button class="btn btn-outline-primary">Search</button>
                                    </div>
                                </form>
                                <div class="float-right">
                                    <a class="btn btn-outline-primary" th:href="@{/admin/categories/add}">Add new</a>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-inverse ">
                            <thead class="thead-inverse">
                            <tr>
                                <th>CategoryID</th>
                                <th>Name</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr th:each=" category : ${categories}">
                                <td scope="row" th:text=${category.categoryID}></td>
                                <td th:text="${category.name}"></td>
                                <td>

                                    <a th:href="@{'/admin/categories/edit/'+ ${category.categoryID}}"
                                       class="btn btn-outline-warning"><i class="fas fa-edit "></i></a>
                                    <a th:href="@{'/admin/categories/delete/'+ ${category.categoryID}}"
                                       class="btn btn-outline-danger"><i class="fas fa-trash "></i></a>

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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
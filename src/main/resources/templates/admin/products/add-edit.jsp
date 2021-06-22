<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{admin/layout.html}">

<head>
    <title>Add</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">

    <link rel="stylesheet" href="css/admin.css">
</head>

<body>
    <main class="container">
        <div class="container" layout:fragment="content">

        <section class="row">

            <div class="col-8 offset-2  mt-4">

                <form action="/admin/products/saveOrUpdate" method="post" enctype="multipart/form-data" th:object="${product}">
                    <div class="card">
                        <div class="card-header">
                            <h2 th:text="${product.isEdit ? 'Edit Product' : 'Add new product'}"></h2>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-7">
                                    <input type="hidden" th:field="*{isEdit}">
                                    <div class="form-group">
                                        <label for="productID">Product ID</label>
                                        <input type="text" class="form-control" th:field="*{productID}" aria-describedby="productHid" placeholder="Product ID" readonly>
                                        <small id="productHid" class="form-text text-muted">Product ID is
                                            required</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" th:field="*{name}" aria-describedby="nameHid" placeholder="Name">
                                        <small id="nameHid" class="form-text text-muted">Name is required</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="quantity">Quantity</label>
                                        <input type="text" class="form-control" th:field="*{quantity}" aria-describedby="quantityHid" placeholder="Quantity">
                                        <small id="quantityHid" class="form-text text-muted">Quantity is
                                            required</small>
                                    </div>
                                    <div class="input-group form-group">
                                        <span class="input-group-text">Unit Price</span>
                                        <input type="number" th:field="*{unitPrice}" class="form-control" placeholder="Unit Price">
                                        <span class="input-group-text">$</span>
                                    </div>

                                    <div class="form-group">
                                        <label for="categoryID">Category</label>
                                        <select class="form-control" th:field="*{categoryID}">
                                            <option th:each=" item : ${categories}" th:value="${item.categoryID}"
                                                th:text="${item.name}">Category Name</option>

                                        </select>
                                    </div>

                                </div>
                                <div class="col-5">
                                    <script>
                                        function chooseFile(fileInput) {
                                            if (fileInput.files && fileInput.files[0]) {
                                                var reader = new FileReader();

                                                reader.onload = function(e) {
                                                    $('#image').attr('src', e.target.result);
                                                }
                                                reader.readAsDataURL(fileInput.files[0]);
                                            }
                                        }
                                    </script>
                                    <img id="image" th:src="${product.image!= null ? '/admin/products/images/'+ product.image : '/images/noimage.jpg'}" src="/images/noimage.jpg" class="img-fluid" alt="">
                                    <div class="form-group">
                                        <label for="productImage">Image file</label>
                                        <input type="file" onchange="chooseFile(this)" class="form-control-file" name="imageFile" id="productImage" placeholder="Product Image" aria-describedby="ProductimageHid">
                                        <small id="ProductimageHid" class="form-text text-muted">Product images is
                                            required</small>
                                    </div>
                                    <div class="input-group form-group">
                                        <span class="input-group-text">Discount</span>
                                        <input type="number" th:field="*{discount}" class="form-control" placeholder="Discount">
                                        <span class="input-group-text">%</span>
                                    </div>
                                    <div class="form-group">
                                        <label for="status">Status</label>
                                        <select class="form-control" th:field="*{status}">
                                            <option value="0">Out of stock</option>
                                            <option value="1">For sale</option>
                                            <option value="2">Featured</option>
                                            <option value="3">Best seller</option>
                                            <option value="4">Out of order</option>
                                        </select>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <textarea class="form-control" rows="5" th:field="*{description}"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer text-muted ">
                            <a th:href="@{/admin/products/add}" class="btn btn-success">New</a>
                            <button class="btn btn-primary"><i class="fas fa-save "></i>
                                <span th:if="${product.isEdit}">Update</span>
                                <span th:if="${!product.isEdit}">Save</span>
                            </button>
                            <a th:if="${product.isEdit}" th:href="@{'/admin/products/delete/' + ${product.productID}} " class="btn btn-danger float-right">Delete</a>
                        </div>
                    </div>
                </form>
                </div>

        </section>
        </div>
    </main>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
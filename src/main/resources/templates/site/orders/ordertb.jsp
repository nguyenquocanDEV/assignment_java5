<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{site/sitelayout.html}">

<head>

</head>

<body>
    <div class="container" layout:fragment="content">
        <div th:if="@{${message} != null}" class="alert alert-primary" role="alert">
            <strong>[[${message}]]</strong>
        </div>
    </div>
</body>

</html>
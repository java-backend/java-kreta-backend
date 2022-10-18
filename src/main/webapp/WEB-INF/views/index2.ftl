<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="hu">
<head>
<#include "/template/head.ftl"/>
<title>Kréta - iskolai adminisztráció</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
</div>
<div class="container">
    <div class="hero-unit">
        <h1>Spring fejlesztés - gyakorló kódok</h1>
        <p>Spring, bootstrap, thymelaef, freemaker, vue.</p>
    </div>
    <div>
        <ul>
            <li><a th:href="/swagger-ui/index.html">Kréta API</a></li>
            <li><a th:href="/th">Tymleaf oldalak</a></li>
            <li><a th:href="/ftl/index">Freemarker oldalak</a></li>
        </ul>
    </div>
</div>
</body>
<#include "/template/footer.ftl">
</head>
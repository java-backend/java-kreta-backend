<nav class="navbar navbar-expand-lg navbar-dark bg-dark" th:fragment="menu" xmlns:th="http://www.w3.org/1999/xhtml">
    <div class="container-fluid">
        <a class="navbar-brand" th:href="@{/index}">Kréta</a>
        <a class="navbar-brand" th:href="@{/th/index}">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Adatkezelés</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/ftl/subjects/index">Tantárgyak</a>
                        <a class="dropdown-item" ref="#">Osztályok</a>
                        <a class="dropdown-item" ref="#">Diákok</a>
                        <div class="dropdown-divider"></div>
                    </div>
                </li>
                <li class="nav-item dropdown ms-auto">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Admin</a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a href="#" class="dropdown-item"></a>
                        <a href="#" class="dropdown-item"></a>
                        <div class="dropdown-divider"></div>
                    </div>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Keresés" aria-label="Keresés">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<#include "../template/page.ftl" />
<@pageWithContainer title="Tantárgy adatai">
    <table class="table">
    <tr>
        <th>Azonosító</th>
        <th>${schoolClass.id}</th>          
    </tr>
    <tr>
        <th>Évfolyam</th>
        <th>${schoolClass.schoolClass}</th>             
    </tr>

    <tr>
        <th>Osztály</th>
        <th>${schoolClass.classType}</th>             
    </tr>
    <tr>
        <th>Osztály</th>
        <th>${schoolClass.teacherId}</th>             
    </tr>
    <tr>
        <th><a class="btn btn-primary btn-xs" href="/ftl/schoolClass/edit/${schoolClass.id}">Szerkesztés</a></th>
        <th><a class="btn btn-primary btn-xs" href="/ftl/schoolClass/delete/${schoolClass.id}">Törlés</a></th>
    </tr>
</table>

</@pageWithContainer>
<#include "../template/page.ftl" />
<@pageWithContainer title="Tantárgy adatai">
<table class="table">
    <tr>
        <th>Azonosító</th>
        <th>${subject.id}</th>          
    </tr>
    <tr>
        <th>Név</th>
        <th>${subject.subjectName}</th>             
    </tr>
    <tr>
        <th><a class="btn btn-primary btn-xs" href="/ftl/subject/edit/${subject.id}">Szerkesztés</a></th>
        <th><a class="btn btn-primary btn-xs" href="/ftl/subject/delete/${subject.id}">Törlés</a></th>
    </tr>
</table>


</@pageWithContainer>
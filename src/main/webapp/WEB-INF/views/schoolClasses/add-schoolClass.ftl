<#include "../template/page.ftl" />
<#include "../template/macro/input.ftl" />

<#if add>
<#assign newTitle>Új osztály felvétele</#assign>
<#assign newButtan>Osztály hozzáadása</#assign>
<#else>
<#assign newTitle>Osztály módosítása</#assign>
<#assign newButtan>Osztály frissítése</#assign>
</#if>
<@pageWithContainer title=newTitle >

<form  action="/ftl/schoolClass/add-schoolClass"
         name=schoolClass
         method="post">
     <table class="table table-bordered">
        <@numberInput object="id" placeholder="Azonosító" />
        <@numberInput object="schoolClass" placeholder="Évfolyam" />
        <@textInput object="classType" placeholder="Osztály" />
        <@numberInput object="teacherId" placeholder="Tanárazon." />
     </table>
     <input class="btn btn-primary" type="submit" value="${newButtan}">

</form>

</@pageWithContainer>
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

<form  action="<#if add>/ftl/schoolClass/add-schoolClass</#if><#if !add>/ftl/schoolClass/update/${schoolClass.id} </#if>"
         name=schoolClass
         method="post">
     <table class="table table-bordered">
         <#if !add>
            <tr>
                <th>Id</th>
                <td><div name="id"> ${schoolClass.id} </td>
            </tr>
         <#else>
        <@numberInputID attributes="id" placeholder="Azonosító" />
        </#if>
         <tr>
            <td><label for="schoolClass">Évfolyam</label></td>
            <td><input required class="form-control" type="number" name="schoolClass" id="schoolClass" value="<#if schoolClass.schoolClass??>${schoolClass.schoolClass}</#if>"  ></td>
         </tr>
         <tr>
            <td><label for="classType">Osztály</label></td>
            <td><input required class="form-control" type="text" name="classType" id="classType" value="<#if schoolClass.classType??>${schoolClass.classType}</#if>" ></td>
         </tr>
          <tr>
            <td><label for="teacherId">Tanárazon</label></td>
            <td><input required class="form-control" type="number" name="teacherId" id="teacherId" value="<#if schoolClass.teacherId??>${schoolClass.teacherId}</#if>"  ></td>
         </tr>
     </table>
     <input class="btn btn-primary" type="submit" value="${newButtan}">

</form>

</@pageWithContainer>
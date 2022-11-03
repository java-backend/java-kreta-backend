
<#include "../template/page.ftl" />

<#if add>
<#assign newTitle>Új tantárgy felvétele</#assign>
<#assign newButtan>Tantárgy hozzáadása</#assign>
<#else>
<#assign newTitle>Tantárgy módosítása</#assign>
<#assign newButtan>Tantárgy frissítése</#assign>
</#if>
<@pageWithContainer title=newTitle >
 <form  action="<#if add>/ftl/subject/add-subject</#if><#if !add>/ftl/subject/update/${subject.id} </#if>"
         name=subject
         method="post">
            <table class="table table-bordered">
            <#if !add>
            <tr>
                <th>Id</th>
                <td><div name="id"> ${subject.id} </td>
            </tr>
            <#else>
            <tr>
                <td><label for="id">Azon.</label></td>
                <td><input required class="form-control" type="number" name="id"  id="id" placeholder="Azonosító"></td>
            </tr>
            </#if>
            <tr>
                <td><label for="subjectName">Név</label></td>
                <td><input required class="form-control" type="text" name="subjectName" id="subjectName" placeholder="Tantárgy neve"  value="<#if subject.subjectName??>${subject.subjectName}</#if>"></td>
            </tr>
            </table>
            <input class="btn btn-primary" type="submit" value="${newButtan}">
        </form>
</@pageWithContainer>




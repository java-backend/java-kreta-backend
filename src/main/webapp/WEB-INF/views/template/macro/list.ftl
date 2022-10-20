<#macro numberOfItems number name>
<#if number==0>
  <p>Nincs ${name} az adatbázisban.</p>
<#else> 
<#nested>
</#if>
</#macro>
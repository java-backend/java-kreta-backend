<!-- https://stackoverflow.com/questions/36428710/how-can-i-correctly-import-an-header-and-a-footer-page-into-a-freemarker-page -->
<#macro pageHeadFooter title>
<!DOCTYPE html>
<html lang="hu">
<head>
    <title>${title}</title>
    <#include "head.ftl">
</head>
<body>
    <#nested/>
    <#include "footer.ftl">    
</body>
</html>
</#macro>

<#macro pageHeadMenuFooter title>
<#assign newTitle>${title}</#assign>
<@pageHeadFooter title=newTitle>
<#include "menu.ftl">
<#nested/>
</@pageHeadFooter>
</#macro>

<#macro page title>
<#assign newTitle>${title}</#assign>
<@pageHeadMenuFooter title=newTitle>
<h1>${title}</h1>
<#nested/>
</@pageHeadMenuFooter>
</#macro>

<#macro pageWithContainer title>
<#assign newTitle>${title}</#assign>
<@page title=newTitle>
<div class="container">
     <div class = "p-1 bg-info">
     <#nested>
     </div>
</div>


</@page>
</#macro>

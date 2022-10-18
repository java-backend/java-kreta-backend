<!-- https://stackoverflow.com/questions/36428710/how-can-i-correctly-import-an-header-and-a-footer-page-into-a-freemarker-page -->
<#macro standardPage title="">
<!DOCTYPE html>
<html lang="hu">
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/webjars/popper.js/2.9.3/umd/popper.min.js"></script>
</head>
<body>
    <#include "header.ftl">    

    <#nested/>

    <#include "footer.ftl">    
</body>
</html>
</#macro>
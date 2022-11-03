<#macro textInput object placeholder>
    <tr>
        <td><label for="${object}">${placeholder}</label></td>
        <td><input required class="form-control" type="text" name="${object}" id="${object}" placeholder="${placeholder}" ></td>
    </tr>
</#macro>

<#macro numberInput object placeholder>
    <tr>
        <td><label for="${object}">${placeholder}</label></td>
        <td><input required class="form-control" type="number" name="${object}" id="${object}" placeholder="${placeholder}" ></td>
    </tr>
</#macro>
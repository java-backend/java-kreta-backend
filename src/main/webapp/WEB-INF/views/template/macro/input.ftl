<#macro textInput attributes placeholder value>
    <tr>
        <td><label for="${attributes}">${placeholder}</label></td>
        <td><input required class="form-control" type="text" name="${attributes}" id="${attributes}" placeholder="${placeholder}" value="${value}"></td>
    </tr>
</#macro>

<#macro numberInput attributes placeholder value>
    <tr>
        <td><label for="${attributes}">${placeholder}</label></td>
        <td><input required class="form-control" type="number" name="${attributes}" id="${attributes}" placeholder="${placeholder}" value=${value} ></td>
    </tr>
</#macro>


<#macro numberInputID attributes placeholder>
    <tr>
        <td><label for="${attributes}">${placeholder}</label></td>
        <td><input required class="form-control" type="number" name="${attributes}" id="${attributes}" placeholder="${placeholder}"></td>
    </tr>
</#macro>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>Portal ${id}</title>
</head>
<body>
<div>
    <table class="table table-striped">
        <tr>
            <td class="span3">ID</td>
            <td class="span9"><s:property value="id"/></td>
        </tr>
        <tr>
            <td class="span3">CODE</td>
            <td class="span9"><s:property value="code"/></td>
        </tr>
        <tr>
            <td class="span3">NAME</td>
            <td class="span9"><s:property value="name"/></td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/rest/portals.do" class="btn btn-info">
        <i class="icon icon-arrow-left"></i>返回
    </a>
</div>
</body>
</html>

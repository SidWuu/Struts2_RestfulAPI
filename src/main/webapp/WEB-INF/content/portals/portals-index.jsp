<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>Portals</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>CODE</th>
            <th>NAME</th>
        </tr>
        <s:iterator value="list">
            <tr>
                <td>${id}</td>
                <td><s:property value="code"/></td>
                <td><s:property value="name"/></td>
                    <%--<td><s:date name="date" format="yyyy-MM-dd HH:mm:ss" /></td>--%>
                <td>
                    <div class="btn-group">
                        <a href="${pageContext.request.contextPath}/rest/portals/${id}.do">查看</a>
                        <a href="${pageContext.request.contextPath}/rest/portals/${id}/edit.do">修改</a>
                        <a href="${pageContext.request.contextPath}/rest/portals/${id}/deleteConfirm.do">删除</a>
                    </div>
                </td>
            </tr>
        </s:iterator>
    </table>
    <a href="${pageContext.request.contextPath}/rest/portals/new.do" class="btn btn-primary"><i
            class="icon icon-file"></i>新增</a>
</div>
</body>
</html>

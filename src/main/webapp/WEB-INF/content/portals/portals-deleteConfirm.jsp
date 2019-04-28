<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>Delete Portal ${id}</title>
</head>
<body>
<div>
    <s:form method="POST" action="${pageContext.request.contextPath}/rest/portals/${id}.do">
        <s:hidden name="_method" value="DELETE" />
        <p>
            Are you sure you want to delete portal ${id}?
        </p>
        <div class="btn-group">
            <input type="submit" value="Delete" class="btn btn-danger"/>
            <input type="button" value="Cancel" class="btn btn-success"
                   onclick="window.location.href = '${pageContext.request.contextPath}/rest/portals'"/>
        </div>
    </s:form>
    <a href="${pageContext.request.contextPath}/rest/portals.do" class="btn btn-info">
        <i class="icon icon-arrow-left"></i>返回
    </a>
</div>
</body>
</html>

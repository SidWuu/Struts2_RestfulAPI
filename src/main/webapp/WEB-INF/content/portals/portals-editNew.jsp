<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>New Portal</title>
</head>
<body>
<div>
    <s:form method="POST" action="%{pageContext.request.contextPath}/rest/portals.do">
        <div class="control-group">
            <label class="control-label" for="code">代码</label>
            <div class="controls">
                <s:textfield id="code" name="code" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="name">名称</label>
            <div class="controls">
                <s:textfield id="name" name="name" />
            </div>
        </div>
        <div class="form-actions">
            <s:submit cssClass="btn btn-primary"/>
        </div>
    </s:form>
    <a href="${pageContext.request.contextPath}/rest/portals.do" class="btn btn-info">
        <i class="icon icon-arrow-left"></i>返回
    </a>
</div>
</body>
</html>

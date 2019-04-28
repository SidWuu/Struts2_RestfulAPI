<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>Edit Portal ${id}</title>
</head>
<body>
<div>
    <s:form method="POST" action="${pageContext.request.contextPath}/rest/portals/${id}.do">
        <s:hidden name="_method" value="PUT"/>
        <div class="control-group">
            <label class="control-label" for="id">ID</label>
            <div class="controls">
                <s:textfield id="id" name="id" disabled="true"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="CODE">CODE</label>
            <div class="controls">
                <s:textfield id="CODE" name="CODE"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="NAME">NAME</label>
            <div class="controls">
                <s:textfield id="NAME" name="NAME"/>
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

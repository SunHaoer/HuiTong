<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>模块查看</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块查看
  </div> 
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd">
			<td>模块名称:</td>
			<td>${module.name}</td>
		</tr>
		<tr class="odd">
			<td>模块类型:</td>
			<td>
				<c:if test="${module.ctype ==1}">主菜单</c:if>
				<c:if test="${module.ctype ==2}">左侧菜单</c:if>
				<c:if test="${module.ctype ==3}">按钮</c:if>
			</td>
		</tr>
		<tr class="odd">
			<td>上级模块:</td>
			<td>
				${module.parentModule.name}
			</td>
		</tr>
		<tr class="odd">
			<td>排序号:</td>
			<td>${module.orderNo}</td>
		</tr>
		<tr class="odd">
			<td>状态:</td>
			<td>
				<c:if test="${module.state ==1}">启用</c:if>
				<c:if test="${module.state ==0}">停用</c:if>
			</td>
		</tr>
		<tr class="odd">
			<td>备注信息:</td>
			<td colspan="2">
				<textarea name="remark" style="height:80px;width:100%" readonly="readonly">${module.remark}</textarea>
			</td>
		</tr>
	</table>
</div>
 
</div>
</form>
</body>
</html>


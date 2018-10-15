<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>模块新增</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块新增
  </div> 
  
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd">
			<td>模块名称:</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr class="odd">
			<td>模块类型:</td>
			<td>
				<select name="ctype" style="width:120px">
					<option value="1" selected="selected">主菜单</option>
					<option value="2">左侧菜单</option>
					<option value="3">按钮</option>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>上级模块:</td>
			<td>
				<select name="parentModule.moduleId" style="width:120px" >
					<option value="">---请选择---</option>
					<c:forEach items="${parentModuleList}" var="p">
						<option value="${p.moduleId}">${p.name}</option>
					</c:forEach>	
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>排序号:</td>
			<td><input type="text" name="orderNo"/></td>
		</tr>
		<tr class="odd">
			<td>状态:</td>
			<td>
				<input type="radio" name="state" value="1"/>启用
				<input type="radio" name="state" value="0"/>停用
			</td>
		</tr>
		<tr class="odd">
			<td>备注信息:</td>
			<td colspan="2">
				<textarea name="remark" style="height:80px;width:100%"></textarea>
			</td>
		</tr>
	</table>
</div>
 
</div>
</form>
</body>
</html>


<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>部门新增</title>
</head>
<body>
	<form name="icform" method="post">
		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#" onclick="window.history.go(-1);">返回</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('update','_self');this.blur();">更新</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			部门新增
			<script type="text/javascript">
				$(function() { // 页面加载时执行的函数
					// 找到deptId的input
					$("#deptId").blur(function() {
						// ajax的异步请求
						var deptId = $('#deptId').val();
						$.ajax({
							url : "/sysadmin/dept/checkDeptId",
							data : {
								deptId : deptId
							}, // data存放的为deptId的key-value
							type : "", // 请求的发送方式
							dataType : "json", // 结果的返回值类型
							success : function() {
								if (data.result == "true") { // 部门编号存在
									$("checkresult").html("该部门编号被占用");
								} else { // 编号不存在
									$("checkresult").html("该部门编号可以使用");
								}
							}
						})
					}); // 失去焦点

				})
			</script>
		</div>
		<div>
			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tr class="odd">
						<td>部门编号：</td>
						<td><input type="text" id="deptId" name="deptId"
							value="${dept.deptId }" />${errorInfo }</td>
						<span id="checkresult"></span>
					</tr>
					<tr class="odd">
						<td>部门名称：</td>
						<td><input type="text" name="deptName"
							value="${dept.deptName }" /></td>
					</tr>
					<tr class="odd">
						<td>上级部门：</td>
						<td><select name="parentDept.deptId">
								<option>---无上级---</option>
								<c:forEach items="${parentDeptList }" var="p">
									<!-- 判断，当前部门不能选择自己的部门为上级部门 -->
									<c:if test="${p.deptId != dept.deptId }">
										<!-- 先判断 当前的 部门的id 是否 为 上级部门id -->
										<option value="${p.deptId }"
											<c:if test="${p.deptId == dept.parentDept.deptId}">selected="selected"</c:if>>${p.deptName}</option>
									</c:if>
								</c:forEach>
						</select></td>
					</tr>
					<tr class="odd">
						<td>部门状态：</td>
						<td><input type="radio" name="state" value="1"
							<c:if test="${dept.state==1}">checked="checked"</c:if> />启动 <input
							type="radio" name="state" value="0"
							<c:if test="${dept.state==0}">checked="checked"</c:if> />停用</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>


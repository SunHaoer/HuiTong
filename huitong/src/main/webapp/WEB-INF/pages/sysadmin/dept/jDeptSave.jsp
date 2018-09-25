<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>部门新增</title>
<script type="text/javascript">
	$(function() {//页面加载时执行的函数
		//找到deptId的input框
		$("#deptId").blur(function() {
			//var deptId = $("#deptId").val();
			var deptId = $("input[name='deptId']").val();
			//ajax的异步请求
			$.ajax({
				url : "/sysadmin/dept/checkDeptId",
				data : {
					deptId : deptId
				},//data中存放的为deptId的key 和 value
				type : "post",//请求的发送方式
				dataType : "json",//结果的返回值类型
				success : function(data) {
					//部门编号存在
					if (data.result == "true") {
						$("#checkresult").html("该部门编号被占用");
					}
					//部门编号不存在
					else {
						$("#checkresult").html("该部门编号可以使用");
					}
				}
			})
		});//失去焦点的事件
	})
</script>
</head>

<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#"
								onclick="formSubmit('list','_self');">返回</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('save','_self');this.blur();">保存</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			部门新增
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tr class="odd">
						<td>部门编号：</td>
						<td><input id="deptId" type="text" name="deptId" /> <span
							id="checkresult"></span></td>
					</tr>
					<tr class="odd">
						<td>部门名称：</td>
						<td><input type="text" name="deptName" /></td>
					</tr>
					<tr class="odd">
						<td>上级部门：</td>
						<td><select name="parentDept.deptId">
								<option>---无上级---</option>
								<!-- <option value="1">达内集团</option>
				<option value="2">研发部</option>
				<option value="3">教学部</option> -->
								<c:forEach items="${parentDeptList }" var="p">
									<option value="${p.deptId }">${p.deptName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr class="odd">
						<td>部门状态：</td>
						<td><input type="radio" name="state" value="1" />启动 <input
							type="radio" name="state" value="0" />停用</td>
					</tr>
				</table>
			</div>

		</div>


	</form>
</body>
</html>


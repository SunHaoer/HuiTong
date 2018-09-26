<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户列表</title>
<script type="text/javascript">
	$(function() {
		//最终目的是： list?currentPage=1&pageSize=动态的
		$("a").click(function() {
			//获取下拉框中的每一页的数据量
			var pagesize = $("#pageSize option:selected").val();
			//获取当前a标签的请求路径 
			var this_url = $(this).attr("href");
			//对url路径进行重新的赋值 list?currentPage=1&pageSize=10
			$(this).attr("href", this_url + "&pageSize=" + pagesize);
			alert($(this).attr("href"));
		})
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
								onclick="formSubmit('toview','_self');this.blur();">查看</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('tosave','_self');this.blur();">新增</a></li>
							<li id="update"><a href="#"
								onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
							<li id="delete"><a href="#"
								onclick="formSubmit('delete','_self');this.blur();">删除</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('start','_self');this.blur();">启用</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('stop','_self');this.blur();">停用</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('torole','_self');this.blur();">角色</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			用户列表
		</div>

		<div>


			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<thead>
						<tr style="padding: 0px;">
							<td colspan="10">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
										<td class="statusBar">找到 ${pageBean.totalCount} 条记录, 第
											${pageBean.currPage} 页</td>
										<td class="compactToolbar" align="right">
											<table border="0" cellpadding="1" cellspacing="2">
												<tr>
													<td><a href="list?currentPage=1"> <img
															src="../../staticfile/images/table/firstPageDisabled.gif"
															style="border: 0" alt="第一页" />
													</a></td>
													<td><a
														href="list?currentPage=${pageBean.currPage-1<=0? 1 : pageBean.currPage-1 }">
															<img
															src="../../staticfile/images/table/prevPageDisabled.gif"
															style="border: 0" alt="上一页" />
													</a></td>
													<td><a
														href="list?currentPage=${pageBean.currPage+1>=pageBean.totalPage? pageBean.totalPage : pageBean.currPage+1 }">
															<img src="../../staticfile/images/table/nextPage.gif"
															style="border: 0" title="下一页" alt="下一页" />
													</a></td>
													<td><a href="list?currentPage=${pageBean.totalPage }">
															<img src="../../staticfile/images/table/lastPage.gif"
															style="border: 0" title="最后页" alt="最后页" />
													</a></td>
													<td><img
														src="../../staticfile/images/table/separator.gif"
														style="border: 0" alt="Separator" /></td>
													<td><select name="pageSize" id="pageSize">
															<option value="2"
																<c:if test="${pageBean.pageSize==2 }">selected="selected"</c:if>>2</option>
															<option value="3"
																<c:if test="${pageBean.pageSize==3 }">selected="selected"</c:if>>3</option>
															<option value="4"
																<c:if test="${pageBean.pageSize==4 }">selected="selected"</c:if>>4</option>
													</select></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td class="tableHeader"><input type="checkbox" name="selid"
								onclick="checkAll('userId',this)"></td>
							<td class="tableHeader">序号</td>
							<td class="tableHeader">用户名</td>
							<td class="tableHeader">部门名称</td>
							<td class="tableHeader">真实姓名</td>
							<td class="tableHeader">身份证号</td>
							<td class="tableHeader">上级领导</td>
							<td class="tableHeader">薪资</td>
							<td class="tableHeader">入职日期</td>
							<td class="tableHeader">状态</td>
						</tr>
					</thead>
					<tbody class="tableBody">

						<c:forEach items="${userList}" var="u" varStatus="status">
							<tr class="odd" onmouseover="this.className='highlight'"
								onmouseout="this.className='odd'">
								<td><input type="checkbox" name="userId"
									value="${u.userId}" /></td>
								<td>${status.index+1+pageBean.pageSize*(pageBean.currPage-1)}</td>
								<td>${u.username}</td>
								<td>${u.dept.deptName}</td>
								<td>${u.userInfo.name}</td>
								<td>${u.userInfo.cardNo}</td>
								<td>${u.userInfo.managerInfo.name}</td>
								<td>${u.userInfo.salary}</td>
								<td><fmt:formatDate value="${u.userInfo.joinDate}"
										pattern="yyyy-MM-dd" /></td>
								<td><c:if test="${u.state==1}">
										<a href="stop?userId=${u.userId}"><font color="green">启用</font></a>
									</c:if> <c:if test="${u.state==0}">
										<a href="start?userId=${u.userId}"><font color="red">停用</font></a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>


	</form>
</body>
</html>


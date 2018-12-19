<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="cn.pdstore.Userlogin"%>
<%
	Userlogin uu = (Userlogin) request.getAttribute("use");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<script src="assets/js/ie-emulation-modes-warning.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	       <style>
            /*web background*/
            .container{
                display:table;
                height:100%;
            }

            .row{
                display: table-cell;
                vertical-align: middle;
            }
            /* centered columns styles */
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                text-align:left;
                margin-right:-4px;
            }
            .input-group-md{
            margin-top: 10px;
            }
        </style>
</head>
<body>
	<%
		String name = uu.getName();
		String pwd = uu.getPassworld();
	%>
	<ul class="list-group">
		<li class="list-group-item"><%=name%>:欢迎你</li>
		<li class="list-group-item">密码为：<%=pwd%></li>

		<button type="button" class="btn btn-default">
			<a href="task2/logintwo.jsp">注销</a>
		<button type="button" class="btn btn-default">
			<a href="task2/edit.do">编辑</a>
	</ul>
<!-- 	<div>
		模态框（Modal）
		<div class="modal fade " id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h5 class="modal-title" id="myModalLabel">编辑页</h5>
					</div>
					<div class="modal-body ">
				action="${pageContext.request.contextPath}/task2/show.do" 	
						 <form id="form1" >
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="username" name="name" placeholder="请输入用户ID"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="passworld" name="passworld" placeholder="请输入密码"/>
                        </div>
                        <br/>
                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-default" onclick="login">提交更改</button>
                    </form:form>
					</div>
					<div class="modal-footer">
						
					</div>
				</div>
				/.modal-content
			</div>
			/.modal
		</div>
	</div> -->
</body>
</html>
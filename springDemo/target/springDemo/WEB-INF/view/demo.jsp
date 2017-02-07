<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js">
</script>

<script>
$(document).ready(function(){
	$("button").click(function(){
	 $.post("/springDemo/ps",
			    {
			      name:"Donald Duck"
			    },
			    function(data,status){
			      alert("数据：" + data);
			    });
	 });
});
</script>
<title>首页</title>
</head>
<body>
   <h1>This is SpringMVC Demo</h1>
   <button>向页面发送 HTTP POST 请求，并获得返回的结果</button>
</body>
</html>
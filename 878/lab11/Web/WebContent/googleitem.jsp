<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
#padding {
	padding: 0px 0px 15px 15px;
}

a {
	color: #0B173B;
	font-size: 20px;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

.border-style {
	border-radius: 90px/90px;
}
</style>
</head>
<body>
<body
	style='background-color: #fffaf0; background-image: url(https://scontent.ftpe3-2.fna.fbcdn.net/v/t1.15752-9/270315910_3146591452265891_4546945842148907374_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=q4ap7l2Z2DIAX8XqlfA&_nc_ht=scontent.ftpe3-2.fna&oh=03_AVJl97rUvHEsAvn29SnylFiwkDtSco-nESRTZ3zVk20e2Q&oe=6204386D); background-repeat: no-repeat; background-attachment: fixed; background-position: center; background-size: cover;'>
	<form action='${requestUri}' method='get'>

		<div style='position: absolute;margin-top:190px;margin-left:50px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
			String s=orderList[i][1];
			s=s.substring(7);
		%>
		
		<a href='<%=s%>'><%=orderList[i][0]%> </a> <br><br>
		<br>
		<%
}
%>

		</div>
		<div>
			<img src="images/cafegogo.png"
				style='position: absolute; width: 300px; height: 100px; left: 50%; top: 50%; margin-top: -240px; margin-left: -590px'>

		</div>
		<div>
			<input type='text' class="border-style" id="padding" name='keyword'
				style='font-size: 100%;  position: absolute; left: 50%; top: 48%; ;margin-top: -200px; margin-left: -280px; width: 400px; height: 20px'
				placeholder='Type to search'
				value='<%=request.getParameter("keyword")%>' />
		</div>

	</form>
</body>
</html>
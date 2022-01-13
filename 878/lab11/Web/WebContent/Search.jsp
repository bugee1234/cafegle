<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Taipei Metro Cafe Map</title>
</head>


<body>
	<style>
html {
	height: 100%;
}

body {
background-color: gray;
	background-image:
		url(https://scontent.ftpe3-2.fna.fbcdn.net/v/t1.15752-9/p2048x2048/271067372_1148214822379503_2409821491428109314_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=ae9488&_nc_ohc=Je3fZOj9JcAAX9K6Y_r&_nc_ht=scontent.ftpe3-2.fna&oh=03_AVJuUfvbm5U8S-rvsuioS8A-37AAkWaHSfrNfpTfIg5bxg&oe=62041F58);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}
</style>
	<div style="text-align: center;">
		<br> <br> <br> <br> <br> <br>
		<h1 style="color: white">
			<span
				style="font-family: Brush Script MT, Brush Script Std, cursive; font-size: 55px">Cafegle</span>
		</h1>

		<form action='${requestUri}' method='get'>
			

			<div>
				<input type='text' class="border-style" id="padding"
					style='font-size: 120%; position: absolute;  top: 48%; margin-top: -47px; margin-left: -300px; width: 600px; border-radius: 40px; background: #fffaf0; height: 40px'
					name='keyword' placeholder='Type to search'
					onfocus="placeholder= '' " onblur="placeholder='Type to search'" />
			</div>
			<div>
				<input type='image' src="images/j41.png"
					style='position: absolute; background: #fffaf0; width: 38px; height: 38px; border-radius: 50%;left: 50%; top: 50%; margin-top: -55px; margin-left: 260px' />


			</div>
		</form>
</body>
</html>
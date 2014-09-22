<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<link rel="stylesheet" type="text/css" href="./public/styles/style.css"></link>
<link rel="stylesheet" type="text/css"
	href="./public/styles/css/bootstrap.css"></link>

<script type="text/javascript"
	src="./public/scripts/components/angular.js"></script>
<script type="text/javascript"
	src="./public/scripts/components/angular-route.js"></script>
<script type="text/javascript"
	src="./public/scripts/components/ui-bootstrap-tpls-0.11.0.js"></script>

<script type="text/javascript" src="./public/scripts/app.js"></script>
<script type="text/javascript" src="./public/scripts/controllers.js"></script>
<script type="text/javascript" src="./public/scripts/factories.js"></script>
<script type="text/javascript" src="./public/scripts/interceptor.js"></script>
<style>
body {
	font-size: 13px;
	margin: 20px;
	border: 1px solid grey;
	padding: 10px;
	border-radius: 10px;
	background-color: #f7f7f7;
	padding: 10px;
	border-radius: 10px;
}

#main-container {
	width: 100%;
	display: table;
}

#company-name {
	font-size: 40px;
	padding: 20px;
	position: relative;
	top: 10px;
	color: #37E4E4;
}

#company-logo {
	padding-right: 20px;
	float: right;
	height: 100px;
}

input[type="checkbox"] {
	margin: 5px;
}

.col-headers {
	font-size: 15px;
	font-weight: bold;
	margin-bottom: 10px;
}

.section-div {
	padding: 5px;
	border: 1px solid #398439;
	border-radius: 10px;
	box-shadow: 5px -5px #B9DBB9;
}

.section-header {
	border-bottom: 1px solid rgb(64, 156, 64);
	color: #449d44;
	font-weight: normal;
}

#loading-div {
  position: absolute;
  top: 0px;
  bottom: 0px;
  right: 0px;
  left: 0px;
  background: rgb(245, 240, 240);
  z-index: 200;
  text-align: center;
  font-size: 25px;
  opacity:0.5;
}
</style>
</head>
<body>
	<div id="main-container">
		<span id="company-name">Xyz Machine Works</span> <img
			id="company-logo" src="./public/images/logo.jpg" style="">
	</div>
	<div ng-app="proto">
		<div ng-view class="container-fluid"></div>
		<div ng-show="showLoading" id="loading-div"><img src="./public/images/spinner.gif"/></div>
	</div>
	
	
</html>


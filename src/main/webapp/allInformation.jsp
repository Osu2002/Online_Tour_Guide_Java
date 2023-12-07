<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.info.model.Information" %>    
<%@ page import = "com.info.service.IInfoService" %>
<%@ page import = "com.info.service.InfoServiceImpl" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
  	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	    <meta name="generator" content="Hugo 0.84.0">
	    <title>All Information</title>
	
	    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/jumbotron/">
	
	    
	
	    <!-- Bootstrap core CSS -->
		<link href="style/dist/css/bootstrap.min.css" rel="stylesheet">
		
		<script>
			function toAddInfoPage(){
				window.location.href = "addInformation.jsp";
			}
			
			function toHomePage(){
				window.location.href = "home.html";
			}
			
			function deleted(){
				alert("Information deleted Successfully");
			}
			
			
		</script>
	
	    <style>
		  *{
			margin: 0px;
			padding: 0px;
			box-sizing: border-box;
			font-family: sans-serif;
		  }
		  
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	      
	      span{
	      	text-align: center;
	      	color: white;
	      }
	      
	      h4{
	      	color: white;
	      }
		  
	    </style>
	    
	</head>
	
	<body>

		<main>
		  <div class="container py-4">
			<header class="pb-3 mb-4 border-bottom">
			
			<%
				String location = "";
				location = request.getParameter("location");
				
				String bgImage = "kandy1.jpg";
			%>
			
			<%
			switch(location){
				case "LOC-1" :
					bgImage = "sigiriya1.jpg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Sigiriya</span><%
					break;
				case "LOC-2" :
					bgImage = "Galle fort.jpg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Galle Fort</span><%
					break;
				case "LOC-3" :
					bgImage = "th (6).jpeg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Nuwara Eliya</span><%
					break;
				case "LOC-4" :
					bgImage = "yala.jpg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Yala National Park</span><%
					break;
				case "LOC-5" :
					bgImage = "Anuradhapura.jpg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Anuradhapura</span><%
					break;
				case "LOC-6" :
					bgImage = "Hikkaduwa-Coral-Reef-III.jpg";
					%><span class="fs-2" style="text-align: center; text-shadow: 2px 2px 2px black;">Hikkaduwa</span><%
					break;
			}
			%>
			
	<style>
	      .backGround{
			background-image: url("images/<%=bgImage %>");
	      	position: fixed;
			height: 100%;
	      	top: 0;
	      	left: 0;
	      	width: 100%;
	      	min-height: 100vh;
	      	background-repeat: repeat;
	      	background-size: cover;
	      	z-index: -1;
	      	filter: blur(5px);
	      }
	</style>
			
			<div class="backGround"></div>
				
			</header>
			<%				
				IInfoService iinfoService = new InfoServiceImpl();
				ArrayList<Information> infoList = iinfoService.getInformation();
			%>
			
			<%	
				for(Information information : infoList){
					if(information.getLocationID().equals(location)){
			%>
					  <div class="p-1 mb-3 bg-light rounded-3">
						<div class="container-fluid py-2">
						  <h3 class="display-7 fw-bold"><%= information.getHeading() %></h3>
						  <p class="col-md-12 fs-6"><%= information.getDescription() %></p>
						  <table>
							<tbody>
							  <td>
								<form action="<%= request.getContextPath() %>/get" method="post">
								  <input type="hidden" name="infoID" value="<%= information.getInfoID() %>">
								  <input style="border-radius: 15px;" class="btn btn-primary btn-sm" type="submit" value="Edit">
								</form>	
							  </td>
							  <td>
								<form action="<%= request.getContextPath() %>/delete" method="post">	
								  <input type="hidden" name="infoID" value="<%= information.getInfoID() %>">
								  <input style="border-radius: 15px;" class="btn btn-primary btn-sm" type="submit" value="Delete" onclick="deleted()">
								</form>
							  </td>
							</tbody>
						  </table>
						</div>
					  </div>
			<%		
					}
				}
			%>
			
			<button type="button" onclick="toAddInfoPage()" class="btn btn-primary btn-lg">Add Information</button>
			<button type="button" onclick="toHomePage()" class="btn btn-info btn-lg">Back to Home</button>

		  </div>
		</main>
	    <div class="container">
	      <p class="float-end mb-1">
	        <a href="#">Back to top</a>
	      </p>
	    </div>
	</body>
</html>
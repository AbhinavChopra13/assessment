<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function validate(){
		console.log("hello");
		v1=document.getElementById("n1").value;
		
		document.getElementById("a").innerHTML=v1;
	}
	
	function checkEmail(){
		var v=document.getElementById("em1").value;
		
		//step 1
		var xhr=new XMLHttpRequest();
		//step 2
		
		xhr.open("GET","CheckEmailServlet?myemail="+v,true);
		
		//step3
		xhr.send();
		
		//step 4
		xhr.onreadystatechange=function(){
			//alert(xhr.readyState);
			if(xhr.readyState==4){
				
				var res=xhr.responseText;
				//alert(res);
				document.getElementById("rr1").innerHTML=res;
			}
		}
		
	}
	
	

</script>


</head>
<body ">
  <center>
	<p><font color=blue size=5>Registration Page</font></p>
	<form action="RegistrationServlet" method="post">
	<table border="6">
		<tr>
			<td>Name</td><td><input type=text id="n1" name=nm required ></td>
		</tr>
		<tr>
			<td>Password</td><td><input type=password name=pass maxlength=8 minlength=3></td>
		</tr>
		<tr>
			<td>Email</td><td><input type=email name=em id="em1" onblur="checkEmail()"><div id="rr1"></div></td>
		</tr>
		<tr>
			<td>Address</td><td><input type=text name=ad></td>
		</tr>
		
		
		<tr>
			<td><input type=submit value=SignUp  id="b" ></td><td><input type=reset></td>
		</tr>
	</table>
	</form>
	<div id="captcha" ></div>
	<div id="a"></div>
	<br>
	<%= request.getAttribute("result") %>
	
	</center>
</body>
</html>
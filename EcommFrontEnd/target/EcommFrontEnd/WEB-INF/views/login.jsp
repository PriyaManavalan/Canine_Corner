<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body{
	background-image:
		url(https://previews.123rf.com/images/damedeeso/damedeeso1606/damedeeso160600030/58791630-happy-jack-russell-terrier-dog-in-park-or-meadow-waiting-and-looking-up-to-owner-to-play-and-have-fu.jpg)
}
#login-name {
	font-size: 65px;
	font-family: arabic typesetting;
	border-bottom-style: ridge;
	color: #f2152f;
}

#login {
	min-height: 300px;
	padding: 40px 80px 40px 80px;
}

.user {
	font-size: 29px;
	font-family: arabic typesetting;
	color: #f2152f;
}

#iconn {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: #f2152f;
}

#iconn1 {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: #f2152f;
}

#text1 {
	border-radius: 0;
	height: 40px;
}

#text2 {
	border-radius: 0;
	height: 40px;
}

.btn {
	width: 100%;
	float: left;
	height: 40px;
	font-size: 18px;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3" id="login">
			<form action="perform_login" method="post">
				<div class="form-group">
					<label class="user"> UserName </label>
					<div class="input-group">
						<span class="input-group-addon" id="iconn"> <i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							class="form-control" id="user_name" name="user_name" placeholder="Username">
					</div>
				</div>
				<div class="form-group">
					<label class="user"> Password </label>
					<div class="input-group">
						<span class="input-group-addon" id="iconn1"> <i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							class="form-control" id="user_password" name="user_password"
							placeholder=" Enter Password">
					</div>
				</div>
				<div class="form-group">

					<input type="submit" class="btn btn-success" value="login"
						style="border-radius: 0px;">
				</div>
				<br />
				<br />
				<br /> <a href="#"
					style="color: black; font-size: 15px; float: right; margin-right: 10px;">
					Forgot Password?? </a>
			</form>
		</div>
	</div>
</div>
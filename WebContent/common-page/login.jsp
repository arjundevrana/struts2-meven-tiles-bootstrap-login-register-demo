<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login|Page</title>
<script
  src="https://code.jquery.com/jquery-3.1.1.js"
  integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
  crossorigin="anonymous"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
 	<script src="${pageContext.request.contextPath}/js/respond.js"></script>
 	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
</head>
<body>
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     
                    <div style="padding-top:30px" class="panel-body" >
                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div> 
                     <!--    User login form  Start   -->
                       <s:form id="loginform" class="form-horizontal" role="form" action="logincheck">         
                            <div style="margin-bottom: 25px" class="input-group">
		                               <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		                               <s:textfield id="login-username"  cssClass="form-control" name="loginDTO.userName"  placeholder="username or email" requiredLabel="true">  </s:textfield>                                      
                             </div>   
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <s:textfield id="login-password" type="password" cssClass="form-control" name="loginDTO.password" placeholder="password" requiredLabel="true"></s:textfield>
                                    </div>           
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <button id="btn-login" class="btn btn-success">Login  </button>
                                      <a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%;margin-top: 20px;"  >
                                            Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                         </s:form>

 					<!--    User login form  End here   -->

                        </div>                     
                    </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                         <!--    User Registration form  Start   -->
                         
                            <form id="signupform" class="form-horizontal" method="post" name = "registration" role="form" autocomplete="off" action="registration">   
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>   
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <s:textfield type="email" cssClass="form-control" name="registrationDTO.emailId"  requiredLabel="true" placeholder="Email Address"></s:textfield>
                                    </div>
                                </div>   
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <s:textfield type="text" cssClass="form-control" requiredLabel="true"  name="registrationDTO.firstName" placeholder="First Name"></s:textfield>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                       <s:textfield type="text" cssClass="form-control"  name="registrationDTO.lastName" placeholder="Last Name"></s:textfield>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                     <s:password type="password" cssClass="form-control" name="registrationDTO.password" placeholder="Password"></s:password>
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <s:textfield  type="text" cssClass="form-control" name="registrationDTO.invitationCode" placeholder=""> </s:textfield>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                    </div>                                           
                                        
                                </div>  
                            </form>
                               <!--    User Registration End  here   -->
                         </div>
                    </div>
         </div> 
    </div>
    
</body>
</html>
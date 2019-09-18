<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/13
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="/register" method="post">
    用户：<input type="text" name="username" onblur="ajaxcheckuser(this.value)"><span id="namechecktip"></span><br>
    密码：<input type="password" name="password"><br>
     验证码：<input type="text" name="clientcheckcode" onblur="ajaxcheckcode(this.value)"><span id="ccode"></span><br>
    <img src="/checkcode" id="checkcodechange"/><a href="#" onclick="changeimg()">看不清，换一张</a><br>
    <input type="submit" value="注册">
     ${msg}
</form>
</body>
<script>
    //ajax异步请求
    //   TODO 注册页面需要正则校验
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    function ajaxcheckuser(username) {
        xmlhttp.open("GET","/getajax?username="+username,true);
        xmlhttp.send();
    }

    function ajaxcheckcode(checkcode){
        xmlhttp.open("GET","/checkajax?checkcheckcode="+checkcode,true);
        xmlhttp.send();
    }

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            var xmltext=xmlhttp.responseText;
            var sapntext=document.getElementById("namechecktip");
            if (xmltext=="no"){
                document.getElementById("namechecktip").innerHTML="<font color='green'>通过</font>"
            } else if (xmltext=="yes") {
                document.getElementById("namechecktip").innerHTML="<font color='red'>账号已存在</font>"
            } else if (xmltext=="codeyes"){
                document.getElementById("ccode").innerHTML="<font color='green'>验证码输入正确</font>"
            } else  if (xmltext=="codeno"){
                document.getElementById("ccode").innerHTML="<font color='red'>验证码输入错误</font>"
            }
        }
    }


    function changeimg() {
        var changeimg = document.getElementById("checkcodechange");
        changeimg.src="/checkcode?time="+new Date().getTime();
    }
</script>
</html>

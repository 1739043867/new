<!DOCTYPE html>
<html>
<head>
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="/static/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/static/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript">
        if (self.location != top.location) {
            top.location.href = self.location.href;
        }
    </script>
    <!-- 登录界面css -->
    <style>
        .loginbox {
            /* width: 700px;
             height: 410px;
             background-size: 700px 410px;*/
        }

        .loginbox ul {
            margin-top: 88px;
            margin-left: 290px;
        }
    </style>
</head>
<body style="background:#2e86d9 url(<%=basePath%>skin/images/bg.png) repeat-x top; overflow:hidden;">
<div class="logintop">
    <span>欢迎登录测试平台</span>
</div>
<div class="loginbody">
    <span style="display:block" class="systemlogo"></span>
    <form class="lg_form">
        <div class="loginbox">
            <ul>
                <li><input name="username" id="username" type="text" class="loginuser" /></li>
                <li><input name="password" id="password" type="password" class="loginpwd" /></li>
                <li>
                    <input name="code" id="code" type="text" class="logincode" />
                    <img alt="验证码" id="imgCode" style="width: 150px;height: 40px;" src="<%=basePath%>captcha" onclick="changeImg();">
                </li>
                <li><input id="loginBtn" type="button" class="loginbtn" value="登录" /></li>
            </ul>
        </div>
    </form>
</div>
</body>
<script>
    $(function(){
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            //alert(ev.keyCode)
            if(ev.keyCode==13) {
                login();
            }
        }
    });
    $(function () {
        $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        $(window).resize(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        });
        $("#loginBtn").click(function () {
            login();
        });
    });

    function login(){
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var code = $("#code").val().trim();
        var redirectUrl = '${param.redirectUrl}';
        if ( username == '') {
            layer.msg("用户账号不可为空");
            return false;
        }
        if (password == '') {
            layer.msg("密码不可为空");
            return false;
        }
        if (code == '') {
            layer.msg("验证码不可为空");
            return false;
        }
        $.ajax({
            url: "${basePath}login",
            type: "POST",
            data: {"username": username, "password": password, "code": code ,"redirectUrl":redirectUrl},// 要提交的表单
            beforeSend: function () {
                return loading();
            },
            success: function (rb) {
                closeloading();
                if (rb.code == 0) {
                    if(rb.data!='') {
                        location.href = rb.data;
                    }
                } else {
                    layer.msg(rb.msg);
                    changeImg();
                }
            },
            error: function () {
                layer.msg('程序错误!');
            }
        });
    }
    //刷新验证码
    function changeImg() {
        var imgSrc = $("#imgCode");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        var urls = url.split("?");
        url = urls[0] + "?timestamp=" + timestamp;
        return url;
    }
</script>
</body>
</html>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Login</title>
    </head>

    <body>
        <div style="text-align: center;">
            <form action="login" id="loginForm" method="post">
                账号：<input type="text" name="uname" id="uname" value="${messageModel.object.userName}"> <br>
                密码：<input type="text" name="upwd" id="upwd" value="${messageModel.object.userPwd}"> <br>
                <span id="msg" style="font-size:medium;color:deeppink">${messageModel.msg}</span><br>
                <button type="button" id="loginBtn">登录</button>
                <button type="button" id="registerBtn">注册</button>
            </form>
        </div>
    </body>
    <script type="text/javascript" src="js/jQuery.js"></script>
    <script type="text/javascript">
        $("#loginBtn").click(function() {
            var uname = $("#uname").val();
            var upwd = $("#upwd").val();
            if (IsEmpty(uname)) {
                $("#msg").html("用户名不能为空");
                return;
            }
            if (IsEmpty(upwd)) {
                $("#msg").html("密码不能为空");
                return;
            }

            // 如果不为空则提交表单
            $("#loginForm").submit();
        });

        // 判断字符串是否为空
        function IsEmpty(str) {
            if (str == null || str.trim() == "") {
                return true;
            } else return false;
        }
    </script>

    </html>
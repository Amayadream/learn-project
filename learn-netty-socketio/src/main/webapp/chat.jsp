<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Socketio chat</title>
    <script src="${ctx}/static/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/static/js/socket.io.js"></script>
    <style>
        body {
            padding: 20px;
        }
        #console {
            height: 400px;
            overflow: auto;
        }
        .username-msg {
            color: orange;
        }
        .connect-msg {
            color: green;
        }
        .disconnect-msg {
            color: red;
        }
        .send-msg {
            color: #888
        }
    </style>
</head>
<body>
<h1>Netty-socketio chat demo</h1>
<br />
<div id="console" class="well"></div>
<form class="well form-inline" onsubmit="return false;">
    <input id="name" class="input-xlarge" type="text" placeholder="用户名称. . . " />
    <input id="msg" class="input-xlarge" type="text" placeholder="发送内容. . . " />
    <button type="button" onClick="sendMessage()" class="btn">Send</button>
    <button type="button" onClick="sendDisconnect()" class="btn">Disconnect</button>
</form>
</body>
<script type="text/javascript">
    var socket = io.connect('http://localhost:9000');
    socket.on('connect',function() {
        output('<span class="connect-msg">Client has connected to the server!</span>');
    });

    socket.on('chatevent', function(data) {
        output('<span class="username-msg">' + data.username + ' : </span>'
                + data.message);
    });

    socket.on('disconnect',function() {
        output('<span class="disconnect-msg">The client has disconnected! </span>');
    });

    function sendDisconnect() {
        socket.disconnect();
    }

    function sendMessage() {
        var username = $("#name").val()
        var message = $('#msg').val();
        $('#msg').val('');
        socket.emit('chatevent', {
            username : username,
            message : message
        });
    }

    function output(message) {
        var currentTime = "<span class='time' >" + new Date() + "</span>";
        var element = $("<div>" + currentTime + " " + message + "</div>");
        $('#console').prepend(element);
    }
</script>
</html>
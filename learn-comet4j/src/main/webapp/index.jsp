<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Comet4j示例</title>
    <script src="${ctx}/source/plugins/jquery/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/source/static/js/comet4j.js"></script>
    <script type="text/javascript">
        $(function(){
            JS.Engine.on({
                start : function(cId, channelList, engine){
                    $("#message-list").append("<li class='message'>"+'连接已建立，连接ID为：' + cId+"</li>");
                },
                stop : function(cause, cId, url, engine){
                    $("#message-list").append("<li class='message'>"+'连接已断开，连接ID为：' + cId + ',断开原因：' + cause + ',断开的连接地址：'+ url +"</li>");
                },
                map: function(message){
                    $("#message-list").append("<li class='message'>"+message+"</li>")
                }
            });
        });

        function start(){
            JS.Engine.start("comet");
        }

        function stop(){
            JS.Engine.stop("主动关闭");
        }

        function clearList(){
            $("#message-list").find("li").remove();
        }

        function submit(){
            var word = $("#message").val();
            if(word != null && word != ""){
                $.getJSON("${ctx}/sample/run/" + word, function(data){

                });
                $("#message").val("")
            }else{
                alert("请输入信息..");
            }
        }
    </script>
</head>
<body>
<div>
    <h2>Comet4j测试</h2>
    <button onclick="start()">启动comet4j</button>
    <button onclick="stop()">关闭comet4j</button>
    <button onclick="clearList()">清理</button>
    <ul id="message-list" style="height: 400px;width:400px;background-color: #b9def0">

    </ul>
    <textarea id="message" style="height: 100px;width:400px"></textarea>
    <button onclick="submit()">发送</button>
</div>
</body>
</html>

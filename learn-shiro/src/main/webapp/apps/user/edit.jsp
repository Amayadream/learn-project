<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head lang="en">
    <title>编辑用户</title>
    <jsp:include page="../include/commonfile.jsp"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/adminLTE/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/select2/css/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/select2/css/select2-bootstrap.min.css">
    <script src="${ctx}/plugins/adminLTE/plugins/datatables/jquery.dataTables.js"></script>
    <script src="${ctx}/plugins/adminLTE/plugins/datatables/dataTables.bootstrap.js"></script>
    <script src="${ctx}/plugins/select2/js/select2.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- Header 开始 -->
    <header class="main-header">
        <!-- Logo -->
        <a href="${ctx}/apps/index.jsp" class="logo">
            <span class="logo-mini"><b>A</b>LT</span>   <!-- minilogo,50*50像素 -->
            <span class="logo-lg"><b>Admin</b>LTE</span><!-- 正常logo -->
        </a>

        <!-- 顶部导航栏 -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- 切换左侧导航栏菜单 -->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- 导航栏右侧菜单 -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="${ctx}/static/img/avtar.png" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">Alexander Pierce</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="${ctx}/static/img/avtar.png" class="img-circle" alt="User Image">
                                <p>
                                    Alexander Pierce - Web Developer
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="col-xs-4 text-center">
                                    <a href="#">Followers</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Sales</a>
                                </div>
                                <div class="col-xs-4 text-center">
                                    <a href="#">Friends</a>
                                </div>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header><!-- header end -->

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- Sidebar Start -->
        <section class="sidebar">
            <!-- user-panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${ctx}/static/img/avtar.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Alexander Pierce</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
                </div>
            </form>

            <!-- Menu Start -->
            <ul class="sidebar-menu">
                <li class="header">Menu</li>
                <li><a href="${ctx}/user"><i class="fa fa-briefcase"></i><span>资源管理</span></a></li>
                <li><a href="${ctx}/mail"><i class="fa fa-envelope"></i><span>邮件管理</span></a></li>
                <li class="treeview"><a href="${ctx}/user"><i class="fa fa-briefcase"></i><span>组织机构</span> <i class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="${ctx}/user"><i class="fa fa-diamond"></i>组织管理</a></li>
                        <li><a href="${ctx}/user"><i class="fa fa-user-secret"></i>角色管理</a></li>
                        <li  class="active"><a href="${ctx}/user"><i class="fa fa-users"></i>用户管理</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Menu End -->
        </section>
        <!-- Sidebar End -->
    </aside>

    <!-- Content Start -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>添加用户 <small>Create User</small></h1>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-6">
                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">添加用户</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal">
                            <div class="box-body">
                                <div class="form-group has-error">
                                    <label for="userid" class="col-sm-2 control-label">用户名</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="userid" placeholder="Username">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="email" placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="organization" class="col-sm-2 control-label">组织机构</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" id="organization">
                                            <option>1</option>
                                            <option>2</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="role" class="col-sm-2 control-label">角色</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" id="role">
                                            <option>1</option>
                                            <option>2</option>
                                        </select>
                                    </div>
                                </div>
                            </div><!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-default">返回</button>
                                <button type="submit" class="btn btn-info pull-right">添加</button>
                            </div><!-- /.box-footer -->
                        </form>
                    </div><!-- /.box -->
                </div><!--/.col (right) -->
            </div>   <!-- /.row -->
        </section>
    </div>
    <!-- Content End -->

    <!-- Footer Start -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">Anything you want</div>
        <strong>Copyright &copy; 2016 <a href="http://www.amayadream.com" target="_blank">Amayadream</a>.</strong> All rights reserved.
    </footer>
    <!-- Footer End -->
</div><!-- ./wrapper -->
<script>
    $(function(){
        //展示信息
        if("${message}"){
            layer.msg('${message}', {
                offset: 0
            });
        }
        if("${error}"){
            layer.msg('${error}', {
                offset: 0,
                shift: 6
            });
        }
    })

</script>
</body>
</html>

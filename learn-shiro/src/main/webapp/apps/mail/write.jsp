<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>邮件</title>
    <jsp:include page="../include/commonfile.jsp"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/select2/css/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/select2/css/select2-bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/adminLTE/plugins/iCheck/flat/blue.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <script src="${ctx}/plugins/select2/js/select2.js"></script>
    <script src="${ctx}/plugins/adminLTE/plugins/iCheck/icheck.js"></script>
    <script src="${ctx}/plugins/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
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
            <h1>邮件管理 <small>Mail Manager</small></h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-3">
                    <a href="${ctx}/mail" class="btn btn-primary btn-block margin-bottom">Back to Inbox</a>
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Folders</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="${ctx}/mail"><i class="fa fa-inbox"></i> Inbox <span class="label label-primary pull-right">12</span></a></li>
                                <li><a href="#"><i class="fa fa-envelope-o"></i> Sent</a></li>
                                <li><a href="#"><i class="fa fa-file-text-o"></i> Drafts</a></li>
                                <li><a href="#"><i class="fa fa-filter"></i> Junk <span class="label label-warning pull-right">65</span></a></li>
                                <li><a href="#"><i class="fa fa-trash-o"></i> Trash</a></li>
                            </ul>
                        </div><!-- /.box-body -->
                    </div><!-- /. box -->
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Labels</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#"><i class="fa fa-circle-o text-red"></i> Important</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> Promotions</a></li>
                                <li><a href="#"><i class="fa fa-circle-o text-light-blue"></i> Social</a></li>
                            </ul>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
                <div class="col-md-9">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Compose New Message</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class="form-group">
                                <input class="form-control" placeholder="To:">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Subject:">
                            </div>
                            <div class="form-group">
                    <textarea id="compose-textarea" class="form-control" style="height: 300px">
                      <h1><u>Heading Of Message</u></h1>
                      <h4>Subheading</h4>
                      <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure? On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee</p>
                      <ul>
                          <li>List item one</li>
                          <li>List item two</li>
                          <li>List item three</li>
                          <li>List item four</li>
                      </ul>
                      <p>Thank you,</p>
                      <p>John Doe</p>
                    </textarea>
                            </div>
                            <div class="form-group">
                                <div class="btn btn-default btn-file">
                                    <i class="fa fa-paperclip"></i> Attachment
                                    <input type="file" name="attachment">
                                </div>
                                <p class="help-block">Max. 32MB</p>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <div class="pull-right">
                                <button class="btn btn-default"><i class="fa fa-pencil"></i> Draft</button>
                                <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Send</button>
                            </div>
                            <button class="btn btn-default"><i class="fa fa-times"></i> Discard</button>
                        </div><!-- /.box-footer -->
                    </div><!-- /. box -->
                </div><!-- /.col -->
            </div><!-- /.row -->
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
    $(function () {
        $(function () {
            //Add text editor
            $("#compose-textarea").wysihtml5();
        });
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
    });

</script>
</body>
</html>

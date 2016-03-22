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
    <script src="${ctx}/plugins/select2/js/select2.js"></script>
    <script src="${ctx}/plugins/adminLTE/plugins/iCheck/icheck.js"></script>
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
                <li><a href="${ctx}/user"><i class="fa fa-envelope"></i><span>邮件管理</span></a></li>
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
                    <a href="compose.html" class="btn btn-primary btn-block margin-bottom">Compose</a>
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Folders</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul class="nav nav-pills nav-stacked">
                                <li class="active"><a href="#"><i class="fa fa-inbox"></i> Inbox <span class="label label-primary pull-right">12</span></a></li>
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
                        </div>
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
                            <h3 class="box-title">Inbox</h3>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Search Mail">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div><!-- /.box-tools -->
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div><!-- /.btn-group -->
                                <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div><!-- /.btn-group -->
                                </div><!-- /.pull-right -->
                            </div>
                            <div class="table-responsive mailbox-messages">
                                <table class="table table-hover table-striped">
                                    <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">5 mins ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">28 mins ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">11 hours ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">15 hours ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">Yesterday</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">2 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">2 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">2 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">2 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">2 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">4 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"></td>
                                        <td class="mailbox-date">12 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">12 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">14 days ago</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                        <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
                                        <td class="mailbox-subject"><b>AdminLTE 2.0 Issue</b> - Trying to find a solution to this problem...</td>
                                        <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                        <td class="mailbox-date">15 days ago</td>
                                    </tr>
                                    </tbody>
                                </table><!-- /.table -->
                            </div><!-- /.mail-box-messages -->
                        </div><!-- /.box-body -->
                        <div class="box-footer no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div><!-- /.btn-group -->
                                <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div><!-- /.btn-group -->
                                </div><!-- /.pull-right -->
                            </div>
                        </div>
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
//Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });

        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });

        //Handle starring for glyphicon and font awesome
        $(".mailbox-star").click(function (e) {
            e.preventDefault();
            //detect type
            var $this = $(this).find("a > i");
            var glyph = $this.hasClass("glyphicon");
            var fa = $this.hasClass("fa");

            //Switch states
            if (glyph) {
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $this.toggleClass("fa-star");
                $this.toggleClass("fa-star-o");
            }
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

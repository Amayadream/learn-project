<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head lang="en">
    <title>用户管理</title>
    <jsp:include page="include/commonfile.jsp"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/plugins/adminLTE/plugins/datatables/dataTables.bootstrap.css">
    <script src="${ctx}/plugins/adminLTE/plugins/datatables/jquery.dataTables.js"></script>
    <script src="${ctx}/plugins/adminLTE/plugins/datatables/dataTables.bootstrap.js"></script>
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
                    <li class="dropdown messages-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the messages -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <!-- User Image -->
                                                <img src="${ctx}/static/img/avtar.png" class="img-circle" alt="User Image">
                                            </div>
                                            <!-- Message title and timestamp -->
                                            <h4>
                                                Support Team
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <!-- The message -->
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li><!-- end message -->
                                </ul><!-- /.menu -->
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li><!-- /.messages-menu -->

                    <!-- Notifications Menu -->
                    <li class="dropdown notifications-menu">
                        <!-- Menu toggle button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 10 notifications</li>
                            <li>
                                <!-- Inner Menu: contains the notifications -->
                                <ul class="menu">
                                    <li><!-- start notification -->
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                        </a>
                                    </li><!-- end notification -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul>
                    </li>
                    <!-- Tasks Menu -->
                    <li class="dropdown tasks-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 9 tasks</li>
                            <li>
                                <!-- Inner menu: contains the tasks -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="#">
                                            <!-- Task title and progress text -->
                                            <h3>
                                                Design some buttons
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <!-- The progress bar -->
                                            <div class="progress xs">
                                                <!-- Change the css width attribute to simulate progress -->
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li><!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">View all tasks</a>
                            </li>
                        </ul>
                    </li>
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
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
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
            <h1>用户管理 <small>User Manager</small></h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div style="float:right">
                                <button class="btn bg-olive btn-sm" onclick="add();">添加用户</button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>组织机构</th>
                                    <th>所属角色</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </div><!-- /.row -->

            <div class="modal fade" id="edit-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> 编辑</h4>
                        </div>
                        <form class="form-horizontal" id="edit-form" action="" method="post">
                        <div class="modal-body">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="userid" class="col-sm-2 control-label">用户名</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="userid" name="userid" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="organization" class="col-sm-2 control-label">组织</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="organization" name="organization_id" placeholder="组织机构...">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="role" class="col-sm-2 control-label">角色</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="role" name="role_ids" placeholder="角色...">
                                    </div>
                                </div>
                            </div><!-- /.box-body -->
                        </div>
                        <div class="modal-footer">
                                <button type="submit" class="btn bg-olive">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <div class="modal fade" id="add-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> 编辑</h4>
                        </div>
                        <form class="form-horizontal" id="add-form" action="" method="post">
                            <div class="modal-body">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label for="userid" class="col-sm-2 control-label">用户名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="add-userid" name="userid" disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="organization" class="col-sm-2 control-label">组织</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="add-organization" name="organization_id" placeholder="组织机构...">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="role" class="col-sm-2 control-label">角色</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="add-role" name="role_ids" placeholder="角色...">
                                        </div>
                                    </div>
                                </div><!-- /.box-body -->
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn bg-olive">保存</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <div class="modal fade " id="del-modal">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-warning-sign"></span> 警告</h4>
                        </div>
                        <div class="modal-body">
                            确定删除这个用户吗?
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="btn btn-danger" id="del-button">确认</a>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </section>
    </div>
    <!-- Content End -->

    <!-- Footer Start -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">Anything you want</div>
        <strong>Copyright &copy; 2016 <a href="http://www.amayadream.com" target="_blank">Amayadream</a>.</strong> All rights reserved.
    </footer>
    <!-- Footer End -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane active" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript::;">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                </ul><!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript::;">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="label label-danger pull-right">70%</span>
                            </h4>
                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                </ul><!-- /.control-sidebar-menu -->

            </div><!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>
                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                        <p>
                            Some information about this general settings option
                        </p>
                    </div><!-- /.form-group -->
                </form>
            </div><!-- /.tab-pane -->
        </div>
    </aside><!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div><!-- ./wrapper -->
<script>
    $(function () {
        $('#example2').DataTable({
            paging: true,
            lengthChange: true,
            searching: true,
            ordering: true,
            info: true,
            autoWidth: true,
            ajax: {
                url: '${ctx}/api/user/all',
                tupe: 'GET'
            },
            columns : [
                { data: 'userid' },
                { data: function(e){if(e.email == null){return "";}else{return e.email;}}},
                { data: function(e){if(e.organization_id == null){return "";}else{return e.organization_id;}}},
                { data: function(e){if(e.role_ids == null){return "";}else{return e.role_ids;}} },
                { data: function(e){return e.locked == 0 ? "正常":"锁定";}},
                { data : function(e){return "<button class=\"btn bg-olive btn-sm\" onclick=\"edit('"+ e.userid+"')\">编辑</button> <button class=\"btn btn-danger btn-sm\" onclick=\"del('"+ e.userid+"')\">删除</button>"}}
            ],
            language: {
                sProcessing: "处理中...",
                sLengthMenu: "显示 _MENU_ 项结果",
                sZeroRecords: "没有匹配结果",
                sInfo: "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                sInfoEmpty: "显示第 0 至 0 项结果，共 0 项",
                sInfoFiltered: "(由 _MAX_ 项结果过滤)",
                sInfoPostFix: "",
                sSearch: "搜索:",
                sUrl: "",
                sEmptyTable: "表中数据为空",
                sLoadingRecords: "载入中...",
                sInfoThousands: ",",
                oPaginate: {
                    sFirst: "首页",
                    sPrevious: "上页",
                    sNext: "下页",
                    sLast: "末页"
                },
                oAria: {
                    sSortAscending: ": 以升序排列此列",
                    sSortDescending: ": 以降序排列此列"
                }
            }
        });

        //清空modal
        $('#edit-modal').on('hidden.bs.modal', function (e) {
            $("#del-button").attr("onclick", "");
            $("#userid").val("");
            $("#organization").val("");
            $("#role").val("");
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

    /**
     * 删除用户
     * @param userid
     */
    function del(userid){
        $("#del-button").attr("href", "${ctx}/user/"+ userid+"/delete");
        $('#del-modal').modal({})
    }

    /**
     * 修改用户
     * @param userid
     */
    function edit(userid){
        $.getJSON("${ctx}/api/user/"+userid, function(data){
            $("#userid").val(data.userid);
            $("#organization").val(data.organization_id);
            $("#role").val(data.role_ids);
            $("#edit-form").attr("action", "${ctx}/user/"+userid+"/update")
        });
        $('#edit-modal').modal({})
    }

    function add(){
        $('#add-modal').modal({})
    }

</script>
</body>
</html>

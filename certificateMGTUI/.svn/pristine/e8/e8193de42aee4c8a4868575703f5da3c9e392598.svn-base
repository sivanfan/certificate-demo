<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>
        <sitemesh:write property='title'/>
    </title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <meta name="description" content="Static &amp; Dynamic Tables" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${ctx}/assets/css/jquery-ui.custom.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/chosen.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/datepicker.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/bootstrap-timepicker.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="${ctx}/assets/css/colorpicker.min.css" />


    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}/assets/fonts/fonts.googleapis.com.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/assets/css/ace-ie.min.css" />
    <![endif]-->
    <!-- ace settings handler -->
    <script src="${ctx}/assets/js/ace-extra.min.js"></script>
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Certificate Manager
                </small>
            </a>
        </div>
    </div><!-- /.navbar-container -->
</div>


<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar responsive" data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
        </script>


        <ul class="nav nav-list" style="top: 0px;">
            <li class="">
                <a href="javascript:void(0);">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="active open">
                <a href="javascript:void(0);" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 证书管理 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="active">
                        <a href="${ctx}/cermanager/query?cersendtype=1">
                            <i class="menu-icon fa fa-caret-right"></i>
                            内部证书查看
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="active">
                        <a href="${ctx}/cermanager/query?cersendtype=2">
                            <i class="menu-icon fa fa-caret-right"></i>
                            外部证书查看
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/cermanager/createCer">
                            <i class="menu-icon fa fa-caret-right"></i>
                            证书申请
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/cermanager/uploadCer">
                            <i class="menu-icon fa fa-caret-right"></i>
                            证书上传
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
        </ul><!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        </script>
    </div>

    <sitemesh:write property='body'/>

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
                    <span class="bigger-120">
                        <span class="blue bolder">ule.com</span>
                        Application © 2009-2019
                    </span>

            </div>
        </div>
    </div>


</div>

<script src="${ctx}/assets/js/bootstrap.min.js"></script>
<!--[if lte IE 8]>
<script src="${ctx}/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/assets/js/jquery-ui.custom.min.js"></script>
<script src="${ctx}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx}/assets/js/chosen.jquery.min.js"></script>
<script src="${ctx}/assets/js/fuelux.spinner.min.js"></script>
<script src="${ctx}/assets/js/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/assets/js/bootstrap-timepicker.min.js"></script>
<script src="${ctx}/assets/js/bootstrap-datepicker.zh-CN.js"></script>
<script src="${ctx}/assets/js/moment.min.js"></script>
<script src="${ctx}/assets/js/daterangepicker.min.js"></script>
<script src="${ctx}/assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="${ctx}/assets/js/jquery.knob.min.js"></script>
<script src="${ctx}/assets/js/jquery.autosize.min.js"></script>
<script src="${ctx}/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="${ctx}/assets/js/jquery.maskedinput.min.js"></script>
<script src="${ctx}/assets/js/jquery.validate.min.js"></script>
<!-- ace scripts -->
<script src="${ctx}/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/assets/js/ace.min.js"></script>


<script type="text/javascript">
    $(function(){
        var menuid=${menuid}-1;
        $('.submenu li').removeClass('active');
        $(".submenu li").eq(menuid).addClass('active');

        //datepicker plugin

        $('#date-timepicker1').datetimepicker().next().on(ace.click_event, function(){
            $(this).prev().focus();
        });

        $(document).one('ajaxloadstart.page', function(e) {
            $('textarea[class*=autosize]').trigger('autosize.destroy');
            $('.limiterBox,.autosizejs').remove();
            $('.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu').remove();
        });

    });
</script>
</body>
</html>

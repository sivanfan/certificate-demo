<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>证书查看</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">


        <div class="page-content">
            <div class="page-header">
                <h1>
                    证书管理
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        证书查看
                    </small>
                </h1>
            </div><!-- /.page-header -->

            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>


                <form  action="${ctx}/cermanager/query" method="post">
                    <input type="hidden" name="cersendtype" value="${cersendtype}">
                <div class="input-group" style="width: 300px;float: right">

                    <input type="text" class="form-control search-query" id="searchval"
                           name="searchval" value="${searchval}" placeholder="请输入模块名">
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-purple btn-sm">
                            <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
                            Search
                        </button>
                    </span>
                </div>
                </form>
            </div>



            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <table id="simple-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>业务单元名</th>
                                    <th>模块名</th>
                                    <th>颁发主体</th>

                                    <th>
                                        <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                        到期时间
                                    </th>
                                    <th>证书类型</th>
                                    <th>使用环境</th>

                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="cer"   items="${infolist}"   varStatus="index">
                                        <td> ${cer.busiName}</td>
                                        <td> ${cer.sysName}</td>
                                        <td>
                                            <c:if test="${cer.cerSendType==1}">内部颁发(ule)</c:if>
                                            <c:if test="${cer.cerSendType==2}">外部颁发(${cer.channelCode})</c:if>
                                        </td>
                                        <td> ${cer.expirationDate}</td>
                                        <td>
                                            <c:if test="${cer.cerType=='1'}">公钥</c:if>
                                            <c:if test="${cer.cerType=='2'}">私钥</c:if>
                                            <c:if test="${cer.cerType=='3'}">PFX公私钥</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${cer.cerEnv=='1'}">Dev</c:if>
                                            <c:if test="${cer.cerEnv=='2'}">Beta</c:if>
                                            <c:if test="${cer.cerEnv=='3'}">Prd</c:if>
                                        </td>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group"  style="position: absolute">
                                                <button class="btn btn-xs btn-danger" onclick="del('${cer.id}','${cersendtype}')">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <!-- 一行结束-->
                                </tbody>
                            </table>

                        </div><!-- /.span -->
                    </div><!-- /.row -->
                </div><!-- /.col -->
            </div><!-- /.row -->

            <!--分页 -->
            <div style="float: right;">
                <ul id='bp-3-element-test'></ul>
            </div>
        </div><!-- /.page-content -->
    </div>
</div>

<script type="text/javascript">
    function del(uid,cersendtype) {
        window.location.href="${ctx}/cermanager/delCer?id="+uid+"&cersendtype="+cersendtype;
    }
</script>
<script type="text/javascript" src="${ctx}/assets/js/jquery-1.9.1.min.js"></script>
<script src="${ctx}/assets/js/bootstrap-paginator.js" type="text/javascript" ></script>
<script type="text/javascript">
    $(function(){
        var element = $('#bp-3-element-test');
        var options = {
            bootstrapMajorVersion:3,
            currentPage: ${currentPage},
            numberOfPages: 5,
            totalPages:${totalPages},
            pageUrl: function(type, page, current){
                return "${ctx}/cermanager/query?cersendtype="+ ${cersendtype}+"&pagenum="+page;
            }
        }
        element.bootstrapPaginator(options);
    });
</script>
</body>
</html>
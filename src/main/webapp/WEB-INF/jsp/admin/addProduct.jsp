<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/admind/assets" var="assertBaseUrl" htmlEscape="true"/>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->
<head>

    <jsp:include page="../../common/meta.jsp"/>
    <title>Admin dashboard</title>
    <jsp:include page="../../common/css.jsp"/>

    <style>
        .error{
            color: red;
        }
    </style>

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern semi-dark-layout 2-columns  navbar-floating footer-static  " data-open="click" data-menu="vertical-menu-modern" data-col="2-columns" data-layout="semi-dark-layout">



<!-- BEGIN: Main Menu-->
<jsp:include page="menu.jsp"/>
<!-- END: Main Menu-->
<br><br><br><br>
<section id="multiple-column-form">
    <div class="row match-height">
        <div class="col-6 offset-md-4">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Məhsul əlavə et</h4>
                </div>
                <div class="card-content">
                    <div class="card-body">
                        <form:form modelAttribute="productDto" method="post" action="save-product" enctype="multipart/form-data">
                            <div class="form-body">
                                <div class="row">
                                    <div class="col-md-6 col-12">
                                        <div class="form-label-group">
                                            <form:input path="name" cssClass="form-control" placeholder="Məhsul adı"/>
                                            <form:errors path="name" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-label-group">
                                            <form:select path="categoryId" cssClass="btn btn-flat-primary dropdown-toggle dropdown-toggle-split waves-effect waves-light" data-toggle="dropdown">
                                                <form:option value="${12}">Kateqoriya seçin</form:option>
                                                <c:forEach items="${categoryList}" var="category">
                                                  <form:option value="${category.id}">${category.name}
                                                  </form:option>
                                              </c:forEach>
                                          </form:select>
                                            <form:errors path="categoryId"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-label-group">
                                            <form:textarea path="description" cssClass="form-control" placeholder="Məhsul haqqında"/>
                                            <form:errors path="description" cssClass="error"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-label-group">
                                            <form:input path="photo" type="file"/>
                                        </div>
                                    </div>

                                    <div class="col-12 offset-md-4">
                                        <button type="submit" class="btn btn-primary mr-1 mb-1 waves-effect waves-light">Təsdiqlə</button>
                                        <button type="reset" class="btn btn-outline-warning mr-1 mb-1 waves-effect waves-light">Təmizlə</button>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="sidenav-overlay"></div>
<div class="drag-target"></div>


<jsp:include page="../../common/js.jsp"/>


</body>
<!-- END: Body-->

</html>
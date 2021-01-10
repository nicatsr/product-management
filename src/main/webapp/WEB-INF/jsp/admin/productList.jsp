
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/adminFront/products" var="baseUrl" htmlEscape="true"/>
<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<!-- BEGIN: Head-->

<head>
    <jsp:include page="../../common/meta.jsp"/>
    <title>List</title>
    <jsp:include page="../../common/css.jsp"/>

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern semi-dark-layout 2-columns  navbar-floating footer-static  " data-open="click" data-menu="vertical-menu-modern" data-col="2-columns" data-layout="semi-dark-layout">


<jsp:include page="menu.jsp"/>

<!-- BEGIN: Content-->
<div class="app-content content">
    <div class="content-overlay"></div>
    <div class="header-navbar-shadow"></div>
    <div class="content-wrapper">

        <div class="content-body">
            <!-- Data list view starts -->
            <section id="data-thumb-view" class="data-thumb-view-header">
                <div class="action-btns d-none">
                    <div class="btn-dropdown mr-1 mb-1">
                        <div class="btn-group dropdown actions-dropodown">
                            <button type="button"
                                    class="btn btn-white px-1 py-1 dropdown-toggle waves-effect waves-light"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Actions
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#"><i class="feather icon-trash"></i>Delete</a>
                                <a class="dropdown-item" href="#"><i class="feather icon-archive"></i>Archive</a>
                                <a class="dropdown-item" href="#"><i class="feather icon-file"></i>Print</a>
                                <a class="dropdown-item" href="#"><i class="feather icon-save"></i>Another Action</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- dataTable starts -->
                <div class="table-responsive">
                    <table class="table data-thumb-view">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Foto</th>
                            <th>Məhsul adı</th>
                            <th>Kateqoriya</th>
                            <th>Məhsul haqqında</th>
                            <th>Dəyişiklik</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productList}" var="product" varStatus="status">
                            <tr>
                                <td></td>
                                <td class="product-img">
                                    <img src="http://localhost:8080/photo/${product.photoId}" width="115" height="115"/>
                                </td>
                                <td class="product-name">${product.name}</td>
                                <td class="product-category">${product.categoryName}</td>
                                <td class="product-category">${product.description}</td>

                                <td class="product-action">
                                    <a href="update-product?id=${product.id}"><i class="feather icon-edit"></i></a>
                                    <a href="delete?id=${product.id}"><i class="feather icon-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
                <!-- dataTable ends -->
            </section>
            <!-- Data list view end -->

        </div>
    </div>
</div>
<!-- END: Content-->

<div class="sidenav-overlay"></div>
<div class="drag-target"></div>




<!-- BEGIN: Vendor JS-->
<script src="../../../app-assets/vendors/js/vendors.min.js"></script>
<!-- BEGIN Vendor JS-->

<!-- BEGIN: Page Vendor JS-->
<script src="../../../app-assets/vendors/js/extensions/dropzone.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/datatables.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/datatables.buttons.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/datatables.bootstrap4.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/buttons.bootstrap.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/dataTables.select.min.js"></script>
<script src="../../../app-assets/vendors/js/tables/datatable/datatables.checkboxes.min.js"></script>
<!-- END: Page Vendor JS-->

<jsp:include page="../../common/js.jsp"/>

</body>
<!-- END: Body-->

</html>
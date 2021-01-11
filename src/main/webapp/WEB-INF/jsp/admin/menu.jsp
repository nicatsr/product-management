<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="main-menu menu-fixed menu-dark menu-accordion menu-shadow" data-scroll-to-active="true">
    <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">
            <li class="nav-item mr-auto"><a class="navbar-brand" href="/adminFront/admind">
                <div class="brand-logo"></div>
                <h3 class="brand-text mb-0">Online alış-veriş</h3>
            </a></li>
            <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pr-0" data-toggle="collapse"><i class="feather icon-x d-block d-xl-none font-medium-4 primary toggle-icon"></i><i class="toggle-icon feather icon-disc font-medium-4 d-none d-xl-block collapse-toggle-icon primary" data-ticon="icon-disc"></i></a></li>
        </ul>
    </div>
    <div class="shadow-bottom"></div>
    <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
            <li class=" nav-item"><a href="/admin/"><i class="feather icon-home"></i><span class="menu-title" data-i18n="Dashboard">Dashboard</span><span class="badge badge badge-warning badge-pill float-right mr-2"></span></a>

            </li>

            <li class=" nav-item"><a href="/admin/add-product"><i class="feather icon-shopping-cart"></i><span class="menu-title" data-i18n="User">Məhsul əlavə et</span></a>

            </li>
            <li class=" nav-item"><a href="/admin/get-product-list"><i class="feather icon-list"></i><span class="menu-title" data-i18n="User">Məhsullar siyahısına bax</span></a>

            </li>
            <li class=" nav-item"><a href="/logout"><i class="fa fa-sign-out" aria-hidden="true"></i><span class="menu-title" data-i18n="Ecommerce">Çıxın</span></a>

            </li>
        </ul>
    </div>
</div>

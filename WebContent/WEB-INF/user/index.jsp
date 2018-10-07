<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="MobileOptimized" content="240" />
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <title>携康长荣</title>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/index.css" />
</head>
<body aria-atomic="False" style="background: #ededed;">
    <!--幻灯片 开始-->
    <script type="text/javascript" src="../js/jquery.flexslider-min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.flexslider').flexslider({
                controlNav: true,
                directionNav: false,
                animation: "slide"
                //manualControls: ".myflexslider .slidenav"
            });
        });
    </script>
    <div id="banner" class="flexslider">
        <ul class="slides">
            <li>
                <img src="../img/banner.jpg" /></li>
            <li>
                <img src="../img/banner.jpg" /></li>
            <li>
                <img src="../img/banner.jpg" /></li>
        </ul>
    </div>
    <!--幻灯片 结束-->
    <div class="inContent">
        <dl class="ind_TuBiao">
            <dd><a href="About.html">
                <img src="../img/ind_01.png" /><p>公司简介</p>
            </a></dd>
            <dd><a href="gosetmeal.action">
                <img src="../img/ind_02.png" /><p>服务项目</p>
            </a></dd>
            <dd><a href="News.html">
                <img src="../img/ind_03.png" /><p>我的预约</p>
            </a></dd>
            <dd><a href="Case.html">
                <img src="../img/ind_04.png" /><p>案例分享</p>
            </a></dd>
            <dd><a href="gopersonal.action">
                <img src="../img/ind_05.png" /><p>我的资料</p>
            </a></dd>
            <dd><a href="MyOrder.html">
                <img src="../img/ind_06.png" /><p>我的订单</p>
            </a></dd>
            <dd><a href="MyBranch.html">
                <img src="../img/ind_07.png" /><p>我的分销</p>
            </a></dd>
            <dd><a href="Extended.html">
                <img src="../img/ind_08.png" /><p>我的推广码</p>
            </a></dd>
        </dl>
        <div class="indChen">
            <dl>
                <dt>
                    <span>
                        <img src="../img/ind_09.png" />推荐体检套餐</span></dt>
                <dd><a href="NavigationShow.html">
                    <img src="../img/ind_11.jpg" />
                    <h1>XK早癌筛查</h1>
                    <h2>致力于最高质量的健康管理提升生命质量严谨科学、规范权威，全心全意、精益求精先进科技驱动中国健康与医疗服...</h2>
                </a></dd>
                <dd><a href="NavigationShow.html">
                    <img src="../img/ind_12.jpg" />
                    <h1>XK早癌筛查</h1>
                    <h2>致力于最高质量的健康管理提升生命质量严谨科学、规范权威，全心全意、精益求精先进科技驱动中国健康与医疗服...</h2>
                </a></dd>
                <dd><a href="NavigationShow.html">
                    <img src="../img/ind_11.jpg" />
                    <h1>XK早癌筛查</h1>
                    <h2>致力于最高质量的健康管理提升生命质量严谨科学、规范权威，全心全意、精益求精先进科技驱动中国健康与医疗服...</h2>
                </a></dd>
                <dd><a href="NavigationShow.html">
                    <img src="../img/ind_12.jpg" />
                    <h1>XK早癌筛查</h1>
                    <h2>致力于最高质量的健康管理提升生命质量严谨科学、规范权威，全心全意、精益求精先进科技驱动中国健康与医疗服...</h2>
                </a></dd>
            </dl>
        </div>
        <div class="indChen">
            <dl>
                <dt>
                    <span>
                        <img src="../img/ind_10.png" />热点资讯</span></dt>
                <dd><a href="NewsShow.html">
                    <img src="../img/ind_11.jpg" />
                    <h1>XK早癌筛查</h1>
                    <h2>致力于最高质量的健康管理提升生命质量严谨科学、规范权威，全心全意、精益求精先进科技驱动中国健康与医疗服...</h2>
                </a></dd>
            <li><a href="index.html" class="cur">
                <img src="../img/foot_01.png" />
                <p>首页</p>
            </a></li>
            <li><a href="Navigation.html">
                <img src="../img/foot_02.png" />
                <p>体检套餐</p>
            </a></li>
            <li><a href="Order.html">
                <img src="../img/foot_03.png" />
                <p>筛查中心网点</p>
            </a></li>
            <li><a href="Login.html">
                <img src="../img/foot_04.png" />
                <p>会员中心</p>
            </a></li>
        </ul>
    </div>
</body>
</html>
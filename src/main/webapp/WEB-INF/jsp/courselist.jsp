<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ljm.model.task11"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="/css/t11.css" rel="stylesheet" type="text/css">
    <link href="/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<header>
    <div class="top container">
        <p class="hidden-xs">客服热线：010-594-78634</p>
        <img src="/photo/12321.gif">
    </div>

    <div role="navigation" class="nav1 navbar navbar-default">
        <div class="container">
            <div class="header-logo">
                <div class="logo-middle"><img src="/photo/logo.png"></div>
            </div>
            <div class="navbar-header marginTop">
                <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div id="example-navbar-collapse" class=" collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href="/home"><li>首 页</li></a>
                    <a href="/courselist"><li class="border">职 业</li></a>
                    <a href=""><li>推 荐</li></a>
                    <a href=""><li>关 于</li></a>
                </ul>
            </div>
        </div>
    </div>

</header>

<div class="container padding-bottom">
    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <c:forEach items="${lists}" var="list">
            <c:forEach items="${list}" var="profession">
                <a class="nav-bar-a" href="">${profession.head}</a>
            </c:forEach>
        </c:forEach>
    </div>

    <c:forEach items="${lists}" var="list">
        <c:forEach items="${list}" var="profession">
            <div class="caption">
                <h4>${profession.head}</h4>
            </div>
            <div class="row">
                <c:forEach begin="1" end="3">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="/photo/687.png"></div>
                                <div class="text">
                                    <h4 class="">${profession.name}</h4>
                                    <p class="text-present">${profession.speak}</p>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛
                                        <c:forEach  begin="1" end="${profession.door}">
                                            <img src="/photo/xx.png">
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度
                                        <c:forEach begin="1" end="${profession.easy}">
                                            <img src="/photo/xx.png">
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span class="iconfont-color"></span>${profession.year}年</div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color"></span>${profession.company}家公司需要</div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">${profession.money1}/月</div>
                                    </div>
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">1-3年</div>
                                        <div class="rightWarp-wages">${profession.money2}月</div>
                                    </div>
                                    <div class="rightWarp-class border-bottom">
                                        <div class="rightWarp-year">3-5年</div>
                                        <div class="rightWarp-wages">${profession.money3}/月</div>
                                    </div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <b class="text-b">有${profession.learn}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:${profession.tips}</p>
                            </div>

                            <div class="flip-container">
                                <p class="flip-title">${profession.speak}</p>
                                <p class="flip-text">${profession.tips}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </c:forEach>
</div>


<!--footer-->
<footer class="footer">
    <div class="container height">
        <div class="row">
            <div class="text-left col-sm-4">
                <span>技能树 &mdash; 改变你我</span>
                <p class="bottom">关于我们 | 联系我们 | 合作企业</p>
            </div>
            <div class="text-center col-sm-4">
                <p>旗下网站</p>
                <span>草船云孵化器     最强IT特训营</span>
                <span>葡萄藤轻游戏     桌游精灵</span>
            </div>
            <div class="text-right col-sm-4">
                <p>微信公众号</p>
                <img src="/photo/2524.jpg">
            </div>
        </div>
    </div>

    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com  All Rights Reserved | 京ICP
    </div>
</footer>

</body>
</html>
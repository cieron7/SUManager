<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>学生会信息管理平台</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet" />
    <link type="text/css" href="/css/bootstrap-responsive.css" rel="stylesheet" />
    <link type="text/css" href="/css/bootstrap-theme.min.css" rel="stylesheet" />
    <link type="text/css" href="/css/style.css" rel="stylesheet" />
    <link type="text/css" href="/css/su.css" rel="stylesheet" />

    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>

    <script type="text/javascript" charset="utf-8" src="/js/uedit/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/uedit/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/js/uedit/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<!-- header begin -->
	<div class="header">
        <jsp:include page="common/head.jsp"/>
    </div>
	<!-- header end -->


	<!-- 自定义最大容器 -->
	<div class="home">
		<!-- 轮播图 开始 -->
		<div class="container" style="width: 1000px;padding-right: 0px;padding-left: 0px">

			<div id="carouselcontainter" class="carousel" style="color: #66afe9" align="center">
				<!--<ol class="carousel-indicators">-->
					<!--<li class ="active">1</li>-->
					<!--<li>2</li>-->
					<!--<li>3</li>-->
				<!--</ol>-->
				<div class="carousel-inner">
					<div class="item active"><a href="##"><img src="/images/01.png"></a>
						<!--<div class="carousel-caption">-->
							<!--<h3>我的天啊</h3>-->
							<!--<p>非常漂亮的谁谁谁</p>-->
						<!--</div>-->
					</div>
					<div class="item"><a href="##"><img src="/images/02.png"></a></div>
					<div class="item"><a href="##"><img src="/images/03.png"></a></div>
                    <!--<div class="item"><a href="##"><img src="/images/04.png"></a></div>-->

                </div>
                <a id="left" class="left carousel-control" href="#carouselcontainter" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>

                <a id="right" class="right carousel-control" href="#carouselcontainter" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>

			</div>
		</div>
        <!--轮播图结束-->


        <!--富文本编辑器开始-->
		<div class="main">
			<div class="think">
                <div><script id="editor" type="text/plain" style="width:1000px;height:100px;"></script></div>
                <button id="submit" style="margin-top: 1px" class="btn btn-primary" style="">发送</button>
                <button id="clean" style="margin-top: 1px" class="btn btn-primary" style="">清空内容</button>
            </div>
        </div>
        <!--富文本编辑器结束-->

        <!--主要内容和评论区-->
        <div class="content">
            <span>
                <h1 class="outlinedB">
                    校园学工动态
                </h1>
            </span>
            <!--单个评论-->
            <div class="content-area-display">
                <div class="content-area-inline">
                    <div class="headImg">
                        <img src="/images/headImg/01.jpg" style="width:50px;height:50px;border-radius:inherit"/>
                    </div>
                    <div style="display:inline-block;margin-left:10px">
                        <div>王春花</div>
                        <!--todo 两行显示-->
                        <!--<div>19:30</div>-->

                    </div>

                    <div class="content-info">
                        说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，
                    </div>
                    <!--三个按钮-->
                    <div class="content-icon">
                        <span style="margin-right:580px;font-size:15px">2015年07月06日</span>
                        <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true" style="margin-right:10px"></span>
                        <span class="glyphicon glyphicon-share-alt" aria-hidden="true" style="margin-right:10px"></span>
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                    </div>
                    <!--三个按钮结束-->
                    <hr style="margin-top:5px;margin-bottom:5px;border-top-color:rgb(125, 104, 104)">
                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论展示结束-->

                    <!--评论窗口-->
                    <div contentEditable=true class="comment-area" onclick="show_comment(this)" onblur="hide_comment(this)">
                        <span style="font-size: 15px;">评论</span>
                    </div>
                    <div class="submitComment">
                        <button class="btn btn-info">发表评论</button>
                    </div>
                    <!--评论结束-->
                </div>
            </div>

            <div class="content-area-display">
                <div class="content-area-inline">
                    <div class="headImg">
                        <img src="/images/headImg/01.jpg" style="width:50px;height:50px;border-radius:inherit"/>
                    </div>
                    <div style="display:inline-block;margin-left:10px">
                        <div>王春花</div>
                        <!--todo 两行显示-->
                        <!--<div>19:30</div>-->

                    </div>

                    <div class="content-info">
                        说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@狗京@狗婷说好的去看牙的呢，这是干啥@
                    </div>
                    <!--三个按钮-->
                    <div class="content-icon">
                        <span style="margin-right:580px;font-size:15px">2015年07月06日</span>
                        <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true" style="margin-right:10px"></span>
                        <span class="glyphicon glyphicon-share-alt" aria-hidden="true" style="margin-right:10px"></span>
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                    </div>
                    <!--三个按钮结束-->
                    <hr style="margin-top:5px;margin-bottom:5px;border-top-color:rgb(125, 104, 104)">
                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论区结束-->

                    <!--评论区-->
                    <div class="content-comment">
                        <div class="comment-headImg">
                            <img src="/images/headImg/01.jpg" style="width:35px;height:35px;border-radius:inherit"/>
                        </div>
                        <div style="display:inline-block;margin-left:10px">
                            <div>李二狗&nbsp;&nbsp;:</div>
                            <!--todo 两行显示-->
                            <!--<div>19:30</div>-->

                        </div>
                        <div style="display:inline-block;margin-left:10px;background-color: #9cb930;width: 628px;min-height: 32px;">
                            这个伟大历史胜利，是毛泽东同志和他的战友们，是千千万万革命志士和革命烈士，是亿万中国人民，共同为中华民族建立的伟大历史功勋。这一伟大奋斗历程和成果充分证明了毛泽东同志所说的：“我们中华民族有同自己的敌人血战到底的气概，有在自力更生的基础上光复旧物的决心，有自立于世界民族之林的能力。”
                        </div>
                    </div>
                    <!--评论展示结束-->

                    <!--评论窗口-->
                    <div contentEditable=true class="comment-area" onclick="show_comment(this)" onblur="hide_comment(this)">
                        <span style="font-size: 15px;">评论</span>
                    </div>
                    <div class="submitComment">
                        <button class="btn btn-info">发表评论</button>
                    </div>
                    <!--评论结束-->
                </div>
            </div>


            541564



        </div>
    </div>
	<!-- 自定义容器 end -->



	<!-- footer begin -->
	<!--<div class="footer">-->
		<!--<ul class="list-inline text-center">-->
			 <!--<li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备XXXXXXX号</a></li>-->
			 <!--<li>京公网安备XXXXXXXXXXXXXXXXXX</li>-->
		<!--</ul>-->
	<!--</div>-->
	 <!--footer end -->
</body>
</html>


<script type="text/javascript">
    var ue = UE.getEditor('editor');

    var show_comment = function (obj) {
        var v = $(obj);
        v.empty();
        v.animate({height: "100px"}, "fast");
        v.next().show();
    }
    var hide_comment = function(obj){
        var v = $(obj);
        if(v.html() == ""){
            v.val("评论");
            v.animate({height: "36"},"fast");
            v.next().hide();

        }
    }

    $(function () {
        $("#submit").click(function () {
            var content = UE.getEditor('editor').getContent();
            if (content == "") {
                alert("您还没有填写任何");
                return;
            }
            $.ajax({
                type: 'POST',
                url: url,
                data: {"content": content},
                success: function () {
                    alert("");

                },
                dataType: JSON
            });
            // 清空数据
            UE.getEditor('editor').setContent('');
        });

    });



</script>
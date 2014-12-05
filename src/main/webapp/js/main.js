$(document).ready(function () {

    /* Slide Toogle */
    $("ul.expmenu li > div.header").click(function () {
        var arrow = $(this).find("span.arrow");

        if (arrow.hasClass("up")) {
            arrow.removeClass("up");
            arrow.addClass("down");
        }
        else if (arrow.hasClass("down")) {
            arrow.removeClass("down");
            arrow.addClass("up");
        }

        $(this).parent().find("ul.menu").slideToggle();
    });
});
/**
 *	新消息提醒
 */
(function($){
    $.fn.capacityFixed = function(options) {
        var opts = $.extend({},$.fn.capacityFixed.deflunt,options);

        var FixedFun = function(element) {
            var top = opts.top;
            var right = ($(window).width()-opts.pageWidth)/2+opts.right;
            element.css({
                "right":right,
                "top":top
            });
            $(window).resize(function(){
                var right = ($(window).width()-opts.pageWidth)/2+opts.right;
                element.css({
                    "right":right
                });
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top: 0
                        });
                    } else {
                        element.css({
                            top: scrolls
                        });
                    }
                }else {
                    element.css({
                        position: "absolute",
                        top: top
                    });
                }
            });
            element.find(".close-ico").click(function(event){
                alert("aa");
                element.remove();
                event.preventDefault();
            })
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed.deflunt={
        right : 100,//相对于页面宽度的右边定位
        top:100,
        pageWidth : 960
    };
})(jQuery);
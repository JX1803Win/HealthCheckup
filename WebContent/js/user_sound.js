/*! m.ximalaya.com 25-05-2016 */
!function(a){function b(){PageBase.apply(this,arguments)}b.prototype=a.extend({},PageBase.prototype);var c=a(".list-sound"),d=a(".text-more"),e=new b({url:"/zhubo/more_tracks",uid:d.attr("data-uid")},c,d),f=a(".icon-more"),g=a(".intro");c.on("click","li[data-url]",e.doLocation),c.on("onstop","[sound_id]",function(){c.find(".icon-sound,.icon-playing").removeClass("icon-sound").removeClass("icon-playing")}),c.on("onpause","[sound_id]",function(){c.find(".icon-playing").removeClass("icon-playing").addClass("icon-sound")}),c.on("onplaying","[sound_id]",function(b){a(b.currentTarget).parent().find(".icon:eq(0)").removeClass("icon-sound").addClass("icon-playing")}),e.checkSetOverflow(g)&&(f.removeClass("hidden"),a(".icon-more,.intro").on("click",function(){g.toggleClass("open"),f.toggleClass("open")})),a(".container .btn-dload").unbind("click").on("click",function(){var b=a(this).attr("href"),c=a.cookie("from");c&&a(this).attr("href",e.combineHref(b,{from:c}))}),e.doInit()}($);
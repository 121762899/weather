/**
 * report页面下拉框事件
 */
$(function(){
	$("#selectCityId").change(function(){
		var cityName = $("#selectCityId").val();
		var url = '/report/cityName/'+ cityName;
		window.location.href = url;
	})
});
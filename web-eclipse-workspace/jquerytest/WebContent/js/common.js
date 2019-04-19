/**
 * 
 */
//node js 에서는 require이 가능하지만 
$(function() {	
	var params = {};
	query.substring(1)
		.split('&')
		.forEach(e=>{
			param = e.split("=");
			params[param[0]] = param[1];
		});
	return params;
}); 

location.params = parseParam(location.search);
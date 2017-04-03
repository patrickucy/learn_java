//	this function will be called when loaded 
//	equivalent to window.onload = function(){};
$(function() {
	// equivalent to var obj = document...id('d1'); obj.onclick=function(){};
	$('#d1').click(function(){
		// in event function "this" means the dom node you are binding
		// this.innerHTML = 'hello java';
		$(this).html('hello java again'); // dom --> jquery obj
	});
});
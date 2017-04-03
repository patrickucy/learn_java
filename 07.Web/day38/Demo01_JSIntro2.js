// 间接实现重载
function M () {
	// body...
		alert(arguments[0]);
	switch(arguments.length){
		case 1:
			var n = arguments[0];
			alert(n*n);
			break;
		case 2:
			alert(arguments[0] + arguments[1]);
			break;
	}
}


// 每一定定义的方法,是一个 function对象
function testArray (argument) {
	var array = [12,9,54,7,786];

	// 方式1 
	var f = new Function("x","y","return x-y;");
	array.sort(f);
	alert(array.toString());



	// 方式2 匿名函数
	var array1 = [34,5,123,4,98];

	var f1 = function (x, y) {
		return x - y;
	};

	array1.sort(f1);
	alert(array1.toString());

}

// 模拟简单的计算器
function cal (str) {
	if(str == "="){
		var ex = document.getElementById("txtN").value;
		var r = eval(ex);
		document.getElementById("txtN").value = r;
	}else {
		// 字符串的拼接显示
		document.getElementById("txtN").value += str;
	}
}


function openwin (argument) {
	window.open("http://www.jd.com","www.jd.com");
	// 这里给信窗口起个名字,就不会重复打开了
}

function showTime (argument) {
	var d = new Date();
	document.getElementById("txtTime").value = d.toLocaleTimeString();
}


var timer;
function startClock (argument) {
	timer = window.setInterval(showTime,1000);// 每隔1s做showTime()
}

function stopClock (argument) {
	window.clearInterval(timer);
}


var timer1;
function wait (argument) {
	var f = function(){
		alert("hello");
	}
	timer1 = window.setTimeout(f,5000);
}

function cancelAlert (argument) {
	window.clearTimeout(timer1);
}

function testDOM (argument) {
	var obj = document.getElementById("img1");
	obj.src="images/rose.jpg";

	// 修改段落文本,字体颜色,字体大小
	var pobj = document.getElementById("p1");
	pobj.innerHTML = "what the hell !?";
	pobj.style.color = "red";
	pobj.style.fontSize= "20px";
	pobj.style.backgroundColor = "silver";

	//的到下来框的所有选项
	var sel = document.getElementById("s1");
	var count = 0;
	for (var i = sel.childNodes.length - 1; i >= 0; i--) {
		if( sel.childNodes[i].nodeName == "OPTION"){
			count++;
		}
	};
	alert(count);
}

// 验证用户名
function validName (argument) {
	var str = document.getElementById("txtName").value;
	var reg = /^[a-z]{3,5}$/;
	var spanObj = document.getElementById("nameInfo");;
	if(reg.test(str)){
		spanObj.className = "success";
	} else {
		spanObj.className = "fail";
	}
	return reg.test(str);
}

function validAge (argument) {
	var str = document.getElementById("txtAge").value;
	var reg = /^[0-9]{1,2}$/;
	var spanObj = document.getElementById("ageInfo");;
	if(reg.test(str)){
		spanObj.className = "success";
	} else {
		spanObj.className = "fail";
	}
	return reg.test(str);
}
// 提交时验证所有数据	
function validData (argument) {
	var r1 = validName();
	var r2 = validAge();
	return (r1 && r2);
}

















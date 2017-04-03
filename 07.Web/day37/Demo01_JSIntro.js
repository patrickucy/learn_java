// 这个文件就只能写js代码了,说白了跟css的情况是一样的
function secondMethod () {
	alert("hello in js file");	
}

function getSquare () {
	var s = document.getElementById("txtNumber").value;
	if (isNaN(s)) {
		alert("Please input numbers!");
	}else{
		var n = parseInt(s);
		alert(n*n);
	}
}

// 过滤敏感字符
function replaceString()  {
	// body...
	var str = document.getElementById("txtS").value;
	
	//过滤gcd
	var r = str.replace(/gcd/gi,"*"); //全局,并且忽略大小写
	// 不允许录入数字
	var r = str.replace(/\d/g,"");
	// 不允许录入汉字
	var r = str.replace(/[\u4e00-\u9fa5]/g,"");
	document.getElementById("txtS").value = r;
}

// 实现对数组的操作
function operateArray (argument) {
	// body...
	// 得到录入
	var str = document.getElementById("txtA").value;
	// 拆分数组
	var array = str.split(",");
	// 判断
	switch(argument){
		case 1:
			array.reverse();
			break;
		case 2:
			array.sort();
			break;
		case 3:
			array.sort(sortFunc); // 不用把括号传也带上,函数式编程
			break;
	}
	// 输出
	alert(array.join("|"));
}

// 定义一个方法: 自定义的比较规则
function sortFunc (a,b) {
	return a-b;
}


// 获取随机范围内的整数: 包含下限,不包含上限
function getRandom (min,max) {
	var seed = Math.random();
	var result = Math.floor( seed * (max - min) + min );
	alert(result);
}

// 使用正则表达式对象进行输入的验证
function validName (argument) {
	var str = document.getElementById("txtN").value;
	// var reg = /[a-zA-Z0-9]{3,5}/; // 这里就是只是验证有没有就完事了
	var reg = /^[a-zA-Z0-9]{3,5}$/; // 这里的意思是从开始到结束都只能是3~5个

	if(reg.test(str)){
		alert("OK");
	}else{
		alert("please input again");
	}
}

function testDate (argument) {
	var d = new Date();
	// alert(d.getFullYear());
	// alert(d.getMonth()+1); // month 是从0开始的 0~11的
	// alert(d.toString());
	// alert(d.toLocaleDateString());

	// 弹出10天前的日期,因为现在浏览器就给你查询一定的周期的数据,节省带宽,比如说差消费记录

	d.setDate(d.getDate() - 7);
	alert(d.toLocaleDateString());
	// 这里一定要把月括起来,要不然就会把他当字符串处理了
	alert(d.getFullYear()+"年"+ (d.getMonth()+1) +"月"+d.getDate()+"日");

}
























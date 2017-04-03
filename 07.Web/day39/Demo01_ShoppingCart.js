// 减少文本框中购物的数量
function decreaseNumber (argument) {
	var nodes = argument.parentNode.childNodes;
	for (var i = nodes.length - 1; i >= 0; i--) {
		if(nodes[i].nodeName == "INPUT" && nodes[i].type == "text"){
			
			var count = parseInt(nodes[i].value);
			if(count > 0){
				count--;
			}
			nodes[i].value = count;
		}	
	}
	calPrice();
}

function increaseNumber (argument) {
	var nodes = argument.parentNode.childNodes;
	for (var i = nodes.length - 1; i >= 0; i--) {
		if (nodes[i].nodeName == "INPUT" && nodes[i].type=="text"){

			var count = parseInt(nodes[i].value);
			count++;
			nodes[i].value = count;
		}
	}
	calPrice();
}

function testDOM (argument) {
	var table = document.getElementById("t1");

	// 第二个input的文本
	var array = table.getElementsByTagName("input");
	alert(array);
}


// 计算小计和总计
function calPrice (argument) {
	// 循环表格的所有行(第一行除外)
	// 每一行: 价格和数量
	// 数量: 当前行的第三个单元格中的第二个input
	// 计算小计 --> 写入当前行的第四个单元格
	// 累加小计,写总计

	var table = document.getElementById("t1");
	var rows = table.getElementsByTagName("tr");
	var total = 0;
	for (var i = 1; i < rows.length; i++){
		// 每一行: 价格和数量
		var curRow = rows[i];
		var cells = curRow.getElementsByTagName("td");

		var price = parseFloat(cells[1].innerHTML);
		
		var quan = parseInt(cells[2].getElementsByTagName("input")[1].value);

		var sum = price *quan;
		cells[3].innerHTML = sum.toFixed(2);
		total += sum;
	}
	document.getElementById("totalPrice").innerHTML = total.toFixed(2);
}


function addNewNode (argument) {
	var obj = document.createElement("a");
	obj.href = "http://www.jd.com";
	obj.target = "_blank";
	obj.innerHTML = "click me";
	var form = document.getElementById("f1").appendChild(obj);

	// 需要在按钮之前,也添加一个按钮, button1
	var btn = document.createElement("input");
	btn.type="button";
	btn.value= "button1";
	btn.onclick = function() {
		alert("hello!");
	};
	document.getElementById("f1").insertBefore(btn,document.getElementById("btn1"));
}


// 数组
var array = [
	["please select"],
	["HaiDian","ChaoYang","DongCheng"],
	["LuJiaZhui","PuTuo","JingAn"],
	["PanYu","TianHe","YueXiu","Huangpu"]
];

// 显示下拉框选项
function showCity (argument) {
	// 清空原有的选项数据
	var sel = document.getElementById("s2");
	while(sel.childNodes.length>0){
		sel.removeChild(sel.firstChild);
	}


	// 得到第一个下拉框中的选中的选项
	var i = document.getElementById("s1").selectedIndex; // start with 0

	var cityData = array[i];

	for(var j=0; j<cityData.length; j++){

		var obj = document.createElement("option");
		obj.innerHTML = cityData[j];
		document.getElementById("s2").appendChild(obj);
	}
}


// 模拟JQuery中的封装
function $ (id) {
	return document.getElementById(id);
}

//为表格添加一行
function addProduct (argument) {
	// 标准的DOM操作
	// document.createElement("tr");
	// document.createElement("td");

	// HTML DOM 封装的方式
	var table = $("t2");
	var row = table.insertRow(table.rows.length);
	var cell1 = row.insertCell(0);
	cell1.innerHTML = $("txtName").value;
	var cell2 = row.insertCell(1);
	cell2.innerHTML = $("txtPrice").value;

}

// alter url
function openJD (argument) {
	// location.href = "http://www.jd.com"; // has history

	location.replace("http://www.jd.com"); // no history
}



function enumNavi (argument) {
	var str = "";
	for(var p in navigator){
		str += p +":"+ navigator[p] + "\n"; // navigator[p] 是取值操作
	}
	alert(str);
}



// 为父div元素定义 onclick 事件
function cal (argument) {
	// 得到点击的对象: 只关心点击按钮所引发的
	var obj = argument.srcElement || argument.target; // 这里是高级语言是不可能实现的
	if (obj.nodeName == "INPUT" && obj.type == "button") {

		if(obj.value == "="){
			var ex = $("txtN").value;
			$("txtN").value = eval(ex);
		}else {
			$("txtN").value += obj.value;
		}
	};
}


















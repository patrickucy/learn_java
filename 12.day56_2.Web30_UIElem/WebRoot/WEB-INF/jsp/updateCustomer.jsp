<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>DEMO Struts2 UI tags</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>simulate struts 2 UI tags technology</h1>
    
    <%-- 1. form tag, (understand) --%>
    <%--  ><s:form action="#" method="post" theme="simple">  可以去掉内置的table  --%>
    
    <s:form action="#" method="post">
    
    	<%-- 2. submit button, (understand) --%>
    	<s:submit value="submit"></s:submit>
    	
    	<%-- 3. text box tag:
    			a. generate a text box
    			b. name property is to write OGNL expression, struts2 
    			will parse tag, and access value via OGNL expression, and 
    			generate a input text box with value property
    	 --%>
    	<s:textfield name="customer.name" label="Name"></s:textfield>
    	
    	
    	<%-- 4. password box: just like above --%>
    	<s:password name="customer.password" label="Password" showPassword="true"></s:password>
    	
    
    	<%-- 5. text area --%>
    	<s:textarea name="customer.desc" label="Description" cols="30" rows="5"></s:textarea>
    	
    	<%-- 6.
    		a. single choice check box
    		b. bname here is also a OGNL expression, struts2 will check it when the property is true
    		c. this property must be boolean type
    	 --%>
    	<s:checkbox name="customer.marry" label="Marry status" labelposition="left" ></s:checkbox>
    
    
    	<%-- 7. single choice radio 
    		OGNL to create a map data structure
    		1. list property help us generate radio, the value of that list is an ONGL map, struts2
    		will generate radio according to our key-value map.
    		2. when you submit your form, the value of this list will be sent to server, not the labeled name 
    		3. name 属性是给单选框勾选默认值的, struts2根据name属性中写的OGNL取值,并根据返回的结果与生成若干radio匹配,
    		若某个radio的value与OGNL取值一致,那就将这个radio默认勾选
    		下面的是静态范围
    	--%>
    	<s:radio name="customer.sex" list="#{'M':'Male','F':'Female'}" label="sex"></s:radio>
    	
    	<%-- 8. 单选框动态范围
    		a. list 属性用于生成选择范围, lsit的size 是几就生成几个radio, listKey用于指定生成radio时value属性对应的取值字段, 
    		listValue用于指定生成radio时label显示值对应的字符按
    		b. name属性用于给单选框选中默认值, 根据name属性中的OGNL表达式取值, ,struts2会自动根据返回值, 来遍历所有生成的radio,哪个radio
    		的value值与表达式返回值对应,就勾选哪个radio
    	 --%>
    	<s:radio label="Favorite City" name="customer.loveCity" list="cities" listKey="code" listValue="name"></s:radio>
    	
    	
    	<%-- 9. 复选框
    		a. 用于生成一组checkbox, 集合中有几个值就生成几个checkbox
    		b. 参考radio 
    		c. name中指定的OGNL 表达式,对应的Action中的属性,应该是集合
    	 --%>
    	<s:checkboxlist label="Travel Cities" name="customer.travelCities" list="cities" listKey="code" listValue="name"></s:checkboxlist>
    	
    	
    	<%-- 10. 下拉选
    		a. 用于生成一个下拉选, list属性用于生成下拉选的所有option,listKey用于生成option的value值, listValue用于生成option显示值
    		b. name属性用于给下拉选选中一个默认的值, name写的是OGNL表达式, struts2会自动根据该表达式取值,并根据结果遍历所有的option,哪个
    		option的value值与表达式返回值一致,就将此option选中
    		c. 可以通过headerKey, headerValue生成一个空的option.
    	 --%>
    	<s:select label="Home" name="customer.home" list="cities" listKey="code" listValue="name" headerKey="-1" headerValue="--请选择--"></s:select>
    	
    </s:form> 
    
    
    
  </body>
</html>
















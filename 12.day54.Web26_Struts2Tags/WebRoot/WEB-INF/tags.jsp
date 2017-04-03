<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Struts2 tag demo</title>
    
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
    <h1>Struts tag demo</h1> <br>
    <h1>*1. output basic type data</h1>
    <h2>ID: <s:property value="id"/></h2>
    <h2>name: <s:property value="name"/></h2>
    
    <br/>
    <h1>*2. output properties of an object</h1>
    <h2>Username: <s:property value="user.username"/> </h2>
    <h2>Password: <s:property value="user.password"/> </h2>
    
    <br/>
    <h1>3. output array and collection </h1>
    <h2>Collection: <s:property value="cities[0]"/> </h2>
    <h2>Array: <s:property value="langs[1]"/> </h2>
    
    
    <br/>
    <h1>4. output Map type data</h1>
    <h2>Map: <s:property value="map.ccc"/></h2>
    
    <br/>
    <h1>5. output and do computation simultaneously </h1>
    <h2>ID+3: <s:property value="id+3"/></h2>
    <h2>Hello, Name: <s:property value="'hello, '+name"/></h2>
    
    <br/>
    <h1>6. output and call method simultaneously </h1>
    <h2>NAME: <s:property value="name.toUpperCase()"/></h2>
    
    <br/>
    <h1>7. create collection data and output </h1>
    <h2>Create collection: <s:property value="{1,2,3,4,5}"/></h2>
    <h2>Collection type: <s:property value="{1,2,3,4,5}.getClass().getName()"/></h2>
    
    <br/>
    <h1>8. create map data and output </h1>
    <h2>Create Map: <s:property value="#{'vv':'VV','cc':'CC','dd':'DD' }"/></h2>
    <h2>Map type: <s:property value="#{'vv':'VV','cc':'CC','dd':'DD' }.getClass().getName()"/></h2>
    
    
  </body>
</html>

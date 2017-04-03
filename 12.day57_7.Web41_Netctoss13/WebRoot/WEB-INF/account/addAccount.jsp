<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="../js/jquery-1.4.3.js"></script>       
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

            //显示选填的信息项
            function showOptionalInfo(imgObj) {
                var div = document.getElementById("optionalInfo");
                if (div.className == "hide") {
                    div.className = "show";
                    imgObj.src = "../images/hide.png";
                }
                else {
                    div.className = "hide";
                    imgObj.src = "../images/show.png";
                }
            }
            
            // 校验身份证
            function checkIdcardNo(idCardNo) {
				// 1. 是否为空
				if(idCardNo == ""){
					$("#idcardNoMsg").text("身份证不能为空");
					return;
				}
				
				// 2. 校验身份证号格式
				var reg = /^\d{15}|\d{18}$/; // 工作后,公司会告诉你用哪些,不需要记
				if(!reg.test(idCardNo)){
					// 校验不通过
					$("#idcardNoMsg").text("身份证号格式错误");
					return;
				}
				
				
				// 3. 从身份证中提取生日,给生日字段赋值
				// 123456 19930627 7890 --> 1993-06-27
				var year = idCardNo.substring(6,10);
				var month = idCardNo.substring(10,12);
				var day = idCardNo.substring(12,14);
				var birthday = year+"-"+month+"-"+day;
				$("#birthday").val(birthday);
				
				// 4.  重置提示信息
				$("#idcardNoMsg").text("正确的身份证格式")
			}
			
			
			function checkRecommender(recommenderIdcardNo) {
				// 由于该字段允许为空,那么参数为空时,不做处理
				if(recommenderIdcardNo == ""){
					return;
				}
				//如果不为空,先校验格式
				var reg = /^\d{15}|\d{18}$/; // 工作后,公司会告诉你用哪些,不需要记
				if(!reg.test(recommenderIdcardNo)){
					// 校验不通过
					$("#recommenderMsg").text("身份证号格式错误");
					return;
				}
				// 如果校验通过,异步查询对应的推荐人信息
				$.post(
					"searchRecommender.action",{"idcardNo":recommenderIdcardNo},
					function(data) {
						// 返回值就是account对象
						var account = data;
						if(account == null){
							// 说明没找到,或者发生异常
							$("#recommenderMsg").text("找不到对应的推荐人");
						}else {
							// 如果找到了推荐人数据,将其id值存入隐藏文本框中去
							 $("#recommenderId").val(account.id);
						 	// 重置提示信息
						 	$("recommenderMsg").text("正确的身份证号码格式");
						}
					}
				);
				
			}
			
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="../account/account_list.html" class="account_on"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">       
            <!--保存成功或者失败的提示消息-->     
            <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
            <form action="addAccount.action" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                	<!-- struts 标签这里不需要用到回显功能 -->
                    <input type="text" name="account.realName" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">20长度以内的汉字、字母和数字的组合</div>
                </div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" name="account.idcardNo" onblur="checkIdcardNo(this.value)" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="idcardNoMsg">正确的身份证号码格式</div>
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                
                <div class="input_info">
                    <input type="text" name="account.loginName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="account.loginPasswd"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>     
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="account.telephone"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium">正确的电话号码格式：手机或固话</div>
                </div>                
                <!--可选项-->
                <div class="text_info clearfix"><span>可选项：</span></div>
                <div class="input_info">
                    <img src="../images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
                </div>
                <div id="optionalInfo" class="hide">
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <input type="text" onblur="checkRecommender(this.value);"/>
                        <input type="hidden" name="account.recommenderId" id="recommenderId" />
                        <div class="validate_msg_long" id="recommenderMsg">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <input type="text" name="account.birthdate" id="birthday" class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" name="account.email"/>
                        <div class="validate_msg_tiny">50长度以内，合法的 Email 格式</div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <select name="account.occupation">
                        	<option>--请选择--</option>
                            <option value="0">干部</option>
                            <option value="1">学生</option>
                            <option value="2">技术人员</option>
                            <option value="3">其他</option>
                        </select>                        
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                        <input type="radio" name="account.gender" checked="checked" id="female"  value="0"/>
                        <label for="female">男</label>
                        <input type="radio" name="account.gender" id="male" value="1"/>
                        <label for="male">女</label>
                    </div> 
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" name="account.mailaddress"/>
                        <div class="validate_msg_tiny">50长度以内</div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <input type="text" name="account.zipcode" />
                        <div class="validate_msg_long">6位数字</div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <input type="text" name="account.qq"/>
                        <div class="validate_msg_long">5到13位数字</div>
                    </div>                
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"  />
                    <input type="button" value="取消" class="btn_save" onclick="window.history.go(-1)" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>

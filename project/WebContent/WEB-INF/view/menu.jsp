<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/ext-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/ext-locale-zh_CN.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-2.0.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/ext/theme-triton/resources/theme-triton-all.css">
<script type="text/javascript">
Ext.onReady(function(){
	var width=$(window).width();
	var height=$(window).height();
	var path='<%=request.getContextPath()%>';
	var store=Ext.create('Ext.data.Store',{
	    storeId:'simpsonsStore',
	    fields:['id', 'title', 'parentNode','code', 'haveChild', 'link', 'rank', 'dateCreated','lastUpdated'],
	    pageSize:20,
	    autoLoad: true,
	    proxy: {
	        type: 'ajax',
	        url:path+'/index/menu',
	        reader: {
	            type: 'json',
	            root: 'data',
	        }
	    }
	});

	Ext.create('Ext.grid.Panel', {
	    store: store,
	    width:width,
	    selModel: { selType: 'checkboxmodel',singleSelect:true }, //选择框,并设置只能单选
	    forceFit:true,//使列自适应比例宽度
	    columns: [
	        { header: 'ID',  dataIndex: 'id' },
	        { header: '标题', dataIndex: 'title' },
	        { header: '节点标识', dataIndex: 'code' },
	        { header: '父节点标识', dataIndex: 'parentNode' },
	        { header: '是否有子节点', dataIndex: 'haveChild' },
	        { header: '链接', dataIndex: 'link' },
	        { header: '等级', dataIndex: 'rank' },
	        { header: '创建时间', dataIndex: 'dateCreated' },
	        { header: '最后更新时间', dataIndex: 'lastUpdated' },
	    ],
	    tbar:[
	          {
	        	  xtype: 'button', text: 'Button 1',iconCls: "saveIcon",handler:function(){menuAdd()}
	          }
	          ],
	   
	    renderTo: "body"
	});
	function menuAdd(){
		 var menuForm=Ext.create("Ext.form.Panel",{
			
			    bodyPadding: 5,
			    width: 350,

			    // 将会通过 AJAX 请求提交到此URL
			    url: 'save-form.php',

			    // 表单域 Fields 将被竖直排列, 占满整个宽度
			    layout: 'anchor',
			    defaults: {
			        anchor: '100%'
			    },

			    // The fields
			    defaultType: 'textfield',
			    items: [{
			        fieldLabel: '菜单名称',
			        name: 'title',
			        allowBlank: false
			    },{
			        fieldLabel: '菜单code',
			        name: 'code',
			        allowBlank: false
			    },{
			    	xtype:"combo",
			    	fieldLabel:"菜单层级",
					store:Ext.create('Ext.data.Store',{
						fields:["text","value"],
						data:[
						      {text:"一级菜单",value:"1"},
						      {text:"二级菜单",value:"2"}
						      ],
					}),
					valueField:"value",
					displayField:"text",
			    }],

			    // 重置 和 保存 按钮.
			    buttons: [{
			        text: '重置',
			        handler: function() {
			            this.up('form').getForm().reset();
			        }
			    }, {
			        text: '保存',
			        formBind: true, //only enabled once the form is valid
			        disabled: true,
			        handler: function() {
			            var form = this.up('form').getForm();
			            if (form.isValid()) {
			                form.submit({
			                    success: function(form, action) {
			                       Ext.Msg.alert('保存成功', action.result.msg);
			                    },
			                    failure: function(form, action) {
			                        Ext.Msg.alert('操作失败', action.result.msg);
			                    }
			                });
			            }
			        }
			    }],
		}); 
		var menuWin=Ext.create('Ext.window.Window',{
			title:"添加菜单",
			width:400,
			height:450,
			layout: 'fit',
			items:[menuForm]
		});
		menuWin.show();
	}
});

</script>
<title>Insert title here</title>
</head>
<body id="body">

</body>
</html>
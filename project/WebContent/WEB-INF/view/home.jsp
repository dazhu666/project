<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/ext-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext/ext-locale-zh_CN.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-2.0.3.min.js"></script> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/ext/theme-triton/resources/theme-triton-all.css">
  <script type="text/javascript">
  Ext.onReady(function(){
	  //获取浏览器的高度
	  var height=$(window).height();
	  //获取浏览器宽度
	  var width=$(window).width();
	  Ext.create('Ext.panel.Panel',{
		  height:height*0.1,
		  width:width,
		  renderTo:"top",
		  bodyStyle:'background:#5fa2dd;border:0;',
	  });
	  
	  var store = Ext.create('Ext.data.TreeStore', {
		    root: {
		        expanded: true,
		        children: [
		            { text: "detention", leaf: true },
		            { text: "homework", expanded: true, children: [
		                { text: "book report", leaf: true },
		                { text: "alegrbra", leaf: true}
		            ] },
		            { text: "buy lottery tickets", leaf: true }
		        ]
		    }
		});

		var treepane=Ext.create('Ext.tree.Panel', {
		    title: 'Simple Tree',
		    width: 200,
		    height: 150,
		    store: store,
		    rootVisible: false,
		});
	  Ext.create('Ext.panel.Panel', {
		    title: '菜单',
		    width: 300,
		    autoScroll:true,
		    height:height*0.9-5,
		    
		    defaultMargins:{
		    	bottom:500
		    },
		    layout: {
		        // layout-specific configs go here
		        type: 'accordion',
		        titleCollapse: true,
		        animate: true,
		    },
		    items: [{
		        title: 'Panel 1',
		        
		        
		    },{
		        title: 'Panel 2',
		        html: 'Panel content!'
		    },{
		        title: 'Panel 3',
		        html: 'Panel content!'
		    },treepane],
		    renderTo: "left"
		});
	  
	  Ext.create('Ext.panel.Panel',{
		  title:"主界面",
		  width:width-305,
		  height:height*0.9-5,
		  renderTo:"center",
		  html: '<iframe id="frame1" src="" frameborder="0" width="100%" height="100%"></iframe>'
		  
	  });
  });
  </script>
</head>
<body>
<div>
<div id="top" style="height: 10%;"></div>
<div id="left" style="width:300px;background: green;margin-top:5px;clear: both;float:left;"></div>
<div id="center" style="float: right; height: 300px;background: green;margin-left:5px;margin-top:5px;"></div>
</div>
</body>
</html>
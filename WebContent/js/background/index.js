var MoniterIndex = function(config) {
    var self = this;
   
    var showTreeSelectData = function () {
        $.ajax({
            url: 'systemAction/getAllRole.action',
            method: 'get',
            dataType: 'json',
            contentType: "application/json",
            success: function (data) {
            	console.log(1111);
                console.log(data);
                var datas = {};
                for (var i = 0; i < data.length; i++) {
                    datas.i = i+1;
                    datas.rolename = data[i].rolename;
                    datas.createTime = data[i].createTime;
                    datas.roleDescription = data[i].roleDescription;
                    var source = $("#treeSelect-template").html();
                    var template = doT.template(source);
                    var htmlstr = template(datas);
                    $("#treeSelectBody").append(htmlstr);
                }

            },
            error: function (res) {
                console.log(res);
            }
        });

       

    }


    self.initData = function () {
        showTreeSelectData(); 
    }
   







}


$(function() {
    window.monitorIndex = new MoniterIndex();
    monitorIndex.initData();
});


$(function () {
    $("#treeSelectBody").on('click', '.grantAuthorityBtn', function () {
    	var userName = $(this).parents('tr').find('td').eq(1).text();
    	var curWWWPath=window.document.location.href;
    	var pathName=window.document.location.pathname;
    	var pos=curWWWPath.indexOf(pathName);
    	var localhostPath=curWWWPath.substring(0,pos);
    	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    	var roleBean;
    	
        $.ajax({       	
        url:localhostPath+projectName+"/role/permissionsMagr.action",
        data:"userName="+userName,	       
        dataType:"json",
		type:"POST",	
        success:function(redata){
        	
            var html ='<select id="authorifyselect" name='+userName+' multiple="multiple">' ;       	
        	var AllF=redata.a1;//获得所有菜单List
        	var AllS=redata.a2;//获得所有父类菜单List
        	var AllFofRole=redata.a3;//获得当前角色的所以List
        	var AllSofRole=redata.a4;//获得当前角色的所有父类List     	
        	for(var i=0;i<AllF.length;i++){
        		for(var j=0;j<AllS.length;j++){
        			var fag=false;
        			if(AllF[i].preMenu==AllS[j].permissionsId){//这里就可以获得全部的菜单，包括父类、子类
        				       				
        				for(var k=0;k<AllFofRole.length;k++){
        	        		for(var m=0;m<AllSofRole.length;m++){
        	        			if(AllFofRole[k].rolePermissionsBean.pibList[0].preMenu==AllSofRole[m].rolePermissionsBean.pibList[0].permissionsId){//这里可以获得全部角色下的菜单
        	        				if(AllF[i].permissionsId==AllFofRole[k].rolePermissionsBean.pibList[0].permissionsId){//这里就是显示所有勾选的菜单
        	        					fag=true;       	        				
         	    					    html+="<option  value='"+AllF[i].permissionsId+"'data-section= " +
         	    					    		"='"+AllS[j].menuName+"' selected>"+" "+AllF[i].menuName+" "+"</option>";     	        						
        	        						
        	        				}
        	        				
        	        			}
        	        		}
        	        	}
        			 if(fag){
          				   break;
          			   }else{
          				   html+="<option  value='"+AllF[i].permissionsId+"' data-section='"+AllS[j].menuName+"'>"+" "+AllF[i].menuName+" "+"</option>";
          			   }
        				
        				
        			}
        		}
        	}
        	
        	html+='<select>';
            $("#authorityBody").empty().append(html);
            $("#authorifyselect").treeMultiselect({ searchable: true, hideSidePanel: true });
            $("#AuthorityTitle").text("给 " + userName + " 分配权限");
            $("#grantAuthorityModal").modal('show');	
        	
        	
        }
        })
    	
    	
    	
    	
    	
    	
    	
    });
	

			 
	$('#authoritysubmit').click(function(){
    alert('AA');
		$('select :selected').each(function() {
	console.log($(this).val());
	});
})
})

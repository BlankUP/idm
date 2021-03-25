$(document).ready(function() {
	var grid_selector = "#auth-grid-table";
	var pager_selector = $("#auth-grid-pager");
	var roleNo = $('#userBody').data("roleNo");
	
	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '用户ID', '用户名','状态','创建时间','创建人' ],
		colModel:[
					{
						sortable:false,
						name : 'userId',
						index : 'userId',
						width : 100
					}, {
						sortable:false,
						name : 'userName',
						index : 'userName',
						width : 100
						
					}, {
						sortable:false,
						name : 'userStatus',
						index : 'userStatus',
						width : 100,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==1){
								return "<span>有效</span>";
							}else if(cellvalue==0){
								return "<span>无效</span>";
							}
						}
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100
					}
					],
		viewrecords : true,
		rowNum:10,
		pager : pager_selector,
		altRows: true,
        loadComplete : function() {
        	var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		},
		caption: "角色用户查看",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/role_viewUsers_data.do?roleNo=' + roleNo,
	    datatype : "json"
	}).trigger("reloadGrid");
});

//调整分页图标
function updatePagerIcons(table) {
		var replacement = 
		{
			'ui-icon-seek-first' : 'fa fa-angle-double-left',
			'ui-icon-seek-prev' : 'fa fa-angle-left',
			'ui-icon-seek-next' : 'fa fa-angle-right',
			'ui-icon-seek-end' : 'fa fa-angle-double-right'
		};
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
			if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
		});
}

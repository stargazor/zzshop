<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="tb"></table>
<script>

    var toolbar=[{iconCls: 'icon-add',
        text:'增加',
        handler: function(){alert('编辑按钮')}
    },{iconCls: 'icon-remove',
        text:'删除',
        handler: function(){
            var selectedRows=$("#tb").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("提示","请至少选中一条记录");
                return;
            }
            $.messager.confirm("确认","您确认想要删除记录吗？",function(r){
                var ids=[];
                if(r){
                    for(var i=0;i<selectedRows.length;i++) {
                        ids.push(selectedRows[i].id);
                    }
                    $.post(
                        "items/batchRemove",
                        {'ids[]':ids},
                        function (data) {
                            $("#tb").datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    },{iconCls: 'icon-edit',
        text:'编辑',
        handler: function(){alert('编辑按钮')}
    },{iconCls: 'icon-up',
        text:'上架',
        handler: function(){
            var selectedRows=$("#tb").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert('提示','请至少选中一条记录');
                return;
            }
            $.messager.confirm('确认','您确认要上架选中商品？',function (r) {
               if(r){
                   var ids=[];
                   for(var i=0;i<selectedRows.length;i++){
                       ids.push(selectedRows[i].id);
                   }
                   $.post(
                       'items/batchUp',
                       {'ids[]':ids},
                       function(data){
                           $("#tb").datagrid("reload");
                       },
                       'json'
                   );
               }
            });
        }
    },{iconCls: 'icon-down',
        text:'下架',
        handler: function(){
            var selectedRows=$("#tb").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert('提示','请至少选中一条记录');
                return;
            }
                $.messager.confirm('确认','您确认要下架选中商品？',function (r) {
                    if(r){
                        var ids=[];
                        for(var i=0;i<selectedRows.length;i++){
                            ids.push(selectedRows[i].id);
                        }
                        $.post(
                            'items/batchDown',
                            {'ids[]':ids},
                            function(data){
                                $("#tb").datagrid("reload");
                            },
                            'json'
                        );
                    }
                });
            }
    }];


    $("#tb").datagrid({
        toolbar:toolbar,
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url: 'items',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20,50,100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100,sortable:true},
            {field: 'title', title: '商品名称', width: 100,sortable:true},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'priceView', title: '价格', width: 100},
            {field: 'statusName', title: '状态', width: 100},
            {field: 'updated', title: '更新时间', width: 100,formatter:function (value,row,index) {
                return moment(value).format('LL');
            }},
            {field: 'createdString', title: '创建时间', width: 100}
        ]]
    });
</script>

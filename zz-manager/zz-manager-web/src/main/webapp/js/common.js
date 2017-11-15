
var zzshop = {

    registerMenuEvent:function(){
        var $tree = $('#menu .easyui-tree');
        var _this=this;
        //将当前树打印到控制台
        //console.log($tree);
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
//                debugger;
                _this.addTab(text,href);
            }
        });
    },

    addTab:function(title,href){
        if($("#tab").tabs('exists',title)){
            $("#tab").tabs('select',title);
        }else {
            $('#tab').tabs('add',{
                title: title,
                href: href,
                closable:true
            });
        }
    }

};





var ddshop = {

    registerMenuEvent:function(){
        var $tree = $('#menu .easyui-tree');
        //将当前树打印到控制台
        //console.log($tree);
        $tree.tree({
            onClick:function(node){
                var href = node.attributes.href;//item-add
                var text = node.text;
//                debugger;
                $('#tab').tabs('add',{
                    title: text,
                    href: href,
                    closable:true
                });
            }
        });
    }

};




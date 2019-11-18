function $root(){
    var curWwwPath = window.document.location.href;
    var pathName =  window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPaht = curWwwPath.substring(0,pos);
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return (localhostPaht + projectName);
}

function loadPage(url, target) {
    if (!target) {
        if ($("#_default_load_target").length) {
            target = $("#_default_load_target");
            target.empty();
        } else {
            $('<div id="_default_load_target" style="display:none"></div>').appendTo('body');
            target = $("#_default_load_target");
        }
    }
    target.load(url);
}
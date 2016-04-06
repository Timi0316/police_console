//分页
function previewPage(formId,url) {
    var pageNum = $("#pageNum").val();
    if(pageNum <= 1) {
        return;
    }
    $("#"+formId).attr("action",url);
    $("#pageNum").val(Number(pageNum)-1);
    $("#"+formId).submit();
}

function specificPage(specific,formId,url) {
    var pageNum = $("#pageNum").val();
    if(pageNum == specific) {
        return;
    }
    $("#"+formId).attr("action",url)
    $("#pageNum").val(specific);
    $("#"+formId).submit();
}

function nextPage(size,formId,url) {
    var pageNum = $("#pageNum").val();
    if(pageNum >= size) {
        return;
    }
    $("#"+formId).attr("action",url)
    $("#pageNum").val(Number(pageNum)+1);
    $("#"+formId).submit();
}
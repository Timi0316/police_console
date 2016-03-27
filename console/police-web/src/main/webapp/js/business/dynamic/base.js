/**
 * 获取文件的url
 * 用于上传图片预览
 * @param sourceId
 * @returns {*}
 */
function getFileUrl(sourceId) {
    var url;

    if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
        url = document.getElementById(sourceId).value;
    } else if(navigator.userAgent.indexOf("Trident") > 0){// IE
        url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    }else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
        url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
        url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    }
    return url;
}

function addImage(sourceId,imgId) {
    var url = getFileUrl(sourceId);
    $("#"+imgId).attr("src", url);
}
function addDynamic(url) {
    location.href=url;
}

function editDynamic(url,id) {
    location.href = url + "?id=" + id;
}

function deleteDynamic(url,id) {
    location.href = url + "?id=" + id;
}

function previewDynamic(url,id) {
    location.href = url + "?id=" + id;
}
$(document).ready(function (e) {
    var target = $('a.link-detail');
    var len = target.length;
    for (var i = 0; i < len; i++) {
        var link = '/index/' + target.eq(i).text() + '/detail';
        target.eq(i).attr("href", link);
    }
});
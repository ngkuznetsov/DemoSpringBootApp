"use strict";

function hide() {
    $("#fail").fadeOut();
    $("#success").fadeOut();
}

function createThreads(count) {
    var url = window.location.href;
    url += "/createThreads" + "?threadCount=" + count;
    makeGetRequest(url);
}

function gc() {
    var url = window.location.href;
    url += "/gc";
    makeGetRequest(url);
}

function makeGetRequest(url) {
    hide();
    $.ajax({
        url: url,
        method: "GET"
    })
        .done(function() {
            $("#success").fadeIn();
        })
        .fail(function() {
            $("#fail").fadeIn();
        });
}
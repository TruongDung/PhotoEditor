"use strict";

$(function() {

    function redirectToEditor() { // currentLoadMethod for onAuthStateChanged event
        $(location).attr('href', 'editor');
    }

    if (!photoEditorApp.currentPage && !photoEditorApp.currentLoadMethod) {
        photoEditorApp.currentPage = this;
        photoEditorApp.currentLoadMethod = redirectToEditor;
    }

    $("#signInFB").on("click", function() {

        var provider = new firebase.auth.FacebookAuthProvider();
        provider.addScope("publish_actions");
        firebase.auth().signInWithPopup(provider).then(function(result) {
            var fbToken = result.credential.accessToken;
            photoEditorApp.fbToken = fbToken;
            $(".spinning-loader-container").hide();
        }).catch(function(error) {
            $(".spinning-loader-container").hide();
            $.notify({
                message: error
            }, {
                type: 'danger',
                allow_dismiss: true,
                mouse_over: "pause",
                delay: 1000
            });
        });

    });

});
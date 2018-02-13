"use strict";

// Dependencies: 
//  - jQuery ($)
//  - FB

var FacebookConnector = (function() {

    var accessToken = "";

    function dataURItoBlob(dataURI) {

        var byteString = atob(dataURI.split(',')[1]);
        var ab = new ArrayBuffer(byteString.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < byteString.length; i++) {
            ia[i] = byteString.charCodeAt(i);
        }

        //return new Blob([ab], { type: 'image/jpeg' });
        return new Blob([ia], {
            type: 'image/jpeg'
        });
    }

    var getLoginStatus = function(callback) {
        FB.getLoginStatus(callback);
    };

    var setAccessToken = function(token) {
        accessToken = token;
    }

    var loginCallback = function(response) {
        setAccessToken(response.authResponse.accessToken);
        if (typeof clientLoginCallback !== "undefined" && clientLoginCallback) {
            clientLoginCallback(response);
        }
    };

    var clientLoginCallback;

    var login = function(callback) {
        clientLoginCallback = callback;
        FB.login(loginCallback, {
            scope: 'email, publish_actions'
        });
    };

    var logout = function(callback) {
        FB.logout(callback);
    };

    var getUserData = function(callback) {
        FB.api('/me', {
                locale: 'en_US',
                fields: 'id, first_name, last_name, email, link, gender, locale, picture'
            },
            callback
        );
    };

    var postImage = function(dataImage, callbackFunc, failFunc) {

        var blob;
        try {
            blob = dataURItoBlob(dataImage);
        } catch (e) {
            console.log(e);
        }
        var fd = new FormData();
        fd.append("access_token", accessToken);
        fd.append("source", blob);
        try {
            $.ajax({
                url: "https://graph.facebook.com/me/photos?access_token=" + accessToken,
                type: "POST",
                data: fd,
                processData: false,
                contentType: false,
                cache: false,
                success: function(data) {
                    //alert("Success");
                    console.log(data);
                    if (callbackFunc) {
                        callbackFunc();
                    }
                },
                error: function(shr, status, data) {
                    //alert("error " + data + " Status " + shr.status);
                    console.log("error " + shr.responseText + " Status " + shr.status);
                    if (failFunc) {
                        failFunc();
                    }
                }
            });
        } catch (e) {
            console.log(e);
        }
    };

    return {
        getAccessToken: function() {
            return accessToken;
        },
        setAccessToken: setAccessToken,
        getLoginStatus: getLoginStatus,
        login: login,
        logout: logout,
        getUserData: getUserData,
        postImage: postImage
    };

})();
'use strict';

var popup = (function() {

    var self;

    function init() {

        self = this;

        $('figure').click(function() {
            self.currentFigure = this;
            self.open($(this));
        });

        $(document).on('click', ".popup #downloadImg", function(event) {
                event.stopPropagation(); // do not bubble it in DOM tree, so normal behavior of download button is maintained
            })
            .on('click', '.popup #figPopup', function(event) {
                //return false; // prevent default and stop propagation, don't close the pop-up
            	event.stopPropagation();
            })
            .on('click', '.popup', function() {
                self.close();
            }).on('click', '.popup #deleteImgIcon', function(e, f) {
                var id = this.getAttribute("data-value");
                self.deleteImg(id);
            });

        $(document).on("click", "#shareImgIcon", function() {
            $(".spinning-loader-container").show();
            FacebookConnector.setAccessToken(photoEditorApp.fbToken);
            FacebookConnector.postImage(createCanvasImageData("imgPopup"), postImageCallback, postImageFail);
        });

        function postImageCallback() {
            $(".spinning-loader-container").hide();
            $.notify({
                message: 'Posted Successfully'
            }, {
                type: 'success',
                allow_dismiss: true,
                mouse_over: "pause",
                delay: 1000,
                z_index: 10000
            });
        }

        function postImageFail() {
            $(".spinning-loader-container").hide();
            $.notify({
                message: 'Error'
            }, {
                type: 'danger',
                allow_dismiss: true,
                mouse_over: "pause",
                delay: 1000,
                z_index: 10000
            });
        }
    }

    function open(figure) {
        var popup = $('<div class="popup" />').appendTo($('body'));
        var fig = figure.clone().appendTo($('.popup'));
        fig.attr("id", "figPopup");
        var shadow = $('<div class="shadow" />').appendTo(fig);
        var img = $('img', fig);
        var src = img.attr('src');
        img.attr("id", "imgPopup");
        shadow.css({
            backgroundImage: 'url(' + src + ')'
        });
        setTimeout(function() {
            $('.popup').addClass('pop');
        }, 10);
    }

    function close() {
        $('.gallery, .popup').removeClass('pop');
        setTimeout(function() {
            $('.popup').remove()
        }, 100);
    }

    function deleteImg(id) {
    	
    	var data = {
            "userId": photoEditorApp.userId,
            "token": photoEditorApp.token,
            "id": id,
            "action": "DELETE"
        };
    	
        $.post("photo", data)
            .done(function(response) {
                self.close();
                $.notify({
                    message: 'Delete image Successfully'
                }, {
                    type: 'success',
                    allow_dismiss: true,
                    mouse_over: "pause",
                    delay: 1000
                });
                setTimeout(function() {
                    self.currentFigure.remove();
                }, 10);
            })
            .fail(function(xhr, textStatus, errorThrown) {
                console.log("Error delete image: " + errorThrown);
            });
    }

    return {
        init: init,
        open: open,
        close: close,
        deleteImg: deleteImg
    }
})();

popup.init();


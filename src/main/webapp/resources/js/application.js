// Application variables that are global to all pages
if (!photoEditorApp) {
    var photoEditorApp = {
        userId: null,
        token: null,
        curPhotoId: null,
        curUser: null,
        fbToken: null,
        clear: function() {
            this.userId = null;
            this.token = null;
            this.curPhotoId = null;
            this.curUser = null;
            this.fbToken = null;
        }
    };
}


if (!photoEditorApp.defaultValues) {
    photoEditorApp.defaultValues = {
        "blur": 0,
        "brightness": 100,
        "contrast": 100,
        "grayscale": 0,
        "hueRotate": 0,
        "invert": 0,
        "opacity": 100,
        "saturate": 100,
        "sepia": 0
    };
}

if (!photoEditorApp.presets) {
    photoEditorApp.presets = {
        "willow": {
            "brightness": 120,
            "contrast": 85,
            "saturate": 2,
            "sepia": 2
        },
        "walden": {
            "brightness": 110,
            "contrast": 90,
            "saturate": 150,
            "sepia": 35,
            "hueRotate": 350
        },
        "valencia": {
            "sepia": 15,
            "saturate": 150,
            "contrast": 90
        },
        "toaster": {
            "sepia": 40,
            "saturate": 250,
            "hueRotate": 330,
            "contrast": 67
        },
        "sierra": {
            "contrast": 80,
            "saturate": 120,
            "sepia": 15
        },
        "nashville": {
            "sepia": 40,
            "saturate": 150,
            "contrast": 90,
            "brightness": 110,
            "hueRotate": 345
        },
        "loFi": {
            "contrast": 140,
            "brightness": 90,
            "sepia": 5
        },
        "kelvin": {
            "sepia": 40,
            "saturate": 240,
            "brightness": 130,
            "contrast": 100
        },
        "rise": {
            "saturate": 140,
            "sepia": 25,
            "hueRotate": 345,
            "contrast": 80,
            "brightness": 110
        },
        "earlyBird": {
            "sepia": 40,
            "saturate": 160,
            "contrast": 110,
            "brightness": 90,
            "hueRotate": 350
        },
        "xPro2": {
            "contrast": 130,
            "brightness": 80,
            "sepia": 30,
            "saturate": 150,
            "hueRotate": 340
        },
        "y1977": {
            "sepia": 50,
            "hueRotate": 330,
            "saturate": 120,
            "contrast": 80
        }
    };
}
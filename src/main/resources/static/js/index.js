
// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["../static/image/mainpage/News1.png",
                "../static/image/mainpage/News2.png",
                "../static/image/mainpage/News3.png",
                "../static/image/mainpage/News4.png",
                "../static/image/mainpage/News5.png"

            ];
            var imageIndex = 0;

            function changeImage() {
                myImage.setAttribute("src", imageArray[imageIndex]);
                imageIndex++;
                if (imageIndex >= imageArray.length) {
                    imageIndex = 0;
                }
            }
            setInterval(changeImage, 2000);

// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["/src/main/resources/static/image/News1.png",
                "/src/main/resources/static/image/News2.png",
                "/src/main/resources/static/image/News3.png",
                "/src/main/resources/static/image/News4.png",
                "/src/main/resources/static/image/News5.png"

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
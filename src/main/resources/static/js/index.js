
// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["../static/image/mainpage/애견지식1.jpg",
            "../static/image/mainpage/애견지식2.jpg",
            "../static/image/mainpage/애견지식3.jpg",
            "../static/image/mainpage/애견지식4.jpg",
            "../static/image/mainpage/애견지식5.jpg",
            "../static/image/mainpage/애견지식6.jpg",
            "../static/image/mainpage/애견지식7.jpg",

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
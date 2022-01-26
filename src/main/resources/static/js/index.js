
// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["/src/main/resources/static/image/애견지식1.jpg",
            "/src/main/resources/static/image/애견지식2.jpg",
            "/src/main/resources/static/image/애견지식3.jpg",
            "/src/main/resources/static/image/애견지식4.jpg",
            "/src/main/resources/static/image/애견지식5.jpg",
            "/src/main/resources/static/image/애견지식6.jpg",
            "/src/main/resources/static/image/애견지식7.jpg"

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
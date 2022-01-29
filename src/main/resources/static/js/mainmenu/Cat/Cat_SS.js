//뷰를 사용한 리스트 
const cloth = new Vue({
    el: '#cloth',
    data: {

        items:[ //ALL 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Cat_FW/catfw_1.jpeg",
                title:'코코테일 고양이 티셔츠',
                price: 19000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Cat_FW/catfw_2.jpeg",
                title:'파스텔펫  마카롱 맨투맨, 옐로',
                price: 10800,
            },
            {
                id:3,
                image: "../../../static/image/Cat_FW/catfw_3.jpeg",
                title:'파스텔펫  마카롱 맨투맨, 핑크',
                price: 10800,
                best: 'https://picsum.photos/210/118/?image=160'

            },
            {
                id:4,
                image: "../../../static/image/Cat_FW/catfw_4.jpeg",
                title:'겨울옷 모직코트 머플러 세트',
                price: 9900

            },
            {
                id:5,
                image: "../../../static/image/Cat_FW/catfw_5.jpeg",
                title:'코코스튜디오 테디 명품 가디건',
                price: 14900
                

            },
            {
                id:6,
                image: "../../../static/image/Cat_FW/catfw_6.jpeg",
                title:'파스텔펫 소프트 고양이 환묘복',
                price: 12000

            },
            {
                id:7,
                image: "../../../static/image/Cat_FW/catfw_7.jpeg",
                title:'휴실내복 스낵 하네스 티셔츠',
                price: 25000

            },
            {
                id:8,
                image: "../../../static/image/Cat_FW/catfw_8.jpeg",
                title:'실내복 스낵 하네스 티셔츠,네이비',
                price: 26000

            },
            {
                id:9,
                image: "../../../static/image/Cat_FW/catfw_9.jpeg",
                title:'실내복 스낵 하네스 티셔츠,블랙',
                price: 26000

            }
        ],
        News:[ // New 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Cat_FW/catfw_1.jpeg",
                title:'코코테일 고양이 티셔츠',
                price: 19000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Cat_FW/catfw_2.jpeg",
                title:'파스텔펫  마카롱 맨투맨, 옐로',
                price: 10800,
            },
            {
                id:3,
                image: "../../../static/image/Cat_FW/catfw_3.jpeg",
                title:'파스텔펫  마카롱 맨투맨, 핑크',
                price: 10800,
                best: 'https://picsum.photos/210/118/?image=160'

            },
        ],
        bests:[ // Best 상품에 대한 상품리스트
            {
                id:4,
                image:"https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/7ded/9a442df16971649b5319d5548216e9685f1adb7f50a59207202cce5d03ab.jpg",
                title:'겨울옷 모직코트 머플러 세트',
                price: 9900

            },
            {
                id:5,
                image:"https://thumbnail6.coupangcdn.com/thumbnails/remote/230x230ex/image/vendor_inventory/2cae/2646f85028fb3604c2ba6fbe4773d4455cabeb5c0edf0ca2c6e5f57db8eb.jpg",
                title:'코코스튜디오 테디 명품 가디건',
                price: 14900
                

            },
            {
                id:6,
                image: "https://thumbnail10.coupangcdn.com/thumbnails/remote/292x292ex/image/rs_quotation_api/ukdqzrfh/eaa2a6b369b34c4f8d94d4f84980f0c5.jpg",
                title:'파스텔펫 소프트 고양이 환묘복',
                price: 12000

            },

            ], 
           
        likes:[ // Like 상품에 대한 상품리스트
            {
                id:6,
                image: "../../../static/image/Cat_FW/catfw_6.jpeg",
                title:'파스텔펫 소프트 고양이 환묘복',
                price: 12000

            },
            {
                id:7,
                image: "../../../static/image/Cat_FW/catfw_7.jpeg",
                title:'휴실내복 스낵 하네스 티셔츠',
                price: 25000

            },
            {
                id:8,
                image: "../../../static/image/Cat_FW/catfw_8.jpeg",
                title:'실내복 스낵 하네스 티셔츠,네이비',
                price: 26000

            },
            {
                id:9,
                image: "../../../static/image/Cat_FW/catfw_9.jpeg",
                title:'실내복 스낵 하네스 티셔츠,블랙',
                price: 26000

            }
        ],
         
        // All 리스트 상태에서 상품 검색기능
        item: {
            title: '',
        },
        itemName:'',
    
        
        },

        methods: {
        add () {
            this.items.push(this.item);
            this.item = {};
        }
        }
     
       
        
    });

        // main-bar 의 상품 메뉴 클릭시 상품메뉴에 따라 상품 리스트 정렬 제이쿼리
        var mainbar = $("#main-bar> ul > li");     //각각의 버튼을 변수에 저장
        var bottommainmiddle = $("#cloth > div");//각각의 콘텐츠를 변수에 저장

        //컨텐츠 내용을 숨겨주세요!
        bottommainmiddle.hide().eq(0).show();

        mainbar.click(function(){
        var target = $(this);         //버튼의 타겟(순서)을 변수에 저장
        var index = target.index();   //버튼의 순서를 변수에 저장
        mainbar.removeClass("active");    //버튼의 클래스를 삭제
        target.addClass("active");       //타겟의 클래스를 추가
        bottommainmiddle.css("display","none");
        bottommainmiddle.eq(index).css("display","block");

        });

        //상품정렬 후 브라우저의 새로고침으로 움직이는 화면을 고정하는 기능
        $("#main-bar").click(function() {
            $("html, body").animate({ scrollTop: 1100}, "slow");
            return false;
        });

        //상단 이미지 슬라이드 쇼
        var myImage = document.getElementById("mainImage");
        var imageArray = ["/src/main/resources/static/image/Cat_FW/catfw_5.jpeg",
            "/src/main/resources/static/image/Cat_FW/catfw_2.jpeg",
            "/src/main/resources/static/image/Cat_FW/catfw_3.jpeg",

        ];
        var imageIndex = 0;

        function changeImage() {
            myImage.setAttribute("src", imageArray[imageIndex]);
            imageIndex++;
            if (imageIndex >= imageArray.length) {
                imageIndex = 0;
            }
        }
        setInterval(changeImage, 1500);
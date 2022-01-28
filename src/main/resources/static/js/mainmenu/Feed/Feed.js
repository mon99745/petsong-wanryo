//뷰를 사용한 리스트 
const cloth = new Vue({
    el: '#cloth',
    data: {

        items:[ //ALL 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Feed/DogFeed1.jpg",
                title:'네츄럴코어 유기농 에코 70A 양고기 7kg',
                price: 39000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Feed/DogFeed2.jpg",
                title:'더독 닥터소프트 치킨 시니어 3kg',
                price: 19000,
            },
            {
                id:3,
                image: "../../../static/image/Feed/DogFeed3.jpg",
                title:'네츄럴코어 유기농 에코 2 오리고기 7kg',
                price: 57000,
                best: 'https://picsum.photos/210/118/?image=160'

            },
            {
                id:4,
                image: "../../../static/image/Feed/DogFeed4.jpg",
                title:'네츄럴코어 유기농 에코 9a 오리&고구마 6kg',
                price: 59000

            },
            {
                id:5,
                image: "../../../static/image/Feed/CatFeed1.jpg",
                title:'캐츠랑 전연령 20kg',
                price: 43900
                

            },
            {
                id:6,
                image: "../../../static/image/Feed/CatFeed2.jpg",
                title:'ANF 유기농 6Free 인도어 어덜트 6kg',
                price: 59000

            },
            {
                id:7,
                image: "../../../static/image/Feed/CatFeed3.jpg",
                title:'프로베스트 캣 15kg',
                price: 39000

            },
            {
                id:8,
                image: "../../../static/image/Feed/CatFeed4.jpg",
                title:'ANF 유기농 6Free 웨이트케어 6kg',
                price: 59000

            }
        ],
        DogFeeds:[ // Toy 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Feed/DogFeed1.jpg",
                title:'네츄럴코어 유기농 에코 70A 양고기 7kg',
                price: 39000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Feed/DogFeed2.jpg",
                title:'더독 닥터소프트 치킨 시니어 3kg',
                price: 19000,
            },
            {
                id:3,
                image: "../../../static/image/Feed/DogFeed3.jpg",
                title:'네츄럴코어 유기농 에코 2 오리고기 7kg',
                price: 57000,
                best: 'https://picsum.photos/210/118/?image=160'

            },
            {
                id:4,
                image: "../../../static/image/Feed/DogFeed4.jpg",
                title:'네츄럴코어 유기농 에코 9a 오리&고구마 6kg',
                price: 59000

            },
        ],
        CatFeeds:[ // Bag 상품에 대한 상품리스트
            {
                id:5,
                image: "../../../static/image/Feed/CatFeed1.jpg",
                title:'캐츠랑 전연령 20kg',
                price: 43900
                

            },
            {
                id:6,
                image: "../../../static/image/Feed/CatFeed2.jpg",
                title:'ANF 유기농 6Free 인도어 어덜트 6kg',
                price: 59000

            },
            {
                id:7,
                image: "../../../static/image/Feed/CatFeed3.jpg",
                title:'프로베스트 캣 15kg',
                price: 39000

            },
            {
                id:8,
                image: "../../../static/image/Feed/CatFeed4.jpg",
                title:'ANF 유기농 6Free 웨이트케어 6kg',
                price: 59000

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

 
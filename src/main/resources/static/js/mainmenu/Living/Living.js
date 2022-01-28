//뷰를 사용한 리스트 
const cloth = new Vue({
    el: '#cloth',
    data: {

        items:[ //ALL 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Living/Toy/Toy1.jpg",
                title:'페로가토 오리 삑삑이 민트',
                price: 2000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Living/Toy/Toy2.jpg",
                title:'바베큐 갈비',
                price: 2000,
            },
            {
                id:3,
                image: "../../../static/image/Living/Toy/Toy3.jpg",
                title:'친환경 곰돌이 인형',
                price: 2000,
                best: 'https://picsum.photos/210/118/?image=160'

            },
            {
                id:4,
                image: "../../../static/image/Living/Toy/Toy4.jpg",
                title:'삑삑이 문어',
                price: 2000

            },
            {
                id:5,
                image: "../../../static/image/Living/Bag/Bag1.jpg",
                title:'마이플러피 업백 베이지',
                price: 100000
                

            },
            {
                id:6,
                image: "../../../static/image/Living/Bag/Bag2.jpg",
                title:'마이플러피 히든백 서포트 쿠션 챠콜',
                price: 24000

            },
            {
                id:7,
                image: "../../../static/image/Living/Bag/Bag3.jpg",
                title:'울리 모던 슬링백 스트라이프',
                price: 24000

            },
            {
                id:8,
                image: "../../../static/image/Living/Bag/Bag4.jpg",
                title:'해피파우 러블리 플러스 숄더백 베이지',
                price: 40000

            },
            {
                id:9,
                image: "../../../static/image/Living/House/house1.jpg",
                title:'울리 펫빈백 방석 모카',
                price: 20000

            },
            {
                id:10,
                image: "../../../static/image/Living/House/house2.jpg",
                title:'울리 슈가 도넛방석 그레이',
                price: 20000

            },
            {
                id:11,
                image: "../../../static/image/Living/House/house3.jpg",
                title:'쏘아베 애니멀 하우스 젖소',
                price: 29000

            },
            {
                id:12,
                image: "../../../static/image/Living/House/house4.jpg",
                title:'반려양품 쿠션베드 네이비',
                price: 59000

            }
        ],
        Toys:[ // Toy 상품에 대한 상품리스트 
            {
                id:1,
                image: "../../../static/image/Living/Toy/Toy1.jpg",
                title:'페로가토 오리 삑삑이 민트',
                price: 2000,
                menu: 'best'
                
            },
            {
                id:2,
                image: "../../../static/image/Living/Toy/Toy2.jpg",
                title:'바베큐 갈비',
                price: 2000,
            },
            {
                id:3,
                image: "../../../static/image/Living/Toy/Toy3.jpg",
                title:'친환경 곰돌이 인형',
                price: 2000,
                best: 'https://picsum.photos/210/118/?image=160'

            },
            {
                id:4,
                image: "../../../static/image/Living/Toy/Toy4.jpg",
                title:'삑삑이 문어',
                price: 2000

            },
        ],
        Bags:[ // Bag 상품에 대한 상품리스트
            {
                id:5,
                image: "../../../static/image/Living/Bag/Bag1.jpg",
                title:'마이플러피 업백 베이지',
                price: 100000
                

            },
            {
                id:6,
                image: "../../../static/image/Living/Bag/Bag2.jpg",
                title:'마이플러피 히든백 서포트 쿠션 챠콜',
                price: 24000

            },
            {
                id:7,
                image: "../../../static/image/Living/Bag/Bag3.jpg",
                title:'울리 모던 슬링백 스트라이프',
                price: 24000

            },
            {
                id:8,
                image: "../../../static/image/Living/Bag/Bag4.jpg",
                title:'해피파우 러블리 플러스 숄더백 베이지',
                price: 40000

            },

            ], 
           
        Homes:[ // Home 상품에 대한 상품리스트
            {
                id:9,
                image: "../../../static/image/Living/House/house1.jpg",
                title:'울리 펫빈백 방석 모카',
                price: 20000

            },
            {
                id:10,
                image: "../../../static/image/Living/House/house2.jpg",
                title:'울리 슈가 도넛방석 그레이',
                price: 20000

            },
            {
                id:11,
                image: "../../../static/image/Living/House/house3.jpg",
                title:'쏘아베 애니멀 하우스 젖소',
                price: 29000

            },
            {
                id:12,
                image: "../../../static/image/Living/House/house4.jpg",
                title:'반려양품 쿠션베드 네이비',
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

 
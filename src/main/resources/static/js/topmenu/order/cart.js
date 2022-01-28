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
        ]
        
        }
        
    });
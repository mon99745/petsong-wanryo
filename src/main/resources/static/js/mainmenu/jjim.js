var heartcount=0;
var bagunicount=0;

function jjim(num)
{
    heartcount++;
    console.log(heartcount);

    if(heartcount%2==0)
    {
        document.getElementById("empty-heart"+num).src = "/src/main/resources/static/image/icon_logo/empty-heart.png";
    }

    else if(heartcount%2==1)
    {
        Swal.fire({


            icon : 'success' ,
            title: '찜 완료!'
          })     
        document.getElementById("empty-heart"+num).src = "/src/main/resources/static/image/icon_logo/red-heart.png";
    }


}


function baguni(num)
{
    bagunicount++;

    if(bagunicount%2==0)
    {
        document.getElementById("empty-cart"+num).src = "/src/main/resources/static/image/icon_logo/empty-cart.png";
    }

    else if(bagunicount%2==1)
    {
        Swal.fire({


            icon : 'success' ,
            title: '장바구니에 담겼습니다!'
          })  
        document.getElementById("empty-cart"+num).src = "/src/main/resources/static/image/icon_logo/full-cart.png";
    }
}







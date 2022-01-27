var heartcount=0;
var bagunicount=0;

// function jjim(num)
// {
//     heartcount++;
//     console.log(heartcount);

//     if(heartcount%2==0)
//     {
//         document.getElementById("empty-heart"+num).src = "/src/main/resources/static/image/icon_logo/empty-heart.png";
//     }

//     else if(heartcount%2==1)
//     {
//         Swal.fire({


//             icon : 'success' ,
//             title: '찜 완료!',

     
//           })     
//         document.getElementById("empty-heart"+num).src = "/src/main/resources/static/image/icon_logo/red-heart.png";
//     }


// }

function jjim(num)
{


    document.getElementById("empty-heart"+num ).setAttribute( 'id', "red-heart"+num );
    document.getElementById("red-heart"+num).src = "/src/main/resources/static/image/icon_logo/red-heart.png";


    var redheart = document.getElementById("red-heart"+num);


redheart.onclick = function()
{
   redheart.src = "/src/main/resources/static/image/icon_logo/empty-heart.png";
   document.getElementById("red-heart"+num ).setAttribute( 'id', "empty-heart"+num );
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




const heartBtns = document.querySelectorAll('.empty-heart');

heartBtns.forEach(function(btns){ 

    btns.addEventListener ("click", function() { 
        btns.classList.toggle('full-heart');
    });
})


const cartBtns = document.querySelectorAll('.empty-cart');

cartBtns.forEach(function(btns){ 

    btns.addEventListener ("click", function() { 
        btns.classList.toggle('oncart');
       
     
    });
})


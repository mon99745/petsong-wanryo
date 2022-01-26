
// ------------------------------------사이즈 클릭 시 상품목록 추가-------------------------

// ----------------------------------------XS-----------------------------------------
function row1() {
    var my_tbody = document.getElementById('my-tbody');

    // var row = my_tbody.insertRow(0); // 상단에 추가
    var row = my_tbody.insertRow( my_tbody.rows.length); // 하단에 추가
    
     if( my_tbody.rows.length <= 7){
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);  
            
    } 
    else{
        alert("한 상품마다 주문 최대 개수는 7개입니다. ")
    } 
   
    cell1.innerHTML = '<span style="margin-left:80px">XS</span>';
    cell2.innerHTML = '<span id="quantity" style="margin-left: 50px;">\
                        <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px;\
                        width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <div type="button"; onclick="incrementClick1(); incrementClick2();"; style="width: 20px; height: 20px; display:inline-block;\
                        border: 1px solid gray; border-radius: 1em; padding-bottom: 3px;  text-align:center; cursor: context-menu;">+</div>\
                        <div type="button"; onclick="decrementClick1(); decrementClick2();"; style="width: 20px; height: 20px; display:inline-block;\
                         border: 1px solid gray; border-radius: 1em; padding-bottom: 3px;  text-align:center; cursor: context-menu;">-</div>\
                        </span>  ';
    cell3.innerHTML = '<span id="price"; style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';

  
  }

  
 
  
var counterVal1 = 0;

function incrementClick1() {
  if(counterVal1<=6)  
  updateDisplay1(++counterVal1);
}
function decrementClick1() {
  if(counterVal1>=1)
    updateDisplay1(--counterVal1);
}
function updateDisplay1(val) {
    document.getElementById("spinbox").innerHTML = val;
}


    
var counterVa2 = 0;

function incrementClick2() {
  if(counterVal2<=6)  
  updateDisplay2(counterVal2+1000);
}
function decrementClick2() {
  if(counterVal2>=1)
    updateDisplay2(--counterVal2-10000);
}
function updateDisplay2(val) {
    document.getElementById("totalpos").innerHTML = val;
}
    
// ----------------------------------------S-----------------------------------------

 function row2() {
    var my_tbody = document.getElementById('my-tbody');
    // var row = my_tbody.insertRow(0); // 상단에 추가
    var row = my_tbody.insertRow( my_tbody.rows.length); // 하단에 추가
    
     if( my_tbody.rows.length <= 7){
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);  
            
    } 
    else{
        alert("한 상품마다 주문 최대 개수는 7개입니다. ")
    } 
   
    cell1.innerHTML = '<span style="margin-left:85px">S</span>';
    cell2.innerHTML = ' <span id="quantity" style="margin-left: 50px;">\
    <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px;\
    width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
    <div type="button"; onclick="incrementClick1(); incrementClick2();"; style="width: 20px; height: 20px; display:inline-block;\
    border: 1px solid gray; border-radius: 1em; padding-bottom: 3px;  text-align:center; cursor: context-menu;">+</div>\
    <div type="button"; onclick="decrementClick1(); decrementClick2();"; style="width: 20px; height: 20px; display:inline-block;\
     border: 1px solid gray; border-radius: 1em; padding-bottom: 3px;  text-align:center; cursor: context-menu;">-</div>\
    </span>  ';
    cell3.innerHTML = '<span style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';
 
  }

  // ----------------------------------------M----------------------------------------
function row3() {
    var my_tbody = document.getElementById('my-tbody');
    // var row = my_tbody.insertRow(0); // 상단에 추가
    var row = my_tbody.insertRow( my_tbody.rows.length); // 하단에 추가
    
     if( my_tbody.rows.length <= 7){
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);  
            
    } 
    else{
        alert("한 상품마다 주문 최대 개수는 7개입니다. ")
    } 
   
    cell1.innerHTML = '<span style="margin-left:80px">M</span>';
     cell2.innerHTML = '  <span id="quantity">\
                        <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px; width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <input type="button"; onclick="count1("plus"; count2("plus");" value="+"; style="width: 20px; height: 20px;"/>\
                        <input type="button"; onclick="count1("minus"); count2("minus");" value="-"; style="width: 20px; height: 20px;"/>\
                        </span>';
    cell3.innerHTML = '<span style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';
 
  }

  // ----------------------------------------L-----------------------------------------
function row4() {
    var my_tbody = document.getElementById('my-tbody');
    // var row = my_tbody.insertRow(0); // 상단에 추가
    var row = my_tbody.insertRow( my_tbody.rows.length); // 하단에 추가
    
     if( my_tbody.rows.length <= 7){
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);  
            
    } 
    else{
        alert("한 상품마다 주문 최대 개수는 7개입니다. ")
    } 
   
    cell1.innerHTML = '<span style="margin-left:85px">L</span>';
     cell2.innerHTML = '  <span id="quantity">\
                        <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px; width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <input type="button"; onclick="count1("plus"; count2("plus");" value="+"; style="width: 20px; height: 20px;"/>\
                        <input type="button"; onclick="count1("minus"); count2("minus");" value="-"; style="width: 20px; height: 20px;"/>\
                        </span>';
    cell3.innerHTML = '<span style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';

 
  }

// ----------------------------------------XL-----------------------------------------
function row5() {
    var my_tbody = document.getElementById('my-tbody');
    // var row = my_tbody.insertRow(0); // 상단에 추가
    var row = my_tbody.insertRow( my_tbody.rows.length); // 하단에 추가
    
     if( my_tbody.rows.length <= 7){
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);  
            
    } 
    else{
        alert("한 상품마다 주문 최대 개수는 7개입니다. ")
    } 


    cell1.innerHTML = '<span style="margin-left:80px">XL</span>';
    cell2.innerHTML = '  <span id="quantity">\
                        <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px; width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <input type="button"; onclick="count1("plus"; count2("plus");" value="+"; style="width: 20px; height: 20px;"/>\
                        <input type="button"; onclick="count1("minus"); count2("minus");" value="-"; style="width: 20px; height: 20px;"/>\
                        </span>';
    cell3.innerHTML = '<span style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';

 
  }



function delete_row() {
    var my_tbody = document.getElementById('my-tbody');
   if (my_tbody.rows.length < 1) return;
    // my_tbody.deleteRow(0); // 상단부터 삭제
    my_tbody.deleteRow( my_tbody.rows.length-1 ); // 하단부터 삭제
  }






// ----------------------------------가이드 메뉴 클릭 시 이동 화면 이동----------------------------

$(".g1").click(function() {
$("html, body").animate({ scrollTop: 2200}, "slow");
return false;
});
$(".g2").click(function() {
$("html, body").animate({ scrollTop: 2700}, "slow");
return false;
});
$(".g3").click(function() {
$("html, body").animate({ scrollTop: 1100}, "slow");
return false;
});




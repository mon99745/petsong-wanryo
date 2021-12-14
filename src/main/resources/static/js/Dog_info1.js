
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
    cell2.innerHTML = '  <span id="quantity"><li id="spinbox" style=" border: 1px solid gray; margin-top: 10px; width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <button onclick="count1("plus") count2("plus")"  style="width: 20px; height: 20px;">+</button>\
                        <button onclick="count1("minus") count2("minus")"  style="width: 20px; height: 20px;">-</button>\
                        </span>';
    cell3.innerHTML = '<span style="margin-left:80px">Price</span> <button onclick="delete_row()">행 삭제하기</button>';

 
  }
  
function count1(type)  {
  // 결과를 표시할 element
  const priceposElement = document.getElementById('pricepos');

  
  // 현재 화면에 표시된 값
  let number1 = priceposElement.innerText;

  
  // 더하기/빼기
  if(type === 'plus') {
    number1 = parseInt(number1) + 1000;

  }else if(type === 'minus')  {
    number1 = parseInt(number1) - 1000;

    if(number1<0){
        return;
    }
  }
  
 
  
  // 결과 출력
  priceposElement.innerText = number1;
}
function count2(type)  {
  // 결과를 표시할 element
  const spinboxElement = document.getElementById('spinbox');

  
  // 현재 화면에 표시된 값
  let number1 = spinboxElement.innerText;

  
  // 더하기/빼기
  if(type === 'plus') {
    number1 = parseInt(number1) + 1;

  }else if(type === 'minus')  {
    number1 = parseInt(number1) - 1;

    if(number1<0){
        return;
    }
  }
  
 
  
  // 결과 출력
  spinboxElement.innerText = number1;
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
    cell2.innerHTML = '  <span id="quantity">\
                        <li id="spinbox" style=" border: 1px solid gray; margin-top: 10px; width: 30px; height: 20px; text-align: center; color: transparent; text-shadow: 0 0 0 black;">1</li>\
                        <input type="button"; onclick="count1("plus"; count2("plus");" value="+"; style="width: 20px; height: 20px;"/>\
                        <input type="button"; onclick="count1("minus"); count2("minus");" value="-"; style="width: 20px; height: 20px;"/>\
                        </span>';
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




const obj =[{name:'BreakFast',status:true}]


var div1 = document.createElement('div');
div1.id= "div_id";
div1.className="div-cls";
document.body.appendChild(div1);

var p1 = document.createElement('p');
p1.id="p_id";
p1.className="p-cls";
p1.innerHTML="List of Tasks To Do : ";
div1.appendChild(p1);

var p2 = document.createElement('span');
p2.id="p2-id";
p1.appendChild(p2);
p2.innerHTML = obj.length;

var input1 = document.createElement('input');
input1.placeholder="items....";
input1.id="input_id";
input1.className="inp-cls";
div1.appendChild(input1);

var butn = document.createElement('button');
butn.innerHTML="Add Activity";
butn.className="btn-cls";
butn.addEventListener('click',clked);
div1.appendChild(butn);

var unl = document.createElement('ol');
unl.className ="ul-cls";
div1.appendChild(unl);

var lst = document.createElement('li')
lst.className ="li-cls";
lst.id="li-id";

// var chckBox = document.createElement("input")
// chckBox.type = "checkbox";
// chckBox.id = "c_id"

unl.appendChild(lst);
//lst.appendchild(chckBox);

lst.innerHTML=obj[0].name;
lst.style.textDecoration="line-through";

var i = 0;
function clked(){
  var x= document.getElementById('input_id').value;
  input1.value ="";
  if(x){
    let txt = {
      name: x,
      status:false
    }
  
    obj.push(txt);
    document.getElementById('p2-id').innerHTML=obj.length;

    var checkBox=document.createElement("input");
    checkBox.type="checkbox";

    checkBox.id="id";

    var lst = document.createElement('li')
    lst.className ="li-cls";
    lst.id="li-id";
    
    lst.innerHTML=x; 


    lst.appendChild(checkBox);
    unl.append(lst);
   
    checkBox.addEventListener('change', function() {
      lst.style.textDecoration = checkBox.checked ? 'line-through' : 'none';
    });

   } else {
    alert("** Please update the activity *_* ");
   }
  }






displayDiv=function(id, elementValue) {
        document.getElementById(id).style.display = elementValue.value == "false" ? 'block' : 'none';
}

function correctInput() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 1500);
    setTimeout(function(){location.replace("markAttendance.html"); }, 1500);
  }

  function wrongInput() {
    var x = document.getElementById("snackbar1");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 1500);
    setTimeout(function(){location.replace("markAttendance.html"); }, 1500);

  }

async function postAttendance(){
  
    url ='http://localhost:8080/Attendance/postAttendance';
    var id = document.getElementById("Id").value;
    var p = document.getElementById("Select1").value;
    var res = document.getElementById("Select2").value;
    if(res == "choose option"){
        var res = "-";
    }
   let data = {
        internId: id,
        present: p,
        reason: res
    };

    params = {
        method :'POST',
        headers : {
            'Access-Control-Allow-Origin':"*",
            'Content-Type':'application/json',
            'mode':'no-cors',
            'Accept':'application/json'
        },
       body : JSON.stringify(data)
    }
     await fetch(url,params)
    .then((response)=>{
        if(response.status === 200) {
            correctInput();   
        } else {
            wrongInput();
        }
        response.json()})

    .then(data=> {
        console.log(data)
       
    });
//    location.replace("markAttendance.html");


}



function correctInput() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    setTimeout(function(){location.replace("interns.html"); }, 1500); 
  }

  function wrongInput() {
    var x = document.getElementById("snackbar1");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    setTimeout(function(){location.replace("interns.html"); }, 1500);
  }

async function updateIntern(){
    url ='http://localhost:8080/Attendance/updateIntern';
    var Id = document.getElementById("InternId").value;
    var InternName = document.getElementById("InternName").value;
    var InternEmail = document.getElementById("InternEmail").value;
    var phno = document.getElementById("InternPh").value;
    var addr = document.getElementById("InternAddress").value;
    
    if(!Id || !InternName || !addr || !InternEmail || !phno ){
        return  wrongInput();
    }
    else{
   let data ={
        internId:Id,
        name:InternName,
        email:InternEmail,
        phoneNo:phno,
        address:addr
    };

    params = {
        method :'PUT',
        headers : {
            'Access-Control-Allow-Origin':"*",
            'Content-Type':'application/json',
            'mode':'no-cors',
            'Accept':'application/json'
        },
        body : JSON.stringify(data)
    }
        
     await fetch(url,params).then((response)=>{
        if(response.status === 200) {
            correctInput();
        } else {
           wrongInput();
        }
         response.json()
        })
    .then(data>console.log(data));
    
}
}
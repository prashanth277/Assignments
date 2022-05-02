

function correctInput() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    // setTimeout(function(){location.replace("interns.html"); }, 1500);
  }

  function wrongInput() {
    var x = document.getElementById("snackbar1");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    // setTimeout(function(){location.replace("interns.html"); }, 1500);
    
  }

async function createIntern(){
    url ='http://localhost:8080/Attendance/createIntern';
    var id = document.getElementById("InternId").value;
    var internName = document.getElementById("InternName").value;
    var internEmail = document.getElementById("InternEmail").value;
    var internPhone = document.getElementById("InternPh").value;
    var internAddress = document.getElementById("InternAddress").value;

    if(!id || !internName || !internAddress || !internEmail || !internPhone ){
        return  wrongInput();
    }

   let data = {
       internId : id,
       name : internName,
       email : internEmail,
       phoneNo : internPhone,
       address: internAddress
    };

    params = {
        method :'POST',
        headers : {
            // 'Access-Control-Allow-Origin':"*",
            'Content-Type':'application/json',
            'mode':'no-cors',
            // 'Accept':'application/json'
        },
        body : JSON.stringify(data)
    }

    try {
        await fetch(url,params).then((response)=>{
            response.json();
            console.log(response.json());
           })
       .then((data)=>{
        console.log(data);
       });
       correctInput();
    } catch (error) {
        wrongInput();
    }
   
    
    // location.replace("interns.html");
   
}
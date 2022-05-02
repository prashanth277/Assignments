displayDiv=function(id, elementValue) {
    document.getElementById(id).style.display = elementValue.value == "false" ? 'block' : 'none';
}

function myFunction() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    setTimeout(function(){location.replace("manageAttendance.html"); }, 1500);
  }

async function updateAttendance(){
    url ='http://localhost:8080/Attendance/updateAttendance';
    var attId = document.getElementById("Id").value;
    var todaysDate = new Date();

    function convertDate(date) {
        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth()+1).toString();
        var dd  = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1]?mm:"0"+mmChars[0]) + '-' + (ddChars[1]?dd:"0"+ddChars[0]);
    }
    var internid = document.getElementById("internId").value;
    var p = document.getElementById("select1").value;
    var res = document.getElementById("select2").value;
    console.log(attId);
   let data = {
       id:attId,
       date:todaysDate,
        internId: internid,
        present: p,
        reason: res
    };

    params = {
        method :'PUT',
        headers : {
            'Access-Control_Allow_Origin':"*",
            'Content-Type':'application/json',
            'mode':'no-cors',
            'Accept':'application/json'
        },
        body : JSON.stringify(data)
    }
        
     await fetch(url,params).then((response)=>{
        if(response.status === 200) {
            myFunction();   
        } 
         response.json()
        })
    .then(data>console.log(data));
    // location.replace("manageAttendance.html");    
}
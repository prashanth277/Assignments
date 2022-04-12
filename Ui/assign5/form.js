
var btn = document.createElement('button');
btn.innerHTML= 'populate';
btn.addEventListener('click', function(){


    const xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
        let x = JSON.parse(this.responseText);
        console.log(x);
        console.log("you have clicked the btn")
    }

    xhttp.open('GET', 'http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee',true);
    xhttp.send();

})

var btn2 = document.createElement('button');
btn2.innerHTML= 'post';
btn2.addEventListener('click', function(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
        console.log("you have clicked the btn")
    }

   xhttp.open('POST', 'http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee',true);

   xhttp.getResponseHeader('content-type','application/json')

   const data = '{"empId":1,"firstname":"raju","lastname":"lid","username":"eric.lin","password":"wavemaker","role":"admin","managerId":null,"tenantId":1}';
   xhttp.send(data);





})

document.body.appendChild(btn);
document.body.appendChild(btn2);

  
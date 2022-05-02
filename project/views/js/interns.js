const url='http://localhost:8080/Attendance/getInternInfo ';
var cnt = 0;
let data="";
apiCall();
function apiCall(){
    fetch(url)
    .then(response=>response.json())
    .then(json=>{
        let data="";
        json.forEach(interns => {
            cnt += 1;
            data +=
            `<tr>
                <td>${interns.internId}</td>
                <td>${interns.name}</td>
                <td>${interns.email}</td>
                <td>${interns.phoneNo}</td>
                <td>${interns.address}</td>
                <td><button class="btn info" style="background: #ffffff;" onclick="update(${interns.internId})">
                <i class="fa fa-pencil-square-o" style="background: #ffffff;" aria-hidden="true"></i></button></td>
            <tr>`
            
        }
        );
        localStorage.setItem("total",cnt);
        document.getElementById("internInfo").innerHTML=data;
    })
}

function update(id){
    document.location.href = 'updateIntern.html',true;
    
    localStorage.setItem("selectedInternId",id);
    // localStorage.setItem("selectedInternName",name);
    
}
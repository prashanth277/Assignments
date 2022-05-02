const url='http://localhost:8080/Attendance/getTodayAttendance ';
let data="";
apiCall();
function apiCall(){
    fetch(url)
    .then(response=>response.json())
    .then(json=>{
        let data="";
        json.forEach(interns => {
            let status;
            if(interns[3]==true){
                status="Present";
            }
            else{
                status="Absent";
            }
            data +=
            `<tr>
                <td>${interns[1]}</td>
                <td>${interns[2]}</td>
                <td>${status}</td>
                <td>${interns[4]}</td>
                <td><button class="btn info" style="background: #ffffff;" onclick="update(${interns[1]},${interns[0]})">
                <i class="fa fa-pencil-square-o" style="background: #ffffff;" aria-hidden="true"></i></button></td>
            <tr>`
        }
        );
        document.getElementById("AttendanceInfo").innerHTML=data;

    })
}

function update(id,hid){
    document.location.href = 'updateAttendance.html',true;
     localStorage.setItem("selectedId",id);
     localStorage.setItem("hiddenId",hid);
}
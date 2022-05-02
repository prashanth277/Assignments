
var interns =[];
var counts = [];

chartIt();
async function chartIt() {
   await getData();
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: interns,
        datasets: [{
            barPercentage: 0.9,
            barThickness: 1,
            maxBarThickness: 1,
            minBarLength: 0.1,
            label: "Days Absent",
            data: counts,
            backgroundColor: 
                'rgba(255, 90, 132, 0.2)',
            borderColor: 
                'rgba(255, 90, 132, 1)',
            borderWidth: 1
        }]
    },
    
});
}

async function getData(){
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };
  await fetch("http://localhost:8080/Attendance/getAbsenteesCount", requestOptions)
    .then(response => response.json())
    .then((result) => {
     let c = 0;
      result.map((i)=>{
        interns.push(i[0]);
        counts.push(i[1]);
      })
    })
    .catch(error => console.log('error', error));  
}


const url='http://localhost:8080/Attendance/absentToday ';
var count =0 ;
let data="";
getinterns();
function getinterns(){
    fetch(url)
    .then(response=>response.json())
    .then(json=>{
        json.forEach(interns => {
          count += 1;
            data +=
            `<tr>
                <td>${interns[0]}</td>
                <td>${interns[1]}</td>
            <tr>` 
                    
        }
        );
        document.getElementById("absenteesInfo").innerHTML=data;
    })
}


async function show(){
  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };
  await fetch("http://localhost:8080/Attendance/absentCount", requestOptions)
    .then(response => response.json())
    .then((result) => {
      localStorage.setItem("ab",result);
  })
  .catch(error => console.log('error', error));
}
show()


async function presentCnt(){
    var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
    await fetch("http://localhost:8080/Attendance/presentCount", requestOptions)
      .then(response => response.json())
      .then((result) => {
        localStorage.setItem("present",result);
    })
    .catch(error => console.log('error', error));
      
}
presentCnt()

var aCount = localStorage.getItem("ab");
var pCount = localStorage.getItem("present");
$(document).ready(function() {
    var ctx = $("#chart-line");
    var myLineChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
    labels: ["Absent","Present"],
    datasets: [{
    data: [ aCount,pCount],
    backgroundColor: [ "rgba(255, 90, 132, 0.2)","rgba(0, 100, 255, 0.5)"]
    }]
    },
    options: {
    title: {
    display: true
    }
    }
    });
});
    
// function refresh(){
//     location.refresh();
// }


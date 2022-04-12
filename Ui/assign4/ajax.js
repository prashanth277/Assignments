function loadDoc() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
      const x =JSON.parse(this.responseText);
      const Data=x.data;
      console.log(x);
    //   document.getElementById("demo").innerHTML=x[0].id;
      for(let i =0; i<Data.length;i++){
          let div1 = document.createElement('div');
          div1.className="div-cls";
          document.body.appendChild(div1);
          
          let dve2 = document.createElement('div');
          dve2.className = 'd2-cls';
          div1.appendChild(dve2);

          let img = document.createElement('img');
          img.className="img-cls";
          img.src= Data[i].avatar;
          dve2.appendChild(img);

          let dvel = document.createElement('div');
          dvel.className = 'd-cls';
          div1.appendChild(dvel);


          let l1 = document.createElement('span');
          l1.innerHTML= "ID : "+Data[i].id +"<br>";
          dvel.appendChild(l1);

          let l2 = document.createElement('span');
          l2.innerHTML= "NAME : "+Data[i].first_name + " " + Data[i].last_name+"<br>";
          dvel.appendChild(l2);

          let l3 = document.createElement('span');
          l3.innerHTML="EMAIL : "+ Data[i].email+"<br>";
          dvel.appendChild(l3);



      }

    }
    xhttp.open("GET", "https://reqres.in/api/users?page=1");
    xhttp.send();
  }
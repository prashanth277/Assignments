var div1 = document.createElement('div');
div1.className = "container";
document.body.appendChild(div1);




let btn = document.createElement('button');
btn.innerHTML = "Get Details";
btn.addEventListener('click', function () {
    const xhttp = new XMLHttpRequest();

    let table = document.createElement('table');
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    table.appendChild(thead);
    table.appendChild(tbody);

    // Adding the entire table to the body tag
    div1.appendChild(table);


    let row_1 = document.createElement('tr');
    let heading_1 = document.createElement('th');
    heading_1.innerHTML = "EMP_ID";
    let heading_2 = document.createElement('th');
    heading_2.innerHTML = "NAME";
    let heading_3 = document.createElement('th');
    heading_3.innerHTML = "EMAIL";
    let edit = document.createElement('th');
    edit.innerHTML = "edit-btn";

    row_1.appendChild(heading_1);
    row_1.appendChild(heading_2);
    row_1.appendChild(heading_3);
    row_1.appendChild(edit);
    thead.appendChild(row_1);
    xhttp.onload = function () {
        const x = JSON.parse(this.responseText);
        const Data = x.data;
        console.log(x);
        for (let i = 0; i < Data.length; i++) {


            let row_2 = document.createElement('tr');
            row_2.setAttribute('id', i + 1);
            let row_2_data_1 = document.createElement('td');
            row_2_data_1.innerHTML = Data[i].id;
            row_2_data_1.setAttribute('id', 'r2d1' + row_2.id);
            let row_2_data_2 = document.createElement('td');
            row_2_data_2.setAttribute('id', 'r2d2' + row_2.id);
            row_2_data_2.innerHTML = Data[i].first_name + " " + Data[i].last_name;
            let row_2_data_3 = document.createElement('td');
            row_2_data_3.setAttribute('id', 'r2d3' + row_2.id);
            row_2_data_3.innerHTML = Data[i].email;

            let btn2 = document.createElement('button');
            btn2.innerHTML = "edit"
            btn2.id="btn2-id"
            btn2.addEventListener('click', function () {

                var z = JSON.stringify(i + 1);
                console.log(z);
                var id = document.getElementById("r2d1" + row_2.id);
                var name = document.getElementById("r2d2" + row_2.id);
                var email = document.getElementById("r2d3" + row_2.id);

                var id_data = id.innerHTML;
                var name_data = name.innerHTML;
                var email_data = email.innerHTML;

                id.innerHTML = "<input type='text' id='name_text" + row_2.id + "' value='" + id_data + "'>";
                name.innerHTML = "<input type='text' id='country_text" + row_2.id + "' value='" + name_data + "'>";
                email.innerHTML = "<input type='text' id='age_text" + row_2.id + "' value='" + email_data + "'>";


                // let z = row_2.id;
                // let tr = document.getElementById('z');
                // tr.contentEditable= "true";
            });

            let btn3 = document.createElement('button');
            btn3.innerHTML = 'save';
            btn3.id="btn3-id"
            btn3.addEventListener('click', function () {
                var id = document.getElementById("r2d1" + row_2.id);
                var name = document.getElementById("r2d2" + row_2.id);
                var email = document.getElementById("r2d3" + row_2.id);
                
                document.getElementById("r2d1" + row_2.id).innerHTML = id;
                document.getElementById("r2d2" + row_2.id).innerHTML = name;
                document.getElementById("r2d3" + row_2.id).innerHTML = email;

                document.getElementById("btn2-id" + row_2.id).style.display = "block";
                document.getElementById("btn3-id" +row_2.id).style.display = "none";
            })
            row_2.appendChild(row_2_data_1);
            row_2.appendChild(row_2_data_2);
            row_2.appendChild(row_2_data_3);
            row_2.appendChild(btn2);
            row_2.appendChild(btn3);
            tbody.appendChild(row_2);
        }

    }
    xhttp.open("GET", "https://reqres.in/api/users?page=1");
    xhttp.send();
});
div1.append(btn);

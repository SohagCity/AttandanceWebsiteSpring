function show_menu(s) {
    document.getElementById(s).classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.dropdownlink')) {
        var dropdowns = document.getElementsByClassName("menuitems");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};


function percentage() {
    var value1=Number(document.querySelector("#value1").innerHTML);
    var value2=Number(document.querySelector("#value2").innerHTML);
    var p=(value2/(value1+value2) )*100;
    document.querySelector("#result").innerHTML=parseInt(p) + "%";
}

function addition (){
    var presences=new Array();
    var absences= new Array();

    var table=document.getElementById("table")

    for (var i=0, row; row=table.rows[i];i++){
        for (var j =0, col; col=row.cells[j];j++){
            if(i>0 && j==4) {
                presences.push(Number(col.innerHTML.valueOf()))
            }
            if(i>0 && j==3) {
                absences.push(Number(col.innerHTML.valueOf()))
            }
        }
    }

    var total=0;
    for(var k=0; k<presences.length;k++){
        total=total + presences[k]/(presences[k]+absences[k])*100
    }
    total=total/presences.length;
    document.getElementById("total").innerText=parseInt(total) +"%"
}



function sortTable() {
    const getCellValue = (tr, idx) => tr.children[idx].innerText || tr.children[idx].textContent;

    const comparer = (idx, asc) => (a, b) => ((v1, v2) =>
            v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.toString().localeCompare(v2)
    )(getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));


    document.querySelectorAll('th').forEach(th => th.addEventListener('click', (() => {
        const table = th.closest('table');
        Array.from(table.querySelectorAll('tr:nth-child(n+2)'))
            .sort(comparer(Array.from(th.parentNode.children).indexOf(th), this.asc = !this.asc))
            .forEach(tr => table.appendChild(tr));
    })));
}
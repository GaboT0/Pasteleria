
let r = 19;
let total = document.getElementById("total");
//total.innerHTML = '<b>TOTAL:'+ r+'</b>';

function listenTam(){
    let precio = parseInt(document.getElementById("tamanio").value);
    let cantidad = parseInt(document.getElementById("cantidad").value);
    let t = precio*cantidad;
    console.log(t);
    total.setAttribute("value","$"+t);
}

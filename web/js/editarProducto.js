let r = 19;
let total = document.getElementById("total");
//total.innerHTML = '<b>TOTAL:'+ r+'</b>';

function listenTam(){
    let precio = parseInt(document.getElementById("tamanio").value);
    let cantidad = parseInt(document.getElementById("cantidad").value);
    console.log(cantidad);
    if (cantidad >20){
        document.getElementById("cantidad").value = 20;
        cantidad = 20;
    }
    if (cantidad <= 0){
        document.getElementById("cantidad").value = 1;
        cantidad = 1;
    }
    if (!cantidad){
        document.getElementById("cantidad").value = 1;
        cantidad = 1;
    }
    let t = precio*cantidad;
    console.log(t);
    total.setAttribute("value","$"+t);
}
function selectValueTam(valor){
    let element = document.getElementById('tamanio');
    element.value = valor;
    console.log("SETEANDO "+ valor);
}
    
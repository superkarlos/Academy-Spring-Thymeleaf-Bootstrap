


function GerarMatriclula(){

    let txt = "ACA";
    let numeros = Math.floor(Math.random()*1500);

    document.getElementById('matricula').value(txt + numeros);
}
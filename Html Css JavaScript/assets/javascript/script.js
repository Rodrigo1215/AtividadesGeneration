var pegaDivTempo = document.getElementById("tempo")
let pegaDivEspaco = document.querySelector("#espaco")


function timeMsg(){
    setTimeout("insereHtml()", 3000)
}

function insereHtml(){
    pegaDivTempo.innerHTML = "Conteúdo Inserido"
}

function spaceMsg(){
    let location = window.location
}
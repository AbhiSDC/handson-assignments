function changeImage(event) {
   
    if(event.target.tagName == 'IMG') {
        //alert(event.target.src);
        document.getElementById("myImage").src = event.target.src;
    }
    
}
function addBgColor() {
    var a = document.getElementById("p1");
    a.innerHTML = "Simple change done"
    a.style.backgroundColor = 'yellow';
    a.style.color = 'red';
}

function val() {
    var un = document.getElementById('i1');
    var pw = document.getElementById('i2');
    if(un.value.length <= 2) {
        alert('Username must be more than 2 characters')
        return false;
    }
    if(pw.value.length <= 2) {
        alert("Password must be more than 2 characters")
        return false;
    }
    return true;
}
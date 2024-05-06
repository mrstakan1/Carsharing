document.getElementById("registration").addEventListener("submit", function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("registration"));
    fetch("/registry", {
        method: "POST",
        body: formData
    }).then(response => {
        console.log("POST");
    }).catch(error => {
        console.error('Error', error);
    });
        event.target.reset();
    });
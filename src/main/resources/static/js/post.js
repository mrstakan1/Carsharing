document.getElementById("post").addEventListener("submit", function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("post"));
    fetch("/admin", {
        method: "POST",
        body: formData
    }).then(response => {
        console.log("POST");
    }).catch(error => {
        console.error('Error', error);
    });
        event.target.reset();
    });
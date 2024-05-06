document.getElementById("deletion").addEventListener("submit", function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("deletion"));
    fetch("/admin", {
        method: "DELETE",
        body: formData
    }).then(response => {
        console.log("DELETE");
    }).catch(error => {
        console.error('Error', error);
    });
        event.target.reset();
    });
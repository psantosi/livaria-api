async function cadastrar() {
    let key = "Authorization",
        data = {
            titulo: document.getElementById("titulo").value,
            diretor: document.getElementById("diretor").value,
            genero: document.getElementById("genero").value,
            descricao: document.getElementById("descricao").value
        };


    const response = await fetch("http://localhost:8080/filme", {
      method: "POST",
      headers: new Headers({
        "Content-Type": "application/json; charset=utf8",
        Accept: "application/json",
        Authorization: localStorage.getItem(key),
      }),
      body: JSON.stringify(data),
    });

    if (response.ok) {
        showToast("#okToast");
        window.setTimeout(function () {
            window.location = "/view/index.html";
          }, 2000);
      } else {
        showToast("#errorToast");
      }

    limparCampos();
}

function limparCampos() {
    document.getElementById("titulo").value = '';
    document.getElementById("diretor").value = '';
    document.getElementById("genero").value = '';
    document.getElementById("descricao").value = '';
}

function showToast(id) {
    var toastElList = [].slice.call(document.querySelectorAll(id));
    var toastList = toastElList.map(function (toastEl) {
      return new bootstrap.Toast(toastEl);
    });
    toastList.forEach((toast) => toast.show());
  }


document.addEventListener("DOMContentLoaded", function (event) {
    if (!localStorage.getItem("Authorization"))
        window.location = "/view/login.html";
});
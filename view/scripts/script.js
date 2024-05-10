const filmeEndpoint = "http://localhost:8080/filme";

function hideLoader() {
  document.getElementById("loading").style.display = "none";
}

function construirTabela(filmes) {
  let tab = `<thead>
            <th scope="col">#</th>
            <th scope="col">Titulo</th>
            <th scope="col">Diretor</th>
            <th scope="col">Gênero</th>
            <th scope="col">Média de Votos</th>
            <th scope="col">&nbsp;</th>
        </thead>`;

  for (let filme of filmes) {
    tab += `
            <tr>
                <td scope="row">${filme.id}</td>
                <td>${filme.titulo}</td>
                <td>${filme.diretor}</td>
                <td>${filme.genero}</td>
                <td>${filme.mediaVotos}</td>
                <td class="estrelas">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="verDetalhes(${filme.id})">
                    Detalhes
                  </button>
                </td>
            </tr>
        `;
  }

  document.getElementById("filme").innerHTML = tab;
}

async function listarFilmes() {
  let key = "Authorization";
  const response = await fetch(filmeEndpoint, {
    method: "GET",
    headers: new Headers({
      Authorization: localStorage.getItem(key),
    }),
  });

  var data = await response.json();
  if (response) hideLoader();
  construirTabela(data);
}

async function verDetalhes(id) {
  let key = "Authorization";
  const response = await fetch(filmeEndpoint + '/' + id, {
    method: "GET",
    headers: new Headers({
      Authorization: localStorage.getItem(key),
    }),
  });

  var data = await response.json();
  construirDetalhes(data);
}

async function votar(nota) {
  let key = "Authorization",
    data = {
      nota: nota,
      idFilme: document.getElementById('filme-id').value
    };

  console.log(data);


  const response = await fetch("http://localhost:8080/voto", {
    method: "POST",
    headers: new Headers({
      "Content-Type": "application/json; charset=utf8",
      Accept: "application/json",
      Authorization: localStorage.getItem(key),
    }),
    body: JSON.stringify(data),
  });

  if (!response.ok) {
    if (response.status === 403) {
      showToast("#errorToast", 'Você não tem permissão para votar');
    } else {
      showToast("#errorToast");
    }
  }
}

function showToast(id, mensagem) {
  var toastElList = [].slice.call(document.querySelectorAll(id));
  var toastList = toastElList.map(function (toastEl) {
    return new bootstrap.Toast(toastEl);
  });
  document.getElementById("erro").innerText = mensagem || "Erro ao votar!";
  toastList.forEach((toast) => toast.show());
}

function construirDetalhes(data) {
  let temVoto = false;

  document.getElementById('staticBackdropLabel').innerText = data.titulo;
  document.getElementById('descricao').innerText = data.descricao;
  document.getElementById('diretor').innerText = data.diretor;
  document.getElementById('genero').innerText = data.genero;
  document.getElementById('filme-id').value = data.id;
  

  data.votos.forEach(voto => {
    if (voto.isVotoUsuario) {
      document.getElementById('cm_star-' + voto.nota).checked = true;
      temVoto = true;
    }
  });

  if (!temVoto) {
    document.getElementById('cm_star-empty').checked = true;
  }
}

document.addEventListener("DOMContentLoaded", function (event) {
  if (!localStorage.getItem("Authorization"))
    window.location = "login.html";
});

listarFilmes();
<h1 align="center"> linguagens-api </h1>

<hl></hl>
![Badge Status do Projeto](https://img.shields.io/badge/Status-EM%20DESENVOLVIMENTO-blue)<br>
<br>
<hl></hl>
<h4 align="center">Esse projeto consiste em uma API para cadastro de linguagens de programação com suas respectivas logo, assim como as demais funcionalidades de CRUD.
Além disso há uma opção de votar em uma das linguagens, criando um ranking em ordem das linguagens mais votadas.</h4>
<hl></hl>
# 🔨 Funcionalidades do projeto

- `Listar linguagens`: Essa funcionalidade lista todas as linguagens cadastradas. Para acessá-la utilize a URL: https://adams-linguagens-api.herokuapp.com/linguagens
- `Incluir Linguagem`: Para incluir uma linguagem basta passar no corpo da mensagem de requisição o JSON com os atributos da linguagem preenchidos
- `Alterar Linguagem`: Para alterar uma linguagem cadastradas, você deve passar o ID da linguagem na URL e no corpo da mensagem o atributo que deseja alterar.
- `Deletar Linguagem`: Para excluir uma linguagem é preciso informar o ID da linguagem também na URL
- `Votar em uma linguagem`: Para votar em uma linguagem basta incluir o nome da linguagem no final da URL de consumo da API
<hl></hl>

# 📁 Como Consumir a API

**Seguem instruções de consumo da API**
- `Listando as linguagens cadastradas` <br>
URL:  https://adams-linguagens-api.herokuapp.com/linguagens
- `Incluindo uma linguagem` <br>
URL:  https://adams-linguagens-api.herokuapp.com/linguagens  
JSON:
{
  "title": "C",
  "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/c/c_256x256.png",
}
- `Excluindo uma linguagem` <br>
URL:  https://adams-linguagens-api.herokuapp.com/linguagens/{id_a_ser_Excluído}
- `Alterando uma linguagem` <br>
URL:  https://adams-linguagens-api.herokuapp.com/linguagens/{id_a_ser_Alterado}  
JSON(Apenas dos atributos que serão alterados):
{
  "title": "C",  
  "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/c/c_256x256.png",
}
<br>


# 🛠️ Abrir e rodar o projeto
<h4 align="justify">O projeto está deployado no Heroku, então voucê poderá acessar o mesmo através da URL abaixo.</h4>
<h4><a href="https://adams-linguagens-api.herokuapp.com/linguagens" target="_blank">Clique Aqui!</a></h4>
<hl></hl>

# ✔️ Tecnologias utilizadas
<ul>
  <li> Java 18 </li>
  <li> SpringBoot 03.0.0--M4</li>
  <li> MongoDb </li>
</ul>


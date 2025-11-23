## Módulo 2.1 PMP

Módulo 2 do Projeto de PMP para entrega do Projeto Final, nele foi atendido os seguintes requisitos:

```
Módulo 2

Crie um API Gateway e garanta que sua aplicação de Login só possa ser acessada através de uma rota no Gateway.

O container da aplicação de Login não deve expor sua porta diretamente (configure o Docker adequadamente).

Inclua o Dockerfile necessário para a construção da aplicação
```

### Observação
* **Para o projeto complementar do 2° módulo, temos essa e outros dois projetos  que contemplam esse desenvolvimento**

| Projeto   | Descrição                         | Link do Repositório                                 |
|-----------|-----------------------------------|-----------------------------------------------------|
| Módulo 1  | API Rest com Crud Pessoa          | [Módulo 1](https://github.com/PMP-Projects/modulo1) |
| Módulo 2  | Gateway das aplicações do projeto | Este Repositório                                    |
| Módulo 2.1 | API Rest de Login + Segurança     | [Módulo 2.1](https://github.com/PMP-Projects/modulo2.1)                                    


---

## 📘 Estrutura do Projeto

```
modulo2/
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 modulo2 ← Módulo da Aplicação Gateway
│   │   │       ├── 📁 config ← Configuração de Rotas e Permissões
│   │   │       └── 📄 Modulo2Application.java ← Aplicação Principal
│   │   └── 📁 resources ← Configurações de URL e Portas
│   ├── 📁 test ← Pasta de Testes 
├── 📁 target
├── 📄 .gitattributes
├── 📄 .gitignore
├── 📄 docker-compose.yml ← Configuração dos containers
├── 📄 Dockerfile ← Build da imagem da aplicação
├── 📄 HELP.md
├── 📄 mvnw
├── 📄 mvnw.cmd
├── 📄 pom.xml  ← Build Maven
└── 📄 README.md ← Este arquivo

````
## 🧩 Tecnologias Utilizadas

- **Spring Boot** → Framework Back-End
- **Java** → Linguagem de programação
- **Maven** → Build
- **Docker** → Containers e virtualização
- **MongoDB** → Persistência de dados
- **Redis** → Cache
- **Graylog** → Central de Logs
- **SonarQube** → Qualidade do Código
- **Github Actions** → CI/CD automatizado

---

## Imagens Docker

- [Módulo 1](https://hub.docker.com/r/juliosn/modulo1)
- [Módulo 2](https://hub.docker.com/r/juliosn/modulo2)
- [Módulo 2.1](https://hub.docker.com/r/juliosn/modulo-auth)

---


## 📦 Instalação e Configuração do Ambiente
> Obs.: Tenha as imagens acima baixadas e presentes no seu docker para execução!

### 1️⃣ Clone o projeto na sua máquina e baixe as dependências:
```bash
# Clonar repositório
git clone https://github.com/PMP-Projects/modulo2.git

# Acesse a pasta do projeto
cd modulo2
````

### 2️⃣ Suba os Containers e Rode a Aplicação
```bash
# Inicie os containers (MongoDB, Redis, OpenSearch, Graylog), juntamente com o Dockerfile da aplicação
docker compose up -d --build
```

#### Serviços do Docker Compose

Caso queira acessar o gerenciamento de logs ou a base de dados do MongoDB, você pode utilizar esses acessos
- MongoDB: localhost:27017


---
## Endpoints

| Método   | Endpoint                       | Descrição                                |
|----------|--------------------------------|------------------------------------------|
| `POST`   | `/modulo-auth/api/v1/auth/login` | Login do usuário criado para gerar token |
| `POST`   | `/modulo-auth/api/v1/user/save`            | Salvar conta inserindo usuário e senha   |
| `POST`   | `modulo1/api/v1/pessoa`     | Criar uma nova pessoa                                             |
| `GET`    | `modulo1/api/v1/pessoa/{id}` | Buscar pessoa pelo ID                                             |
| `GET`    | `modulo1/api/v1/pessoa`     | Listar todas as pessoas ativas (paginação de 10 itens por página) |
| `PUT`    | `modulo1/api/v1/pessoa/{id}` | Atualizar os dados de uma pessoa pelo ID                          |
| `DELETE` | `modulo1/api/v1/pessoa/{id}` | Desativar (deletar logicamente) uma pessoa pelo ID                |


### Exemplos de uso com cURL

* Obs.: cURLs exportados do Insomnia

#### Criar Conta

```bash 
curl --request POST \
  --url http://localhost:8080/modulo-auth/api/v1/user/save \
  --header 'Content-Type: application/json' \
  --data '{
  "username": "juliuses",
  "password": "123456"
}
'
````

#### Login

```bash 
curl --request POST \
  --url http://localhost:8080/modulo-auth/api/v1/auth/login \
  --header 'Content-Type: application/json' \
  --data '{
  "username": "juliuses",
  "password": "123456"
}'
'
````

### Exemplos de uso com cURL

* Obs.: cURLs exportados do Insomnia

#### Criar Pessoa

```bash 
curl --request POST \
  --url http://localhost:8080/modulo1/api/v1/pessoa \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA' \
  --header 'Content-Type: application/json' \
  --data '{
  "nome": "Julio Neves",
  "dataNascimento": "2000-10-10"
}
'
````

#### Buscar pessoa por ID

```bash 
curl --request GET \
  --url http://localhost:8080/modulo1/api/v1/pessoa/ea0a91ab-bcd4-4626-aa5d-44b8f5d4d9f5 \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA' \
  --header 'User-Agent: insomnia/11.6.2'
````

#### Listar pessoas ativas
```bash 
curl --request GET \
  --url http://localhost:8080/modulo1/api/v1/pessoa \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA' \
  --header 'User-Agent: insomnia/11.6.2'
````

#### Atualizar pessoa
```bash 
curl --request PUT \
  --url http://localhost:8080/modulo1/api/v1/pessoa/ea0a91ab-bcd4-4626-aa5d-44b8f5d4d9f5 \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA' \
  --header 'Content-Type: application/json' \
  --data '{
  "nome": "Juliana Oliveira",
  "dataNascimento": "2000-10-10"
}
'
````
#### Deletar pessoa
````bash
curl --request DELETE \
  --url http://localhost:8080/modulo1/api/v1/pessoa/ea0a91ab-bcd4-4626-aa5d-44b8f5d4d9f5 \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA'
  ````


## ✍️ Autor do Projeto

<div align="center">

| [<img src="https://avatars.githubusercontent.com/u/99426563" width=115><br><sub>Júlio Neves</sub>](https://github.com/juliosn)
| :---: |

</div>

---

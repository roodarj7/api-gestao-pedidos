# 📦 Gestão de Pedidos (API REST)

API REST para gerenciamento de pedidos e comandas em restaurantes, desenvolvida com Java e Spring Boot, seguindo boas práticas de arquitetura em camadas e organização de código.

---

## 📌 Sobre o projeto

Este projeto tem como objetivo simular um sistema backend para controle de pedidos em um ambiente de restaurante.

A aplicação foi construída com foco em separação de responsabilidades e escalabilidade, representando um MVP funcional preparado para evolução com persistência em banco de dados e novas funcionalidades.

---

## 🚧 Status do projeto

🚀 Em desenvolvimento

A versão atual representa um MVP funcional com persistência em memória, com estrutura preparada para integração com banco de dados relacional e expansão de funcionalidades.

---

## ⚙️ Funcionalidades

- 📋 Cadastro de pedidos
- 🍽️ Gerenciamento de comandas
- ✏️ Atualização de pedidos
- ❌ Remoção de pedidos
- 🔄 Listagem de pedidos cadastrados
- 🧠 Aplicação de regras de negócio na camada de serviço

---

## 🧱 Arquitetura

O projeto segue o padrão de **arquitetura em camadas (Layered Architecture)**:

- **Controller** → Exposição dos endpoints da API
- **Service** → Regras de negócio e lógica da aplicação
- **Repository** → Acesso aos dados
- **DTO (Data Transfer Object)** → Comunicação entre camadas
- **Model** → Representação das entidades do domínio

Essa estrutura facilita manutenção, testes e evolução do sistema.

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot
- Maven
- Arquitetura em camadas
- Git e GitHub

---

## 🔗 Endpoints da API

| Método | Endpoint         | Descrição                |
|--------|----------------|--------------------------|
| GET    | /pedidos       | Listar pedidos           |
| GET    | /pedidos/{id}  | Buscar pedido por ID     |
| POST   | /pedidos       | Criar novo pedido        |
| PUT    | /pedidos/{id}  | Atualizar pedido         |
| DELETE | /pedidos/{id}  | Remover pedido           |

---

## 📄 Exemplo de requisição

```json

{
  "cliente": "Mesa 3",
  "itens": ["Hambúrguer", "Refrigerante"],
  "total": 42.50
}

```
---

## 📄 Exemplo de resposta

```json
{
  "id": 1,
  "cliente": "Mesa 3",
  "itens": ["Hambúrguer", "Refrigerante"],
  "total": 42.50
}

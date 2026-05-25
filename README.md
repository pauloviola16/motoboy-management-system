# Motoboy Management System 🛵
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Framework-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?logo=swagger&logoColor=black)

Sistema backend desenvolvido com **Java e Spring Boot** para gerenciamento e automatização de escalas de motoboys.  

O projeto está sendo desenvolvido com foco em organização operacional, controle de escalas, gestão de lojas e automatização de processos logísticos.

> ⚠️ Projeto em desenvolvimento — novas funcionalidades e melhorias estão sendo implementadas continuamente.

---

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger/OpenAPI
- Lombok

---

## 📂 Estrutura do Projeto

```bash
src/main/java/com/empresa/motoboy
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

A aplicação segue uma **arquitetura em camadas**, separando responsabilidades entre regras de negócio, acesso a dados e exposição da API.

---

## 📚 Funcionalidades Implementadas

### 🔹 Gestão de Motoboys
- Cadastro de motoboys
- Listagem de motoboys
- Busca por ID
- Atualização de dados
- Remoção de motoboys

### 🔹 Gestão de Lojas
- Cadastro de lojas
- Controle de informações operacionais
- Associação com escalas

### 🔹 Gestão de Escalas
- Criação de escalas
- Associação entre motoboy e loja
- Controle de horários
- Controle de status das escalas
- Registro de observações operacionais

---

## 🔗 Endpoints da API

### 🛵 Motoboys

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /motoboys | Criar motoboy |
| GET | /motoboys | Listar motoboys |
| GET | /motoboys/{id} | Buscar motoboy por ID |
| PUT | /motoboys/{id} | Atualizar motoboy |
| DELETE | /motoboys/{id} | Remover motoboy |

---

### 🏪 Lojas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /lojas | Criar loja |
| GET | /lojas | Listar lojas |
| GET | /lojas/{id} | Buscar loja por ID |
| PUT | /lojas/{id} | Atualizar loja |
| DELETE | /lojas/{id} | Remover loja |

---

### 📅 Escalas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /escalas | Criar escala |
| GET | /escalas | Listar escalas |
| GET | /escalas/{id} | Buscar escala por ID |
| PUT | /escalas/{id} | Atualizar escala |
| DELETE | /escalas/{id} | Remover escala |

---

## 🧩 Modelagem do Sistema

O sistema possui relacionamento entre entidades utilizando banco de dados relacional:

- Uma loja pode possuir várias escalas
- Um motoboy pode possuir várias escalas
- Cada escala pertence a uma loja e a um motoboy

---

## 📄 Documentação

A API conta com documentação interativa utilizando **Swagger/OpenAPI**.

Com o projeto rodando localmente, acesse:

```bash
http://localhost:8080/swagger-ui.html
```

Pela interface é possível visualizar os endpoints disponíveis e testar as requisições diretamente pelo navegador.

---

## 📥 Exemplo de Requisição

### Criar Escala

```json
{
  "motoboyId": 1,
  "lojaId": 2,
  "data": "2026-05-26",
  "horarioInicio": "18:00:00",
  "horarioFim": "23:59:00",
  "observacao": "Escala de fechamento"
}
```

---

## ▶️ Como rodar o projeto

### 🔹 Pré-requisitos

- Java 17+
- Maven
- MySQL

---

### 🔹 Executando localmente

```bash
git clone https://github.com/seuusuario/motoboy-management-system.git

cd motoboy-management-system

./mvnw spring-boot:run
```

A aplicação estará disponível em:

```bash
http://localhost:8080
```

---

## 🎯 Objetivo do Projeto

Este projeto está sendo desenvolvido com o objetivo de praticar:

- Desenvolvimento backend com Java e Spring Boot
- Criação de APIs REST
- Arquitetura em camadas
- Modelagem de banco de dados relacional
- Relacionamentos entre entidades com JPA/Hibernate
- Regras de negócio aplicadas a problemas reais
- Documentação de APIs com Swagger/OpenAPI

---

## 📌 Status do Projeto

🚧 Projeto em desenvolvimento ativo.
Novas funcionalidades estão sendo adicionadas continuamente conforme evolução do sistema.

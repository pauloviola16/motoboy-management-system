# Motoboy Management System 🛵

![Status](https://img.shields.io/badge/Status-Versão%201.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Framework-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?logo=swagger&logoColor=black)

## 📌 Sobre o Projeto

Sistema web desenvolvido com **Java e Spring Boot** para gerenciamento de escalas de motoboys.

O projeto foi idealizado a partir de desafios observados em operações logísticas reais, buscando centralizar o controle de escalas, organizar a distribuição de entregadores entre lojas e facilitar a visualização operacional diária.

Além da API REST, o sistema possui interface web desenvolvida com **Thymeleaf e Bootstrap**, permitindo o gerenciamento das escalas de forma simples e intuitiva.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Thymeleaf
- Bootstrap
- Maven
- Swagger/OpenAPI
- Lombok
- Git e GitHub

---

## 🧩 Funcionalidades

### Gestão de Escalas
- Cadastro de escalas
- Cancelamento de escalas
- Exclusão de escalas
- Controle de horários de trabalho
- Associação entre motoboys e lojas

### Dashboard Operacional
- Visualização de escalas por data
- Agrupamento das escalas por loja
- Consulta rápida da operação diária

### API REST
- CRUD de Motoboys
- CRUD de Lojas
- CRUD de Escalas
- Documentação automática com Swagger

---

## 📋 Regras de Negócio

- Uma loja pode possuir várias escalas.
- Um motoboy pode possuir várias escalas.
- Cada escala pertence a uma loja e a um motoboy.
- Escalas são organizadas por data.
- Escalas podem ser canceladas durante a operação.

---

## 🎯 Objetivo

Este projeto foi desenvolvido para consolidar conhecimentos em:

- Desenvolvimento Backend com Java
- Spring Boot
- APIs REST
- JPA/Hibernate
- Banco de Dados Relacional
- Arquitetura em Camadas
- Modelagem de Entidades e Relacionamentos
- Desenvolvimento de soluções para problemas reais de negócio

---

## 📖 Documentação da API

Com a aplicação em execução:

```bash
http://localhost:8080/swagger-ui.html
```

---

## ▶️ Executando o Projeto

### Pré-requisitos

- Java 17+
- Maven
- MySQL

### Execução

```bash
git clone https://github.com/seuusuario/motoboy-management-system.git

cd motoboy-management-system

./mvnw spring-boot:run
```

Aplicação disponível em:

```bash
http://localhost:8080
```

---

## 📸 Demonstração


<p align="center">
  <img src="images/DashboardEscalas.png" alt="Lista de Escalas" width="45%">
  <img src="images/NovaEscala.png" alt="Nova Escala" width="45
  %">
</p>

<p align="center">
  <em>À esquerda: listagem de escalas cadastradas. À direita: formulário para criação de novas escalas.</em>
</p>

## 📌 Status

✅ Versão 1.0 funcional

### Próximas melhorias

- Cadastro administrativo de lojas
- Cadastro administrativo de motoboys
- Relatórios operacionais
- Autenticação e controle de acesso
- Melhorias na experiência do usuário

---

Sistema desenvolvido para apoiar a gestão operacional de escalas em operações de entrega, centralizando informações de lojas, motoboys e jornadas de trabalho.

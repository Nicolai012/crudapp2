# Projeto Integrador – Cloud Developing 2025/1

> CRUD simples + API Gateway + Lambda /report + RDS + CI/CD

**Grupo**:

1. 10417221 - Nicolai - Arquitetou a Nuvem
1. RA - Matheus Vaghetti - Aplicação CRUD
1. 10418548 - Kauã Paixão - Documentação

## 1. Visão geral
<!-- Descreva rapidamente o domínio escolhido, por que foi selecionado e o que o CRUD faz. -->
Um back-end que recebe nome, preço e quantidade de itens de varejo; trata esses dados retornando quantidade total de produtos, quantidade total no estoque, preço total e o preço médio

## 2. Arquitetura

[Diagrama]

| Camada | Serviço | Descrição |
|--------|---------|-----------|
| Backend | EC2 + Docker | API RESTful CRUD Java/SpringBoot/ |
| Banco   | Amazon RDS              | MySQL em subnet pública |
| Gateway | Amazon API Gateway      | Rotas CRUD → EC2 · `/pruduct` → Lambda |
| Função  | AWS Lambda              | Consome a API, trata os dados JSON |

## 3. Como rodar localmente

mvnw.cmd spring-boot:run
./mvnw clean package
docker build -t Imagem .
docker run -p 8080:8080 Imagem

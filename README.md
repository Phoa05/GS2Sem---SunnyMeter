# SunnyMeter - Sistema de Registro de Produção de Energia Solar

##Integrantes:
- Pedro Henrique Oliveira Ananias rm550689
- Danilo Urze rm99465
- Kayque Moraes rm97592

## Descrição

O **SunnyMeter** é uma API REST para gerenciar registros de produção de energia solar. A aplicação foi desenvolvida em **Spring Boot**, utilizando **Spring Data JPA** para persistência, e organiza as entidades principais como **RegistroProducao**, **Cliente** e **Instalacao**.

## O que foi Implementado

1. **Camada de Modelos (Model):**
   - Classes que representam as tabelas do banco de dados:
     - **RegistroProducao**
     - **Cliente**
     - **Instalacao**

2. **Repositórios (Repository):**
   - Interfaces para acesso ao banco de dados utilizando o Spring Data JPA.

3. **Serviços (Service):**
   - Contém a lógica de negócios para manipular as entidades.

4. **Controladores (Controller):**
   - Endpoints RESTful para criar, atualizar, buscar e excluir registros.

## Entidades e Atributos

### RegistroProducao

- `id` (UUID): Identificador único do registro.
- `dataProducao` (String): Data da produção de energia.
- `quantidade` (double): Quantidade de energia produzida.
- `descricao` (String): Informações adicionais sobre o registro.
- `instalacao` (Instalacao): Relacionamento com uma instalação.
- `cliente` (Cliente): Relacionamento com um cliente.

### Cliente

- `id` (UUID): Identificador único do cliente.
- `nome` (String): Nome do cliente.
- `email` (String): Endereço de e-mail do cliente.

### Instalacao

- `id` (UUID): Identificador único da instalação.
- `nome` (String): Nome ou descrição da instalação.

## Funcionalidades Principais

1. **Criar um registro de produção**:
   - Um registro está associado a um cliente e uma instalação.

2. **Listar registros de produção**:
   - Buscar todos os registros existentes ou por critérios como ID ou data.

3. **Atualizar um registro existente**:
   - Modificar os atributos de um registro específico.

4. **Excluir registros**:
   - Remover registros do sistema.

5. **Gerenciamento de Clientes e Instalações**:
   - Operações CRUD completas.

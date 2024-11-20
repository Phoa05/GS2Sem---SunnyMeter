# SunnyMeter - Global Solution 2º Semestre

## Integrantes

- Pedro Henrique Oliveira Ananias (RM550689)
- Danilo Urze (RM99465)
- Kayque Moraes (RM97592)

## Descrição

O **SunnyMeter** é uma API REST desenvolvida em **Spring Boot**, com o objetivo de gerenciar dados relacionados à produção de energia solar. O projeto utiliza **Spring Data JPA** para persistência e implementa uma estrutura modular para facilitar o desenvolvimento e a manutenção.

As principais entidades do sistema incluem **RegistroProducao**, **Cliente**, **Instalacao**, **Contrato** e **RegistroConsumo**, com endpoints RESTful para operações CRUD completas.

## Estrutura do Projeto

### 1. **Camada de Modelos (Model)**

Define as classes que representam as tabelas do banco de dados:

- **RegistroProducao**: Gerencia registros da produção de energia.
- **Cliente**: Armazena informações dos clientes.
- **Instalacao**: Representa as instalações solares.
- **Contrato**: Define contratos de serviço entre clientes e instalações.
- **RegistroConsumo**: Registra o consumo de energia dos clientes.

### 2. **Repositórios (Repository)**

Interfaces para acesso e manipulação dos dados no banco de dados utilizando o **Spring Data JPA**.

### 3. **Serviços (Service)**

Contém a lógica de negócios, garantindo que as operações de manipulação dos dados sejam realizadas de forma consistente e segura.

### 4. **Controladores (Controller)**

Define os endpoints da API RESTful para interação com as funcionalidades do sistema.


## Entidades e seus Atributos

### **RegistroProducao**

- **`id`**: Identificador único (UUID).
- **`dataProducao`**: Data da produção de energia (String, pode ser ajustado para `LocalDate`).
- **`quantidade`**: Quantidade de energia produzida (double).
- **`descricao`**: Informações adicionais sobre o registro (String).
- **`instalacao`**: Relacionamento com uma instalação.
- **`cliente`**: Relacionamento com um cliente.

### **Cliente**

- **`clienteUuid`**: Identificador único do cliente (UUID).
- **`nome`**: Nome do cliente (String).
- **`endereco`**: Endereço do cliente (String).
- **`documento`**: Número do documento (String).
- **`tipo`**: Tipo de documento (CPF, CNPJ, etc.).
- **`cep`**: CEP do cliente (String).

### **Instalacao**

- **`id`**: Identificador único da instalação (UUID).
- **`nome`**: Nome ou descrição da instalação (String).
- **`endereco`**: Endereço onde está instalada (String).
- **`capacidade`**: Capacidade de produção da instalação (double).
- **`cliente`**: Relacionamento com o cliente responsável.

### **Contrato**

- **`id`**: Identificador único do contrato (UUID).
- **`cliente`**: Relacionamento com o cliente.
- **`instalacao`**: Relacionamento com a instalação.
- **`dataInicio`**: Data de início do contrato (String).
- **`dataFim`**: Data de término do contrato (String).
- **`descricao`**: Informações adicionais (String).

### **RegistroConsumo**

- **`id`**: Identificador único do registro (UUID).
- **`cliente`**: Relacionamento com o cliente.
- **`dataConsumo`**: Data do consumo (String).
- **`quantidade`**: Quantidade de energia consumida (double).


## Funcionalidades Implementadas

1. **Gestão de Produção de Energia Solar**
   - Criação, atualização, exclusão e listagem de registros de produção.
2. **Gestão de Clientes**
   - Operações CRUD completas para cadastro e gerenciamento de clientes.
3. **Gestão de Instalações**
   - Operações para criar, atualizar, listar e excluir instalações solares.
4. **Gerenciamento de Contratos**
   - Cadastro de contratos associando clientes às suas instalações.
5. **Registro de Consumo**
   - Rastrear e gerenciar o consumo de energia dos clientes.


## Tecnologias Utilizadas:

1. **Pré-requisitos:**
   - Java 17
   - Maven 3.8
   - Banco de Dados (H2)

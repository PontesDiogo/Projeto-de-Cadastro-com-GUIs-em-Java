# Projeto de Cadastro em Java com GUI

## Descrição do Projeto
Este projeto é uma aplicação Java com interface gráfica (GUI) para realizar o cadastro e gerenciamento de **vendedores**, **clientes** e **pedidos**. O sistema permite realizar operações básicas de CRUD (Create, Read, Update e Delete) e possui integração com um banco de dados **Microsoft Access**. Além disso, inclui funcionalidades como o cálculo do salário do vendedor baseado na comissão armazenada no banco de dados.

## Funcionalidades
- **Cadastro de Cliente:** Gerencie informações como CPF, nome, endereço, cidade, CEP e telefone.
- **Cadastro de Vendedor:** Inclui CPF, nome, salário base e taxa de comissão.
- **Cadastro de Pedido:** Contém número do pedido, data de emissão e valor.
- **Cálculo do Salário do Vendedor:** Salário base multiplicado pela taxa de comissão.
- **Menu Principal:** Navegação intuitiva para acessar os cadastros e operações.
- **Conexão com Banco de Dados:** Os dados são armazenados em um banco de dados Microsoft Access.

## Estrutura do Projeto
O projeto é dividido em:

- **Classes principais:**
  - `Pessoa` (classe base para `Cliente` e `Vendedor`)
  - `Cliente`
  - `Vendedor`
  - `Pedido`
- **Interface Gráfica:** Desenvolvida utilizando o Java Swing para interação amigável com o usuário.
- **Pacotes:**
  - `fatec.poo.control`
  - `fatec.poo.basedados`
  - `fatec.poo.view`
  - `fatec.poo.model`

## Tecnologias Utilizadas
- **Java SE**
- **Swing (GUI)**
- **Banco de Dados:** Microsoft Access
- **IDE:** NetBeans

## Como Configurar e Executar

1. **Pré-requisitos:**
   - JDK 8 ou superior
   - Microsoft Access instalado
   - Configuração do ODBC para conectar ao banco de dados Access

2. **Clone o repositório:**
   ```bash
   git clone [https://github.com/PontesDiogo/Trabalho-POO-3](https://github.com/PontesDiogo/Projeto-de-Cadastro-com-GUIs-em-Java
   ```

3. **Configure o banco de dados:**
   - Crie ou utilize o banco de dados Access fornecido.
   - Atualize o caminho do banco no código, se necessário.

4. **Compile e execute o projeto:**
   - Abra o projeto no NetBeans.
   - Compile e execute a aplicação.

## Prints das Telas

### Menu Principal
![image](https://github.com/user-attachments/assets/3509311e-866d-4e55-8d0d-5224e09c26be)

### Tela de Cadastro de Cliente
![image](https://github.com/user-attachments/assets/644ebe64-fc05-4929-9bbb-284739d89803)


### Tela de Cadastro de Vendedor
![image](https://github.com/user-attachments/assets/9dff3f99-53d1-48de-bbe0-affeecf34e67)


### Tela de Cadastro de Pedido
![image](https://github.com/user-attachments/assets/7a489e66-9487-4be6-b262-d7110bac9e5f)

## Estrutura do Banco de Dados

O banco de dados Access contém as seguintes tabelas:

- **Cliente:**
  - `cpf` (chave primária)
  - `nome`
  - `endereco`
  - `cidade`
  - `cep`
  - `telefone`

- **Vendedor:**
  - `cpf` (chave primária)
  - `nome`
  - `salario_base`
  - `taxa_comissao`

- **Pedido:**
  - `numero` (chave primária)
  - `data_emissao`
  - `valor`
  - `cpf_cliente` (chave estrangeira)
  - `cpf_vendedor` (chave estrangeira)


## Autor
Projeto desenvolvido por Diogo e Igor para a disciplina de Programação Orientada a Objetos.

---

Se você encontrar qualquer problema ou tiver sugestões, fique à vontade para abrir uma _issue_ no repositório!

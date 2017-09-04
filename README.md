# BackEndValeMobi-Java
Projeto para teste de conhecimento.

## Backend construido com Java e PostgreSQL como banco de dados.

O principal objetivo na aplicação é pode verificar os usuários pelos critérios de: 

1. Que o ID esteja entre 1500 à 2700 e o saldo seja acima de 560,

2. Ser um sistema batch, e

3. Persistir os dados em uma base de dados SQL Server ou similar.

## Como roda o programa:

Abaixe o projeto, rode pela IDE ou pelo terminal, no meu caso eu usei o NetBeans tanto para fazer o projeto, 
como para rodá-lo e fazer os testes. Para o banco de dados eu usei o PostgreSQL e fiz um insert 
dos usuários. A estrutura do banco de dados está abaixo:


- CREATE TABLE public.tb_customer_account
- (
-   cpf_cnpj character varying(14),
-   id_customer numeric NOT NULL,
-   nm_customer character varying(50),
-   is_active boolean,
-   vl_total numeric,
-   CONSTRAINT pk_id PRIMARY KEY (id_customer)
- )



## Como o projeto está estruturado:

- projetoValeMobi
   - classes
      - Tb_Customer_Account.java - Classe responsável por controlar o recebimento dos dados do usuários, verificar se o mesmo está ativado ou não e 
      ordena-lo no ArrayList do maior saldo ao menor saldo entre os usuários.
      
   - gerencia
      - GerenciarTb_Customer_Account.java - Classe responsável por controlar o recebimento dos dados dos usuários e 
      armazená-lo em ArrayList, fazer a verificação dos cretérios mencionado acima e imprimir somente os usuários que estejam
      entre os critérios.
     
   - main
      - MainValeMobi.java - Classe responsável por inicializar o projeto.
      
   - utilitarios
      - ConectaDB.java - Classe responsável por controlar o bancos de dados, tanto nos métodos getConexao() - responsável por realizar
      a conexão do banco de dados, getDesconecta() - responsável por desligar o banco de dados, e getExecutaSQL - responsável por selecionar os dados no banco de dados
      do banco.
 

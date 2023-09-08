# OticaJPA

Simples aplicação desktop CRUD para aplicar os conhecimentos de Orientações a Objetos em Java, utilizando camada de persistência de dados. A aplicação não tem conceitos e configurações complexas, foi criada apenas para compreensão dos conceitos de Orientação a Objetos com Java.
 
Tecnologias: MySQL 8.0, Java 17, Apache Maven, Hibernate ORM

A aplicação permite o simples cadastro de usuários (funcionários), o cadastro de produtos (armações, lentes), fornecedores, registro simples de venda e cadastro das receitas de óculos de clientes.

Para utilizá-la, basta executar os scripts do arquivo 'Dump20230806.sql' para criar o banco e popular dados de iniciais de usuários, fazer o build através de 'maven clean package' e executar o JAR gerado na pasta target.
* O jar with_dependencies contem todas as dependências do projeto. 

* Usuários iniciais da aplicação
username : admin | senha : admin 
username: vendedor | senha: vendedor

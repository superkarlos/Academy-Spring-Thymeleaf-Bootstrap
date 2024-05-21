# Sistema de Gerenciamento de Alunos

# Instruções para Execução do Projeto

Este projeto utiliza o banco de dados H2, que é um banco de dados em memória. Isso significa que os dados não são persistidos em disco, sendo ideais para testes e desenvolvimento rápido

  ![image](https://github.com/superkarlos/Academy-Spring-Thymeleaf-Bootstrap/assets/50372440/67824701-db94-46a8-bb66-15daa0d5769e)

   
Este projeto é um sistema de gerenciamento de alunos que permite cadastrar, listar, pesquisar, editar e excluir informações de alunos. Ele foi construído utilizando o Spring Boot com Java, Thymeleaf, Spring Web, Spring Data JPA, Bootstrap e CSS personalizado.

## Funcionalidades

### Cadastrar Alunos

A funcionalidade **Cadastrar Alunos** é uma parte essencial do nosso sistema de gerenciamento de alunos. Ela permite que os administradores do sistema adicionem novos alunos de maneira eficiente e segura. Utilizamos o `spring-boot-starter-validation` para garantir que todas as informações inseridas estejam corretas e completas antes de serem salvas no banco de dados.

### Validações Implementadas:

- **Nome :** O campo de nome não pode estar vazio e deve conter apenas caracteres alfabéticos.
- **Curso** Deve ser um curso válido.
- **Status** Deve ser um status válido .
- **Curso** Deve ser uma matricula válida e gerada.


Essas validações são aplicadas automaticamente pelo Spring Framework quando um novo aluno é cadastrado através do nosso formulário web. Isso não apenas melhora a integridade dos dados, mas também proporciona uma experiência de usuário mais fluida, pois os erros são capturados e comunicados de forma clara e imediata.

Com o `spring-boot-starter-validation`, garantimos que o processo de cadastro seja não apenas amigável, mas também robusto, evitando problemas comuns como duplicidade de dados e inconsistências. Assim, mantemos a qualidade e a confiabilidade do nosso sistema de gerenciamento de alunos.

![image](https://github.com/superkarlos/Academy-Spring-Thymeleaf-Bootstrap/assets/50372440/57af320f-8aa9-4bd9-a5ba-57282591b77c)


- **Listar Alunos:** Exibe todos os alunos cadastrados.

![image](https://github.com/superkarlos/Academy-Spring-Thymeleaf-Bootstrap/assets/50372440/67b19576-bf9c-4977-8708-b1fa2a17907e)


  
- **Pesquisar Alunos:** Oferece uma funcionalidade de busca para encontrar alunos específicos.

  ![image](https://github.com/superkarlos/Academy-Spring-Thymeleaf-Bootstrap/assets/50372440/3e93be47-1ad5-4d1e-9df6-9b3e66e090b8)

- **Editar Alunos:** Permite modificar as informações dos alunos já existentes.
- ![image](https://github.com/superkarlos/Academy-Spring-Thymeleaf-Bootstrap/assets/50372440/b71d4157-685f-4ec9-ba80-638bcea442ed)



## Tecnologias Utilizadas

- **Spring Boot:** Para a criação de aplicações Spring autônomas e fáceis de executar.
- **Thymeleaf:** Como motor de template para a criação de páginas HTML dinâmicas.
- **Spring Web:** Para construir a camada web, incluindo RESTful applications.
- **Spring Data JPA:** Para persistência de dados e acesso ao banco de dados.
- **Maven:** Para gerenciamento de dependências e construção do projeto.
- **Banco de Dados:** Para armazenar e gerenciar os dados dos alunos.
- **Bootstrap e CSS Personalizado:** Para design responsivo e estilização personalizada das interfaces de usuário.

## Como Executar

1. Clone o repositório:
2. Navegue até a pasta do projeto e execute:
3. Acesse `http://localhost:8080` no seu navegador para utilizar o sistema.

## Contribuições

Contribuições são sempre bem-vindas! Para contribuir, por favor, crie um fork do repositório, faça suas alterações e envie um pull request.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.



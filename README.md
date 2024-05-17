# Avalanches!
Bem-vindo ao Avalanches, o destino perfeito para os amantes de lanches com uma pitada de aventura! Em nosso refúgio gastronômico, preparamos uma avalanche de sabores deliciosos que vão deixar você emocionado. Desde hambúrgueres suculentos até milkshakes decadentes, cada mordida é uma jornada de sabor única e emocionante. Nossa equipe calorosa e acolhedora está aqui para garantir que sua experiência seja sempre memorável. Então, junte-se a nós no Avalanches, onde a alegria de comer bem encontra o espírito aventureiro!

## Funcionalidades Principais

- **Geração de Usuário**;

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.5
- Docker
- Banco de Dados (PostgreSQL)

## Estrutura do Projeto

O projeto segue os princípios de Domain-Driven Design (DDD) e arquitetura hexagonal, com as seguintes camadas:

- **Camada de Aplicação**: Contém os casos de uso e interfaces de aplicação.

- **Camada de Domínio**: Contém as entidades, objetos de valor, repositórios e serviços de domínio.

- **Camada de Infraestrutura**: Contém as implementações de infraestrutura, como persistência em banco de dados e comunicação com APIs externas.

## Documentação do Sistema

A documentação do sistema, incluindo o Event Storming e os diagramas de DDD, está disponível na pasta `/docs`.

## Execução do Projeto

Para executar o projeto localmente, siga estas etapas:

1. Clone o repositório.
2. Execute o comando `docker build -t sistema-controle-pedidos-avalanches-app-imagem .` para gerar a imagem da aplicação.
3. Execute o comando `docker-compose up` para inicializar seu container com os dois services .
4. Acesse o banco de dados através da URL `jdbc:postgresql://localhost:5432/avalanches_database`, com o usuário `avalanches_user` e a senha `avalanches_password`.
5. Divirta-se :D

## Autores

- Hennan Cesar Alves Gadelha de Freitas
  (hennangadelhafreitas@gmail.com)

- Adinelson da Silva Bruhmuller Júnior
  (adinelsonsbruhmuller@gmail.com)

- RAUL DE SOUZA
  (dev.raulsouza@outlook.com)

- Raphael Soares Teodoro
  (raphael.s.teodoro@outlook.com)

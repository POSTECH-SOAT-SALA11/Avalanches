# Avalanches!
Bem-vindo ao Avalanches, o destino perfeito para os amantes de lanches com uma pitada de aventura! Em nosso refúgio gastronômico, preparamos uma avalanche de sabores deliciosos que vão deixar você emocionado. Desde hambúrgueres suculentos até milkshakes saborosos, cada mordida é uma jornada de sabor única e emocionante. Nossa equipe calorosa e acolhedora está aqui para garantir que sua experiência seja sempre memorável. Então, junte-se a nós no Avalanches, onde a alegria de comer bem encontra o espírito aventureiro!

## Funcionalidades Principais ao Cliente Externo

- **Cadastro de Clientes**: Deixe a gente te conhecer mais! Venha se cadastrar na nossa lanchonete e fique por dentro de nossas novidades, como também torne-se apto a receber nossas promoções!
- **Sistema de Pedidos**: Olhe nosso delicioso cardápio e faça seu pedido! Nossa equipe está pronta para preparar seu lanche com todo o carinho e dedicação.

## Funcionalidades Principais Internas

- **Cadastro de Produtos**: Adicione novos produtos ao nosso cardápio e deixe nossos clientes ainda mais felizes!
- **Consulta de Produtos**: Consulte todos os produtos disponíveis em nosso cardápio e garanta que nossos clientes tenham sempre a melhor experiência.
- **Atualização de Produtos**: Atualize as informações dos produtos cadastrados em nosso sistema e mantenha nosso cardápio sempre atualizado.
- **Consulta de Clientes**: Consulte todos os clientes cadastrados em nosso sistema e garanta que eles estejam sempre satisfeitos com nossos serviços.
- **Atualização de Clientes**: Atualize as informações dos clientes cadastrados em nosso sistema e mantenha nosso banco de dados sempre atualizado.

## Tecnologias Utilizadas

- Java 18
- Spring Boot 3.2.5
- Docker
- Banco de Dados (PostgreSQL)

## Estrutura do Projeto

O projeto segue os princípios de Domain-Driven Design (DDD) e arquitetura hexagonal, com as seguintes camadas:

- **Camada de Aplicação**: Contém os casos de uso e interfaces de aplicação.

- **Camada de Domínio**: Contém as entidades, objetos de valor, repositórios e serviços de domínio.

- **Camada de Infraestrutura**: Contém as implementações de infraestrutura, como persistência em banco de dados e comunicação com APIs externas.

## Event Storming

O Event Storming encontra-se no seguinte link: `https://miro.com/app/board/uXjVKR1mTMY=/`

## Execução do Projeto

Para executar o projeto localmente, siga estas etapas:

1. Clone o repositório.
2. Execute o comando `docker-compose up --build` para que o build da aplicação aconteça e sejam geradas as imagens e contâineres da aplicação + banco de dados.
3. Acesse o Swagger da aplicação através da URL `http://localhost:8081/swagger-ui/index.html#`.
4. Divirta-se!

## Autores

- [Hennan Cesar Alves Gadelha de Freitas](https://github.com/HennanGadelha)
  (hennangadelhafreitas@gmail.com)

- [Adinelson da Silva Bruhmuller Júnior](https://github.com/Doomwhite)
  (adinelsonsbruhmuller@gmail.com)

- [RAUL DE SOUZA](https://github.com/raulsouza-rm355416)
  (dev.raulsouza@outlook.com)

- [Raphael Soares Teodoro](https://github.com/raphasteodoro)
  (raphael.s.teodoro@outlook.com)

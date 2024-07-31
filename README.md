# Avalanches!

Bem-vindo ao Avalanches, onde a alegria de comer bem encontra o espírito aventureiro! Prepare-se para uma avalanche de sabores deliciosos que vão deixar você emocionado. De hambúrgueres suculentos a milkshakes saborosos, cada mordida é uma jornada de sabor única. Nossa equipe calorosa está aqui para garantir que sua experiência seja sempre memorável.

## Funcionalidades Principais 

### Para Clientes
- **Cadastro de Clientes**: Registre-se para receber novidades e promoções.
- **Sistema de Pedidos**: Faça seu pedido diretamente do nosso cardápio delicioso.

### Internas

- **Cadastro de Produtos**: Adicione novos itens ao cardápio.
- **Consulta de Produtos**: Consulte todos os produtos disponíveis.
- **Atualização de Produtos**: Mantenha o cardápio atualizado.
- **Exclusão de Produtos**: Exclua produtos que não fazem mais parte do cardápio.
- **Cadastro de Clientes**: Cadastre novos clientes a fim de oferecer promoções e descontos.
- **Consulta de Clientes**: Consulte os clientes cadastrados no sistema.
- **Atualização de Clientes**: Mantenha o cadastro de clientes atualizado.
- **Cadastro de Pedidos**: Crie novos pedidos.
- **Listagem de Pedidos**: Consulte todos os pedidos em andamento.
- **Atualização de Status de Pedido**: Atualize o status dos pedidos conforme o progresso na linha de produção.
- **Integração de pagamento**: Integração com API de pagamentos.
- **Status de pagamento**: Acompanhe o status dos pagamentos.

## Tecnologias Utilizadas

- Java 18
- Spring Boot 3.2.5
- Docker
- Kubernetes (Minikube)
- Banco de Dados PostgreSQL

## Estrutura do Projeto

O projeto segue os princípios de Domain-Driven Design (DDD) e clean architecture, com as seguintes camadas:

- **Frameworks and Drivers**: Contém a web api e as configurações de banco de dados.

- **Interface Adapters**: Contém os gateways que garantem a comunicação com o mundo externo (Banco de dados, sistema de arquivos, api de pagamentos etc...),
e os adaptadores que ajudam a camada de apresentação a exibir resultados.

- **Application Business Rules**:  Encapsula e implementa as regras de negócio através de casos de uso.

- **Enterprise Business Rules**:  Representa a camada de entidades e suas regras de negócio.

Vídeo explicando arquitetura: https://www.youtube.com/watch?v=D3DeARWrG60

## Event Storming

O Event Storming encontra-se no seguinte link: `https://miro.com/app/board/uXjVKR1mTMY=/`

## Execução do Projeto em Kubernetes

### Requisitos tecnológicos:
- **[Docker](https://www.docker.com/)**: para a criação de imagens de contêineres.
- **[Minikube](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download)**: para a execução de um cluster Kubernetes local.

Para executar o projeto em Kubernetes, siga estas etapas:

1. Clone o repositório.
   ```bash
   git clone https://github.com/POSTECH-SOAT-SALA11/Avalanches.git
   ```

2. Acesse o repositório.
   ```bash
   cd Avalanches
   ```

3. Execute o script que inicializará o projeto automaticamente.
   ```bash
   ./start_minikube.sh
    ```

4. Acesse o Swagger da aplicação em:
   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```

6. Divirta-se explorando a API via Swagger! 
Exemplos de requisição: https://github.com/POSTECH-SOAT-SALA11/Avalanches/wiki/Exemplos-de-Requisi%C3%A7%C3%A3o

## Execução do Projeto Localmente

Para executar o projeto localmente, siga estas etapas:

1. Clone o repositório.
2. Execute o comando `docker-compose up --build` para que o build da aplicação aconteça e sejam geradas as imagens e contâineres da aplicação + banco de dados.
3. Acesse o Swagger da aplicação através da URL `http://localhost:8080/swagger-ui/index.html#`.
4. Exemplos de requisição: https://github.com/POSTECH-SOAT-SALA11/Avalanches/wiki/Exemplos-de-Requisi%C3%A7%C3%A3o
5. Divirta-se!


## Autores

- [Hennan Cesar Alves Gadelha de Freitas](https://github.com/HennanGadelha)
  (hennangadelhafreitas@gmail.com)

- [Adinelson da Silva Bruhmuller Júnior](https://github.com/Doomwhite)
  (adinelsonsbruhmuller@gmail.com)

- [RAUL DE SOUZA](https://github.com/raulsouza-rm355416)
  (dev.raulsouza@outlook.com)

- [Raphael Soares Teodoro](https://github.com/raphasteodoro)
  (raphael.s.teodoro@outlook.com)
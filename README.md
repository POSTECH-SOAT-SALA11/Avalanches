# Avalanches!

Bem-vindo ao Avalanches, onde a alegria de comer bem encontra o espírito aventureiro! Prepare-se para uma avalanche de sabores deliciosos que vão deixar você emocionado. De hambúrgueres suculentos a milkshakes saborosos, cada mordida é uma jornada de sabor única. Nossa equipe calorosa está aqui para garantir que sua experiência seja sempre memorável.

## Funcionalidades Principais

### Para Clientes

- **Cadastro de Clientes**: Registre-se para receber novidades e promoções.
- **Sistema de Pedidos**: Faça seu pedido diretamente do nosso cardápio delicioso.

### Internas

- **Cadastro de Produtos**: Adicione novos itens ao cardápio.
- **Consulta e Atualização de Produtos**: Mantenha o cardápio atualizado.
- **Consulta e Atualização de Clientes**: Gerencie informações dos clientes.

## Tecnologias Utilizadas

- Java 18
- Spring Boot 3.2.5
- Docker
- Kubernetes (Minikube)
- Banco de Dados PostgreSQL

## Estrutura do Projeto

O projeto segue os princípios de Domain-Driven Design (DDD) e arquitetura hexagonal:

- **Camada de Aplicação**: Contém casos de uso e interfaces.
- **Camada de Domínio**: Entidades, objetos de valor, repositórios e serviços.
- **Camada de Infraestrutura**: Implementações de persistência e integrações.

## Execução do Projeto em Kubernetes

Para executar o projeto em Kubernetes, siga estas etapas:

1. Clone o repositório.
   ```bash
   git clone https://github.com/POSTECH-SOAT-SALA11/Avalanches.git
   cd Avalanches
   ```

2. Inicie o Minikube.
   ```bash
   minikube start
   ```

3. Aplique os manifestos do Kubernetes.
   ```bash
   kubectl apply -f kubernetes/
    ```
   
4. Verifique o status dos pods.
   ```bash
   kubectl get pods
   ```

5. Acesse o Swagger da aplicação.
   ```bash
   minikube service avalanches-service --url
   ```

6. Divirta-se explorando a API via Swagger!
   Não esqueça de acrescentar o contexto `/swagger-ui/index.html#/` ao final da URL. 

## Event Storming

O diagrama do Event Storming pode ser acessado [aqui](https://miro.com/app/board/uXjVKR1mTMY=/).

## Autores

- [Hennan Cesar Alves Gadelha de Freitas](https://github.com/HennanGadelha)
  (hennangadelhafreitas@gmail.com)

- [Adinelson da Silva Bruhmuller Júnior](https://github.com/Doomwhite)
  (adinelsonsbruhmuller@gmail.com)

- [Raul de Souza](https://github.com/raulsouza-rm355416)
  (dev.raulsouza@outlook.com)

- [Raphael Soares Teodoro](https://github.com/raphasteodoro)
  (raphael.s.teodoro@outlook.com)
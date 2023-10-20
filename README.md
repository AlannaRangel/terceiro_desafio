# Sistema de Gerenciamento de Tomada de Decisões

Este repositório contém a implementação de um sistema de back-end para gerenciar processos de tomada de decisões de uma empresa, permitindo que equipes proponham e votem em melhorias internas. O sistema é baseado em microserviços e fornece uma API REST.

**Como executar a aplicação:**

1. Eureka (Service Discovery)
Primeiro, inicie o serviço Eureka, que é responsável pelo registro e descoberta de microserviços na rede. Isso garante que nossos serviços possam se comunicar entre si.
``cd eurekaservice
mvn spring-boot:run``

2. API Gateway
Em seguida, inicie o API Gateway, que atua como ponto de entrada para as solicitações dos clientes, roteando-as para os microserviços apropriados.
``cd api_gateway
mvn spring-boot:run``

3. Microserviço de Propostas
O microserviço de Propostas permite o registro de novas propostas de melhoria. Inicie-o da seguinte forma:
``cd proposta_service
mvn spring-boot:run``

4. Microserviço de Votação
O microserviço de Votação gerencia as sessões de votação e contabiliza os votos dos funcionários. Inicie-o da seguinte forma:
``cd votacao_service
mvn spring-boot:run``

5. Microserviço de Funcionários
O microserviço de Funcionários é responsável por gerenciar as informações dos funcionários, como seus IDs únicos. Inicie-o da seguinte forma:
``cd funcionarios_service
mvn spring-boot:run``

**Funcionalidades da API REST**

``POST /propostas``: Registra uma nova proposta de melhoria.

``POST /votacao``: Inicia uma sessão de votação para uma proposta.

``POST /votacao/{propostaId}/{funcionarioId}/{voto}``: Registra o voto de um funcionário ('Aprovar' ou 'Rejeitar') em uma proposta.

``GET /votacao/{propostaId}``: Retorna o resultado da votação para uma proposta.

Exemplos de requisições na pasta "Resultados das requisições".

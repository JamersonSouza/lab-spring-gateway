# Projeto Spring Gateway com Microserviços e Fallback

Este projeto demonstra a configuração do Spring Gateway com dois microserviços, que são responsáveis apenas por listar os nomes aleatórios de clientes. Quando um dos serviços falha, o Spring Gateway utiliza uma estratégia de fallback para redirecionar a requisição para outra API.

## Estrutura do Projeto

- **Spring Gateway**: Configurado para rotear requisições e tratar erros utilizando fallback para garantir a resiliência da aplicação.
- **Microserviço 1 e Microserviço 2**: Cada um desses microserviços tem um endpoint simples que lista nomes de clientes. 
- **Fallback**: Em caso de falha em uma API, o gateway redireciona a requisição para outro microserviço de forma transparente.

## Tecnologias Usadas

- Spring Cloud Gateway
- Spring WebFlux (para o gateway)

  
## Funcionalidade do Gateway

O Spring Gateway está configurado para fazer o roteamento de requisições para os dois microserviços de clientes. Quando uma falha é detectada em um dos microserviços, o gateway acionará um fallback que faz a requisição para o outro microserviço.
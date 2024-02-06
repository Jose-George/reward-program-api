## Programa de pontos

Microserviço elaborado com o objetivo de simular um sistema em pequena escala de pontos, no qual é possível cadastrar um cliente, calcular pontuações por nível e determinar o nível do cliente com base na quantidade de transações.
O sistema foi desenvolvido utilizando o framework **micronaut** na versão 4.


### Instruções e comandos para execução

Baixa as Dependências: 

`mvn clean install`

Rodar os testes:

`mvn test`

Em seguida realizar o start da aplicação. 

### Versão do Java 

Foi utilizado o java 21. 


### Principais tecnologias 

* Java
* Micronaut
* H2
* Jpa
* Mockito
* Junit
* Lombok

### Arquitetura
A aplicação foi implementada utilizando a Clean Architecture.
consulte mais informações sobre [Clean Architecture](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6).


### Sobre

#### Decisões tomadas que não estavam descritas no documento 

O procedimento de execução da aplicação ocorre da seguinte forma:

1. Inicialmente, efetua-se o cadastro do usuário.
2. Em seguida, realiza-se uma transação.
3. Posteriormente, é criado o nível.
4. Subsequentemente, é gerada a pontuação.
5. Por fim, procede-se à consulta do nível e pontuação.


### Funcionalidades solicitadas que não foram desenvolvidas e o porquê;

Os endpoints relativos às operações de **edição e remoção por identificação** ainda não foram implementados. Houve alguns contratempos que impediram a conclusão dessas funcionalidades no tempo disponível.

### Maior desafio encontrado durante o desenvolvimento do projeto;

O maior desafio enfrentado durante o projeto foi a ausência de experiência prévia com o Micronaut. A falta de familiaridade demandou um esforço adicional na compreensão das nuances do Micronaut, e tornou evidente a necessidade de uma documentação mais abrangente e assertiva. Além disso, observou-se que a comunidade em torno do Micronaut ainda não alcançou uma dimensão considerável.

Apesar desses obstáculos, foi possível perceber claramente os problemas específicos que o Micronaut resolve de maneira eficaz. Essa constatação gerou uma apreciação pela eficiência e utilidade do framework, mesmo diante dos desafios iniciais.


#### Observacao 

Gostaria de expressar minhas sinceras desculpas pela cobertura de testes no projeto. Infelizmente, enfrentei um imprevisto inesperado esta semana que comprometeu minha capacidade de dedicar tempo ao desenvolvimento e à realização dos testes adequados. Foram realizados testes mas não na cobertura adequada.

Se for possível, gostaria que visitassem o repositório, um projeto no qual realizei alguns testes [link](https://github.com/Jose-George/pool-vouchers).
### Documentação

1. Acesse a interface dos recursos do backend através do swagger usando o endereço local: http://localhost:8080/swagger-ui

### Rotas

# API Documentation

## Customer Operations

### Create Customer
- **Endpoint:** `POST` `localhost:8080/customer/create`

  _Request:_
  ```json
  {
    "name": "Joao Bosco",
    "cpf": "123.123.123-12",
    "email": "joaobosco@teste.com",
    "dateBirth": "12/12/1980"
  }
  ```

  _Response:_
  ```json
  {
    "id": "af02b6dd-0917-49f8-9c13-d72b282bd378",
    "name": "Joao Bosco",
    "email": "joaobosco@teste.com"
  }
  ```

### Edit Customer
- **Endpoint:** `PUT` `localhost:8080/customer/edit/a564c4cc-3122-4fc9-b918-8e2b4e26d774`

  _Request:_
  ```json
  {
    "name": "São Joao Bosco",
    "cpf": "123.123.123-12",
    "email": "joaobosco@teste.com",
    "dateBirth": "12/12/2023"
  }
  ```

  _Response:_
  ```json
  {
    "id": "af02b6dd-0917-49f8-9c13-d72b282bd378",
    "name": "São Joao Bosco",
    "email": "joaobosco@teste.com"
  }
  ```

### Find Customer
- **Endpoint:** `GET` `localhost:8080/customer/find/123.123.123-12`

### Delete Customer
- **Endpoint:** `DELETE` `localhost:8080/customer/delete/123.123.123-12`

## Transaction Operations

### Create Transaction
- **Endpoint:** `POST` `localhost:8080/transaction/create`

  _Request:_
  ```json
  {
    "type": "TIPO_1",
    "cpf": "123.123.123-12",
    "amount": "300",
    "storeBuy": "loja de seu Zé"
  }
  ```

  _Response:_
  ```json
  {
    "id": "2f41ff51-7e4a-4e0a-a538-5e946ed6ebc3",
    "amount": "300.0",
    "date": "2024-02-05T18:57:09.912155-03:00"
  }
  ```

## Level Operations

### Create Level
- **Endpoint:** `POST` `localhost:8080/level/create`

  _Request:_
  ```json
  {
    "cpf": "123.123.123-12"
  }
  ```

  _Response:_
  ```json
  {
    "id": "c20ab8bc-f341-46ec-8c3c-a9764cf12227",
    "level": "LEVEL_ONE"
  }
  ```

### Find Level
- **Endpoint:** `GET` `localhost:8080/level/find/123.123.123-12`

  _Response:_
  ```json
  {
    "level": "LEVEL_ONE",
    "score": 30
  }
  ```

## Score Operations

### Create Score
- **Endpoint:** `POST` `localhost:8080/score/create`

  _Request:_
  ```json
  {
    "cpf": "123.123.123-12",
    "origin": "qualquer",
    "transactionId": "ceea8fa5-c3e8-4b89-a8ad-358a5ed60aa7",
    "level": "LEVEL_ONE"
  }
  ```

  _Response:_
  ```json
  {
    "id": "6014d0fb-2a84-479b-a2e5-e0152f8fefe1",
    "score": 30
  }
  ```


## Score and Level 

### Find Score and Level By Customer ID 

- **Endpoint:** `POST` `localhost:8080/level/find/123.123.123-12`

_Response:_
  ```json
 {
  "level": "LEVEL_ONE",
  "score": 30
}
  ```
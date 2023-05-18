# API de Vendas com Spring Boot

Esta é uma simples API de vendas desenvolvida com Spring Boot. A API permite a criação de vendas e fornece informações sobre vendedores com base no período especificado.


## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (banco de dados em memória)


## Endpoints da API

A API possui os seguintes endpoints principais:

- ``GET /vendas`` : Retorna todas as vendas registradas.
- ``POST /vendas`` : Cria uma nova venda.
- ``GET /vendas/vendedores?dataInicial={dataInicial}&dataFinal={dataFinal}`` : Retorna um resumo das vendas por vendedor para o período especificado.

## Estrutura do projeto

```bash
src
 ├── main
 │   ├── java
 │   │   └── com
 │   │       └── projeto
 │   │           └── salesapiapringboot
 │   │               ├── controller
 │   │               │   └── VendaController.java
 │   │               ├── dto
 │   │               │   ├── VendaDTO.java
 │   │               │   └── VendedorListaDTO.java
 │   │               ├── models
 │   │               │   ├── Venda.java
 │   │               │   └── Vendedor.java
 │   │               ├── projection
 │   │               │   └── VendedorListaProjection.java
 │   │               ├── repositories
 │   │               │   ├── VendaRepository.java
 │   │               │   └── VendedorRepository.java
 │   │               ├── services
 │   │               │   └── VendaService.java
 │   │               └── SalesApiApringbootApplication.java
 │   └── resouces
 │       └── application.properties
 └── test
```

O projeto está organizado da seguinte maneira:

- O pacote controller contém o controlador da API, responsável por mapear e lidar com as requisições HTTP.
- O pacote dto contém os objetos de transferência de dados usados para serializar e desserializar as informações da API.
- O pacote models contém as entidades JPA que representam as tabelas do banco de dados.
- O pacote projection contém a interface de projeção usada para a obtenção do resumo das vendas por vendedor.
- O pacote repositories contém as interfaces de repositório que fornecem métodos para acessar e manipular - os dados do banco de dados.
- O pacote services contém a lógica de negócio relacionada às vendas.
- O arquivo application.properties contém as configurações do aplicativo, como a configuração do banco de dados H2 em memória.
- A classe SalesApiApringbootApplication é a classe principal que inicia o aplicativo Spring Boot.
- O diretório test contém os testes unitários para verificar o funcionamento correto da aplicação.


## Modelo Conceitual

```bash
+-----------------+       +------------------+
|    tb_venda     |       |   tb_vendedor    |
+-----------------+       +------------------+
| id (PK)         | *---1 | id (PK)          |
| data_venda      |       | vendedor_nome    |
| valor           |       +------------------+
| vendedor_id (FK)|
+-----------------+
```
## Trechos de código
### import.sql
```sql
INSERT INTO tb_vendedor (vendedor_nome) VALUES ('Gustavo Silva');
INSERT INTO tb_vendedor (vendedor_nome) VALUES ('Maria Santos');
INSERT INTO tb_vendedor (vendedor_nome) VALUES ('Pedro Oliveira');
INSERT INTO tb_vendedor (vendedor_nome) VALUES ('Ana Souza');
INSERT INTO tb_vendedor (vendedor_nome) VALUES ('Carlos Pereira');

INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-01', 100.50, 1);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-02', 75.20, 2);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-03', 230.80, 3);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-04', 150.00, 4);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-05', 320.75, 5);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-01', 85.60, 1);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-02', 200.00, 2);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-03', 180.90, 3);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-04', 50.30, 4);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-05', 120.70, 5);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-01', 300.25, 1);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-02', 90.40, 2);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-03', 175.60, 3);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-04', 210.00, 4);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-05', 280.80, 5);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-01', 64.90, 1);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-02', 190.50, 2);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-03', 150.20, 3);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-04', 40.80, 4);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-05', 135.70, 5);
INSERT INTO tb_venda (data_venda, valor, vendedor_id) VALUES ('2023-05-01', 1000.00, 1);
```

### API Vendas.postman_collection.json
```json
{
	"info": {
		"_postman_id": "4c09ff24-c9fd-4bb5-8a23-9362876a7585",
		"name": "API Vendas",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "27273369",
		"_collection_link": "https://crimson-meadow-573613.postman.co/workspace/API-Venda~98caf18f-257f-4d73-b6eb-fd6e8d64e5f4/collection/27273369-4c09ff24-c9fd-4bb5-8a23-9362876a7585?action=share&creator=27273369&source=collection_link"
	},
	"item": [
		{
			"name": "Vendas",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/vendas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"vendas"
					]
				}
			},
			"response": []
		},
		{
			"name": "Criar Venda",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"dataVenda\": \"2023-05-05\",\r\n    \"valor\": 100.0,\r\n    \"vendedorId\": 3\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/vendas",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"vendas"
					]
				}
			},
			"response": []
		},
		{
			"name": "Lista Vendedores",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/vendas/vendedores?dataInicial=2023-05-01&dataFinal=2023-05-05",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"vendas",
						"vendedores"
					],
					"query": [
						{
							"key": "dataInicial",
							"value": "2023-05-01"
						},
						{
							"key": "dataFinal",
							"value": "2023-05-05"
						}
					]
				}
			},
			"response": []
		}
	]
}
```

## Contato

Em caso de dúvidas ou sugestões, entre em contato com **Gustavo Luche** via e-mail: gluche08&#64;gmail.com.

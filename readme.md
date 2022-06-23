# Lab de Arquitetura - Core da Aplicação
Modelo de arquitetura para isolar as `regras de negócio` de uma aplicação.

![Arquitetura](./docs/Arquitetura.png)

## Application Services
Casos de usos


## Domain Services
Regras de negócio


## Model
Entidades do negócio


## Value Objects
Agregados


## DTO
Data transfer objects

## Builders
Ao invés de `criar instâncias de classes diretamente`, opte por usar métodos builders ou factories


## Interfaces
Sempre que precisar definir algo que seja provido fora do Core, use uma interface para expor os métodos que precisa. Assim pode implementar da forma que for apropriada sem criar dependências dentro do Core
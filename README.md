# Gerenciador de Casos Jurídicos (Java)

Este projeto simula um sistema de gerenciamento de casos jurídicos para um escritório de advocacia, utilizando **Programação Orientada a Objetos (POO)** em Java.

Ele permite o cadastro de clientes, advogados e processos judiciais, com controle de prazos, validações detalhadas e arquivamento automático de processos vencidos.

---

## Funcionalidades

- Cadastro de clientes e advogados com validações (CPF, OAB, e-mail, telefone)
- Criação de processos com controle de prazo e status
- Arquivamento automático de processos vencidos
- Listagem de processos por status (`EM_ANDAMENTO`, `ARQUIVADO`)
- Exibição de resumos detalhados de cada processo
- Tratamento de exceções com mensagens informativas

---

## Tecnologias utilizadas

- Java 21.0.6
- Paradigma de Programação Orientada a Objetos
- API `java.time.LocalDate` para manipulação de datas

---

## Como executar

1. Clone ou baixe o repositório

2. Abra em sua IDE Java

3. Compile e execute o arquivo Main.java


## Estrutura do Projeto
```
src/
├── pessoas/
│   ├── Pessoa.java
│   ├── Cliente.java
│   └── Advogado.java
├── processos/
│   ├── Processo.java
│   └── Status.java
├── escritorio/
│   └── Escritorio.java
└── Main.java
```

## Este projeto foi desenvolvido para praticar os conceitos centrais de POO:

Abstração com classes base

Herança e polimorfismo

Encapsulamento com validações

Uso de coleções (List, Map)

Tratamento de exceções

Separação de responsabilidades

## Autor
Desenvolvido por Josevan Tavares como projeto pessoal de aprendizado e demonstração de habilidades em Java.

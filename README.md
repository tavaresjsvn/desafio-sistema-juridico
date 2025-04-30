# Desafio de POO: Sistema de Gerenciamento de Casos Jurídicos

## Contexto
Você foi contratado para desenvolver um sistema de gerenciamento de casos para um escritório de advocacia. O sistema deve permitir o cadastro de clientes, advogados, processos jurídicos e acompanhamento de prazos, utilizando conceitos de **Programação Orientada a Objetos (POO)** em Java.

## Objetivos
- Aplicar herança e polimorfismo para modelar diferentes tipos de processos
- Utilizar encapsulamento para proteger dados sensíveis
- Implementar coleções (`List`, `Map`) para gerenciar casos e prazos
- Praticar tratamento de exceções para validar dados

## Requisitos do Sistema

### 1. Estrutura de Classes

#### Classe Abstrata `Pessoa`
**Atributos**:
- `nome` (String)
- `CPF` (String, válido)
- `telefone` (String, formato "(XX) XXXX-XXXX")
- `email` (String, deve conter "@" e ".")

**Métodos**:
- Getters e setters com validações:
- `abstract String getTipo()` (retorna "Cliente" ou "Advogado")

#### Classes Concretas

1. **`Cliente`** (herda de `Pessoa`)
   - Atributo adicional: `profissao` (String)
   - Implementa `getTipo()`

2. **`Advogado`** (herda de `Pessoa`)
   - Atributo adicional: `OAB` (String, formato "OAB/UF-XXXXX")
   - Implementa `getTipo()`

3. **`Processo`**
   **Atributos**:
   - `numeroProcesso` (String, único)
   - `cliente` (associação com `Cliente`)
   - `advogadoResponsavel` (associação com `Advogado`)
   - `descricao` (String)
   - `prazo` (LocalDate)
   - `status` (Enum: `EM_ANDAMENTO`, `ARQUIVADO`, `ENCERRADO`)

   **Métodos**:
   - `boolean prazoVencido()`
   - `String resumoProcesso()`

4. **`Escritorio`** (classe principal)
   **Atributos**:
   - `List<Processo> processos`
   - `Map<String, Cliente> clientes` (CPF como chave)
   - `Map<String, Advogado> advogados` (CPF como chave)

   **Métodos**:
   - `void adicionarCliente(Cliente cliente)`
   - `void adicionarAdvogado(Advogado advogado)`
   - `void adicionarProcesso(Processo processo)`
   - `List<Processo> listarProcessosPorStatus(Status status)`
   - `void notificarPrazosVencidos()`

### 2. Regras de Negócio

1. **Validações**:
   - CPF deve ter 11 dígitos
   - OAB deve seguir o padrão "OAB/UF-XXXXX"
   - Nâo é possível participar de um processo se algum campo estiver nulo/vazio

2. **Funcionalidades**:
   - Um cliente pode ter múltiplos processos
   - Um advogado pode estar associado a vários processos
   - O sistema deve evitar duplicação de CPF/OAB

3. **Casos Especiais**:
   - Processos com prazo vencido devem ter status "ARQUIVADO"
   - Advogados não podem ser clientes do escritório

### Saída Esperada:

- Processo: 2023-001
- Cliente: João Silva (Engenheiro)
- Advogado: Maria Souza (OAB/SP-12345)
- Status: EM_ANDAMENTO
- Prazo: 31/12/2023 (Vence em 30 dias)


## Estrutura de Pacotes
```
├── src/
│   ├── pessoas/
│   │   ├── Pessoa.java
│   │   ├── Cliente.java
│   │   └── Advogado.java
│   ├── processos/
│   │   ├── Processo.java
│   │   └── Status.java (Enum)
│   ├── escritorio/
│   │   └── Escritorio.java
│   └── Main.java
```

## Entrega

Em Main.java, demonstre:

 - Cadastro de pelo menos 2 clientes e 1 advogado

 - Criação de 3 processos com prazos diferentes

 - Chamada para notificarPrazosVencidos()

**Dicas**

Use LocalDate para prazos

Para validações, lance IllegalArgumentException

Sobrescreva toString() para exibir informações formatadas
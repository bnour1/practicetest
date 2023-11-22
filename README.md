# Projeto Java - Orientação a Objetos
## Este projeto Java foi desenvolvido como parte de um processo seletivo para a empresa Sinergi. Ele utiliza conceitos de Orientação a Objetos e inclui implementações para diversas funcionalidades relacionadas à folha de pagamento e vendas, Utilizando o padrão de projeto Strategy em suas implementações.

### Estrutura do Projeto
#### O projeto possui a seguinte estrutura:

|-- src
|   |-- com
|       |-- sinerji
|           |-- models
|           |   |-- *Entidades utilizadas*
|           |-- services
|           |   |-- CalculadorValor.java
|           |   |-- DateStringParser.java
|           |   |-- strategies
|           |       |-- *Estratégias de negócio*
|           |           |-- interfaces
|           |               |-- *Interfaces Strategy*
Cargo.java: Define a classe Cargo com as informações sobre os cargos.
Funcionario.java: Define a classe abstrata Funcionario com atributos e métodos comuns a todos os funcionários.
Vendedor.java: Implementa a classe Vendedor, que é uma extensão de Funcionario e inclui métodos específicos para vendas da interface Vendas.
Secretario.java: Extensão de Funcionário
Gerente.java: Extensão de Funcionário
CalculadorValores.java: Contém a classe principal que determina a Strategy para realizar os calculos e a executa.
SeletorFuncionario.java: Contém a classe principal que determina a Strategy para obter objetos e a executa.

#### Outros classes utilizadas do projeto

#### Helpers:
DateStringParser.java: Implementa um parser para converter strings em objetos Date.
CalcularSalarioComReajuste.java: Implementa uma logica que juntamente com o parser calcula o salario com reajuste anual dos funcionarios.

### Funcionalidades Implementadas
#### O projeto inclui as seguintes funcionalidades:

Método que calcula o valor total pago (salário e benefício) a funcionários em um determinado mês.
Método que calcula o total pago apenas em salários a funcionários em um determinado mês.
Método que calcula o total pago em benefícios a funcionários que recebem benefícios em um determinado mês.
Método que encontra o funcionário que recebeu o maior valor no mês.
Método que encontra o nome do funcionário que recebeu o maior valor em benefícios no mês.
Método que encontra o vendedor que mais vendeu em um determinado mês.


### Como Utilizar
## Para utilizar o código, basta clonar este repositório:

### git clone https://github.com/seu-usuario/seu-repositorio.git
## Em seguida, você pode explorar e executar o código em sua IDE Java favorita.

#### Contribuições
## Contribuições são bem-vindas! Sinta-se à vontade para propor melhorias, reportar problemas ou adicionar novas funcionalidades.

##### Licença
### Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para detalhes.
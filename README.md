# Sistema de Gerenciamento de Hierarquia de Colaboradores

O sistema permite o cadastro, atualização, leitura e deleção (CRUD) de colaboradores dentro de uma organização, além de visualizar e gerenciar a hierarquia entre eles. Também é possível visualizar a força das senhas dos colaboradores conforme as regras definidas.

## Funcionalidades

- **CRUD de Colaboradores**: 
  - Criação, leitura de colaboradores.
  
- **Visualização de Hierarquia**:
  - Representação gráfica ou em lista da hierarquia de colaboradores dentro da organização.
  - Facilita a compreensão das relações hierárquicas entre os colaboradores.
  
- **Avaliação da Força da Senha**:
  - Análise da força das senhas dos colaboradores com base em regras predefinidas.
  - Indicador visual da força da senha ao lado de cada colaborador.

- **Criptografia**:
  - As senhas dos colaboradores são criptografadas seguindo as regras de [passportmeter](https://passwordmeter.com/) antes de serem armazenadas no banco de dados, garantindo a segurança dos dados.
  
- **Testes Unitários**:
  - Testes unitários para garantir o funcionamento correto da lógica de negócio no backend.

## Tecnologias Utilizadas

- **Frontend**: AngularJS (versão 1)
- **Backend**: Java com Spring Framework
- **Banco de Dados**: MongoDB

## Como Executar

1. Clone o repositório para o seu ambiente local.
2. Configure o banco de dados MongoDB, acessível através da URI `mongodb://localhost:27017`.
3. Atualize o arquivo de configuração com a URI do banco de dados MongoDB.
4. Execute o backend usando Spring Boot.
5. Execute o frontend usando o servidor web integrado do AngularJS ou seu servidor web de preferência.
6. Acesse o aplicativo através do navegador no endereço configurado.

## Clean Architecture

O projeto foi pensado e desenvolvido usando conceitos de Arquitetura Rest e Arquitetura Limpa.

### Como o backend foi pensado?

![Alt text](docs/clean_architecture.png?raw=true "Clean Architecture Cone")

- `businessrule`: Contém os casos de uso (use cases) e regras de negócio da aplicação. Inclui pacotes como `exception` para exceções personalizadas, `message` para serviços de mensagem específicos das regras de negócio, `usecase` para implementações de casos de uso e `validator` para validações personalizadas.

- `domain`: Contém as entidades do domínio, que representam os objetos centrais da sua lógica de negócio.

- `external`: Contém itens relacionados à parte mais externa da aplicação, como configurações gerais. Por exemplo, você pode ter um pacote `configuration` para configurações da aplicação.

- `interfaceadapter`: Contém os itens relacionados ao acesso do usuário à aplicação. `repository` para acessar e obter dados do banco de dados

## Licença

Este projeto é licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

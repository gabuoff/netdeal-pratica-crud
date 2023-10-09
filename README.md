# Sistema de Gerenciamento de Hierarquia de Colaboradores

O sistema permite o cadastro, atualização, leitura e deleção (CRUD) de colaboradores dentro de uma organização, além de visualizar e gerenciar a hierarquia entre eles. Também é possível visualizar a força das senhas dos colaboradores conforme as regras definidas.

## Funcionalidades

- **CRUD de Colaboradores**: 
  - Criação, leitura, atualização e deleção de colaboradores.
  - Interface amigável e intuitiva para a gestão de colaboradores.
  
- **Visualização de Hierarquia**:
  - Representação gráfica ou em lista da hierarquia de colaboradores dentro da organização.
  - Facilita a compreensão das relações hierárquicas entre os colaboradores.
  
- **Avaliação da Força da Senha**:
  - Análise da força das senhas dos colaboradores com base em regras predefinidas.
  - Indicador visual da força da senha ao lado de cada colaborador.

- **Criptografia**:
  - As senhas dos colaboradores são criptografadas antes de serem armazenadas no banco de dados, garantindo a segurança dos dados.
  
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

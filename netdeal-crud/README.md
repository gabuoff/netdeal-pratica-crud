# Frontend do Projeto

Este é o frontend do projeto NETDEALS COLABORADORES, responsável por fornecer uma interface de usuário para interagir com o sistema.

## Estrutura de Clean Architecture

O projeto segue uma arquitetura baseada em Clean Architecture, que visa separar as responsabilidades em camadas distintas para melhorar a modularidade, testabilidade e manutenibilidade do código.

A estrutura do projeto é organizada da seguinte forma:

- `src/`
  - `app/` Contém configurações centrais e inicializações essenciais do projeto.
    - `core/`: Contém os modelos de dados principais que representam o domínio da aplicação.
    - `entities/`: Contém os serviços que se comunicam com endpoints externos, como APIs.
    - `frameworks-and-drivers/http-services`:
    - `interface-adapters/`:Responsável por adaptar os dados entre a camada de frameworks-and-drivers e os usecases.
    - `lib/`:  Bibliotecas e utilitários customizados que são usados em várias partes do projeto.
    - `usecases/`: Contém os services que representam as regras de negócio da aplicação.
    - `views/`: Contém os htmls dos componentes.
## Tecnologias Utilizadas

O frontend do projeto é desenvolvido utilizando as seguintes tecnologias:

- Angular JS 1.7.5: Um framework de desenvolvimento de aplicativos da web em javascritp.
- http-services: Para comunicação com o backend por meio de solicitações HTTP.

## Como Usar

Siga as etapas abaixo para configurar e executar o frontend do projeto:

1. Certifique-se de ter o Node.js instalado em seu ambiente de desenvolvimento.
2. Clone este repositório em sua máquina local.
3. Navegue até o diretório do projeto no terminal.
4. Execute o comando `npm run prestart` para instalar as dependências do projeto.
5. Execute o comando `npm run postinstall` para copiar alguns arquivos para lib do projeto.
6. Execute o comando `npm run start` para rodar o projeto na porta 8000
7. Abra o navegador e acesse `http://localhost:8000` para visualizar o aplicativo.

## Contato

Em caso de dúvidas ou problemas relacionados ao projeto, entre em contato com:

Nome: Gabriel Melo
E-mail: gabrielmeloc@outlook.com

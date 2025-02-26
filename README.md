# Sistema de Cadastro

Este é um sistema de cadastro via linha de comando (CLI) desenvolvido em Java, utilizando os princípios de Orientação a Objetos (OO) e boas práticas de código. O projeto permite que usuários cadastrem informações, editem, excluam e realizem buscas de maneira eficiente, salvando os dados em arquivos .txt.

## 🛠 Tecnologias Utilizadas
- Java
- Java I/O (Leitura e escrita de arquivos)
- Streams & Lambda Expressions
- Tratamento de Exceções

## 📌 Funcionalidades
- ✔ Cadastro de Usuários
- ✔ Listagem de Usuários Cadastrados
- ✔ Adição e Remoção de Perguntas no Formulário
- ✔ Busca de Usuários por Nome, Idade ou Email
- ✔ Validações de Entrada com Tratamento de Exceções

## 📂 Estrutura do Projeto
- formulario.txt: Contém as perguntas do formulário.
- users/: Diretório onde os arquivos .txt de cada usuário são salvos.
- Main.java: Arquivo principal que executa o menu do sistema.
- Usuario.java: Classe que representa um usuário com seus atributos.
- FileManager.java: Classe responsável por manipular os arquivos de entrada e saída.
## 🚀 Como Executar o Projeto
- 1️⃣ Baixe ou clone o repositório
- 2️⃣ Abra o projeto em sua IDE favorita (Eclipse, IntelliJ, VS Code, etc.)
- 3️⃣ Compile e execute o Main.java
- 4️⃣ Siga as instruções exibidas no terminal para navegar no menu

## 🔍 Validações Implementadas
- Nome deve ter pelo menos 10 caracteres
- Email deve conter "@"
- Idade deve ser maior que 18 anos
- Altura deve ser cadastrada no formato "1,75"
- Emails duplicados não são permitidos
- Apenas perguntas da 5ª posição em diante podem ser removidas

## 📌 Melhorias Futuras
- 🚀 Implementação de um banco de dados para armazenar os usuários
- 🚀 Interface gráfica para facilitar a interação
- 🚀 Exportação dos dados em formato JSON ou CSV

💡 Sugestões e contribuições são bem-vindas!



-----

# Controle de Estoque de Equipamentos de Informática

## Projeto de Programação Orientada a Objetos

Este projeto, desenvolvido como parte da disciplina de Programação Orientada a Objetos, tem como objetivo **informatizar a gestão de estoque e vendas** da "MinhaCasaTech". Este empreendimento informal, gerido pelo Sr. Toinho e seu primo Kanalense, comercializa equipamentos de informática.

## Contexto

Atualmente, a "MinhaCasaTech" opera de forma informal na residência dos proprietários. Para modernizar e otimizar suas operações, desenvolvemos um sistema que permite ao Sr. Toinho e Kanalense **cadastrar, gerenciar e comercializar produtos de forma organizada**. Além disso, o software oferece **ferramentas essenciais para o acompanhamento de vendas**, garantindo um controle mais eficiente do negócio.

-----

## Funcionalidades

O sistema oferece as seguintes **funcionalidades principais**:

### 1\. Gestão de Cadastros

* **Equipamentos:**
    * **Cadastro:** Registre novos equipamentos com informações como nome, número de série, preço, quantidade, local de armazenamento e responsável.
    * **Alteração/Edição:** Modifique detalhes de equipamentos existentes com facilidade.
* **Locais:**
    * **Cadastro:** Organize seu estoque definindo locais de armazenamento, como "Casa do Kanalense" e "Cozinha".
* **Responsáveis:**
    * **Cadastro:** Registre os responsáveis pelos equipamentos (Sr. Toinho ou Kanalense), incluindo nome, endereço e telefone.
* **Clientes:**
    * **Cadastro:** Mantenha um registro de seus clientes com nome, endereço e CPF.

### 2\. Pesquisa de Equipamentos

Encontre equipamentos rapidamente utilizando diversos critérios de busca, como:

* Nome
* Número de série
* Responsável
* Local

### 3\. Gestão de Vendas

* **Elaboração de Nota de Venda:** Gere notas fiscais detalhadas para cada transação.
* **Cancelamento de Venda (Devolução):** Registre devoluções e ajuste o estoque de forma automática.

### 4\. Operações de Estoque

* **Compra de Equipamentos:** Registre a entrada de novos itens no estoque.
* **Venda de Equipamentos:** Registre a saída de equipamentos, atualizando o estoque automaticamente após cada venda.

### 5\. Relatórios

* **Relatório de Vendas por Período:** Gere relatórios detalhados das vendas realizadas em um intervalo de tempo específico, com informações completas sobre os equipamentos vendidos.

### 6\. Controle de Acesso

* Apenas o Sr. Toinho e Kanalense possuem permissão para **cadastrar novos equipamentos**, garantindo a integridade e segurança dos dados.

-----

## ⚙️ Instalação

Para configurar e usar o sistema, siga os passos abaixo:

1.  **Instalar dependências:**
    Rode o seguinte comando para instalar as dependências do projeto:

    ```bash
    mvn clean javafx:run
    ```

2.  **Iniciar o banco de dados:**
    Após instalar as dependências, execute o comando abaixo para subir o Docker com o banco de dados configurado:

    ```bash
    docker compose up
    ```

3.  **Popular o banco de dados (Opcional):**
    Para popular o banco de dados com alguns dados iniciais e ter exemplos para testar, execute a classe `Main` do projeto.

-----

Sinta-se à vontade para contribuir ou entrar em contato se tiver alguma dúvida\!
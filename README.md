# First Test Aluno

Projeto acadêmico em **Java** utilizando **Maven**, **JUnit** e **JaCoCo**, desenvolvido com base na metodologia **TDD (Test Driven Development)**.

---

##  Funcionalidades

* Estruturação do projeto com **Maven**.
* Escrita de casos de teste com **JUnit**.
* Relatórios de execução de testes com **Surefire Reports**.
* Relatórios de cobertura de código com **JaCoCo**.
* Prática de **TDD**: escrever testes, implementar código e refatorar mantendo cobertura.

---

##  Tecnologias Utilizadas

* **Java 17+**
* **Maven**
* **JUnit 5**
* **JaCoCo**

---

##  Como Executar

### 1️⃣ Clone o repositório:

```sh
git clone https://github.com/joaorafael1504/first-test-aluno.git
cd first-test-aluno
```

### 2️⃣ Compile e rode os testes:

```sh
mvn clean test
```

### 3️⃣ Gerar relatório de cobertura:

```sh
mvn jacoco:report
```

O relatório estará disponível em:
 `target/site/jacoco/index.html`

### 4️⃣ Relatório de testes JUnit:

Os relatórios de execução estarão disponíveis em:
 `target/surefire-reports`

---

##  Estrutura do Projeto

```plaintext
first-test-aluno/
 ├── src/
 │   ├── main/java/...   # Código fonte principal
 │   └── test/java/...   # Casos de teste com JUnit
 ├── target/             # Arquivos compilados e relatórios
 ├── pom.xml             # Configuração Maven do projeto
```

---

##  Metodologia TDD

* **Passo 1:** Criar casos de teste que inicialmente falham.
* **Passo 2:** Implementar o código mínimo necessário para os testes passarem.
* **Passo 3:** Refatorar o código, garantindo que os testes continuem passando.

Relatórios de cobertura (**JaCoCo**) e execução de testes (**JUnit**) foram utilizados para validar cada etapa.

---

##  User Story

**Como** um aluno assinante básico
**Quero** liberar mais 3 cursos ao concluir um curso com média acima de 7,0
**Para** continuar ampliando meus estudos e ter acesso contínuo a novos conteúdos.

---

##  BDDs

### BDD 1 – Cenário de Sucesso

**Dado** que sou um aluno assinante básico
**E** finalizei um curso com média 8
**Quando** o sistema validar minha nota
**Então** devo ter acesso liberado automaticamente a mais 3 cursos.

---

### BDD 2 – Cenário de Fracasso

**Dado** que sou um aluno assinante básico
**E** finalizei um curso com média 6,5
**Quando** o sistema validar minha nota
**Então** não devo receber a liberação de novos cursos.

---

### BDD 3 – Cenário de Upgrade para Premium

**Dado** que sou um aluno assinante básico
**E** concluí mais de 12 cursos com média acima de 7,0
**Quando** o sistema verificar que concluí mais de 12 cursos
**Então** meu plano deve mudar para Premium.

---

### BDD 4 – Cenário de Prevenção de Benefício Duplicado

**Dado** que o aluno concluiu um curso com média 8,5
**E** já recebeu 3 cursos adicionais por esse resultado
**Quando** o sistema processar novamente a conclusão do mesmo curso
**Então** o saldo de cursos do aluno não deve aumentar.

---

##  Autores

Desenvolvido por:

* João Rafael
* Milton Penha
* Mateus Nauhan
* Felipe Rusig

---

##  Licença

Este projeto está sob a licença MIT.
Sinta-se livre para contribuir! 

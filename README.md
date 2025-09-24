# User Story

**Como** um aluno assinante básico  
**Quero** liberar mais 3 cursos ao concluir um curso com média acima de 7,0  
**Para** continuar ampliando meus estudos e ter acesso contínuo a novos conteúdos.  

---

# BDDs

## BDD 1 – Cenário de Sucesso
**Dado** que sou um aluno assinante básico  
**E** finalizei um curso com média 8  
**Quando** o sistema validar minha nota  
**Então** devo ter acesso liberado automaticamente a mais 3 cursos.  

---

## BDD 2 – Cenário de Fracasso
**Dado** que sou um aluno assinante básico  
**E** finalizei um curso com média 6,5  
**Quando** o sistema validar minha nota  
**Então** não devo receber a liberação de novos cursos.  

---

## BDD 3 – Cenário de Upgrade para Premium
**Dado** que sou um aluno assinante básico  
**E** concluí mais de 12 cursos com média acima de 7,0  
**Quando** o sistema verificar que concluí mais de 12 cursos  
**Então** meu plano deve mudar para Premium.  

---

## BDD 4 – Cenário de Prevenção de Benefício Duplicado
**Dado** que o aluno concluiu um curso com média 8,5  
**E** já recebeu 3 cursos adicionais por esse resultado  
**Quando** o sistema processar novamente a conclusão do mesmo curso  
**Então** o saldo de cursos do aluno não deve aumentar.  

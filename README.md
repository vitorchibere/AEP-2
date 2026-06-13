# Sistema de Feedbacks voltado a Postos de Saúde 
 
  Nosso projeto consiste no desenvolvimento de um sistesma voltado aos serviços públicos de saúde, especificamente dos postos de saúde,  tendo como principal objetivo a facilidade de uso e a acessibilidade. A proposta é de que qualquer usuário, até os que não possuem familiaridade digital, consiga avaliar o atendimento de forma rápida e intuitiva.

  Previsto que muitas pessoas em vulnerabilidade não conseguem avaliar e até denunciar determinadas atitudes dos profissionais, e muitos dos casos não são vistos realmente ou sequer resolvidos. 

  Este sistema possui uma avaliação de notas de 0 a 5 e um comentario sobre o atendimento prestado pelos médicos, enfermeiros e até sobre a estrutura do Posto de Saúde. Todo o feedback é realizado de forma anônima, tendo em vista que os únicos que terão acesso a seus dados são os que receberão os feedbacks, o Diretor Tecnico Medico, a Enfermeira Chefe e o Gestor. Cada feedback vai para seu determinado setor. Eles que irão analisar e tomar uma decisão diante disso para melhorias continuas dos serviços oferecidos.


## Membros 

 Rafaela Tanaka Cardoso  RA: 24062611-2
 
 Vitor Hugo da Costa     RA: 23234248-2
      

  ## Funcionalidade
### Area do Paciente
  ⚫ Registrar novo feedback
  
  ⚫ Escolher categoria
  
  ⚫ Acompanhar status da solicitacao
  
### Area do Medico
  ⚪ Nome dos Medicos
  
  ⚪ Especialidades dos Medicos
  

## Tela do Diretor/Gestor/Enfermeira Chefe
  🔴 Vizualizar feedabacks
  
  🔴 Determina status do feedback


## Categorias de cada Solicitação
  🔵 Mostra qual categoria Medicos/Enfemeiros/Infraestrutura selecionar para fazer o feeback


## Linguagem utilizada
  <img align="center" title="Java" width="50" src="https://github.com/user-attachments/assets/b1095693-664a-4a29-9dd1-4841cf0718f0">




## Estrutura do sistema

```
src
└── main
    ├── java
    │   └── com.observaacao.observa_acao
    │
    │       ├── ObservaAcaoApplication.java
    │       ├── DataLoader.java
    │
    │       ├── controller
    │       │   ├── HomeController.java
    │       │   ├── AvaliacaoController.java
    │       │   ├── SolicitacoesController.java
    │       │   ├── EquipeController.java
    │       │   ├── MedicoController.java
    │       │   └── PacienteController.java
    │
    │       ├── model
    │       │   ├── Paciente.java
    │       │   ├── Medico.java
    │       │   ├── UnidadeSaude.java
    │       │   └── Solicitacoes.java
    │
    │       ├── enums
    │       │   ├── Categoria.java
    │       │   └── AcompanhamentoDeStatus.java
    │
    │       ├── repository
    │       │   ├── PacienteRepository.java
    │       │   ├── MedicoRepository.java
    │       │   ├── UnidadeSaudeRepository.java
    │       │   └── SolicitacoesRepository.java
    │
    │       └── service
    │           ├── PacienteService.java
    │           ├── MedicoService.java
    │           ├── UnidadeSaudeService.java
    │           └── SolicitacoesService.java
    │
    └── resources
        │
        ├── application.properties
        │
        ├── static
        │   └── css
        │       └── style.css
        │
        └── templates
            ├── index.html
            ├── identificacao.html
            ├── unidade.html
            ├── categoria.html
            ├── profissional.html
            ├── avaliacao.html
            ├── sucesso.html
            ├── acompanhamento.html
            ├── login.html
            └── painel.html
```


    

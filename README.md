# Cliente para jogo da Velha

Esse projeto visa criar um cliente Java para consumir e trabalhar em conjunto com os servidores [nesse outro projeto](https://github.com/marcoswb/server-tic-tac-toe) e assim criar um sistema completo de Jogo da Velha.

Diferenciais:
- O projeto foi construido usando o gerenciador de projetos Maven da linguagem Java, a fim de facilitar o gerenciamento de dependências e compilação do projeto.
- No projeto foi incorporado o recurso de fila de mensagens do [Amazon SQS](https://aws.amazon.com/pt/sqs/), esse recurso permitiu criar o fluxo de partida contra amigos de uma forma muito fluída e rápida entre os jogadores como pode ser vista no último vídeo de demonstração. 
- Toda a comunicação entre o cliente e servidores é feita de forma criptografada usando o protocolo https e certificados SSL.
- Todos os usuários que estiverem compartilhando a mesma rede poderão se comunicar no Jogo, iniciando partidas aleatórias e também desafiando jogadores específicos.

Abaixo segue a demonstração das janelas desenvolvidas nesse cliente:

### Login e Registro
Cada usuário pode realizar seu registro no aplicativo e login, e após isso poderá ver na lista a esquerda os outros jogadores online no momento e iniciar uma partida com eles caso o oponente aceite.

https://github.com/user-attachments/assets/34b83cf9-473c-4431-bb3f-35e1c9f64b77


### Partida contra Computador
Nessa etapa foram utilizados algoritmos diferentes para cada nível de partida, conforme o nível que for escolhido as jogadas serão escolhidas levando um número maior de variáveis em consideração, dificultando assim a partida para o adversário.

E ao fechar a janela do jogo e voltar para o janela principal o histórico da partida já é computado e demonstrado na lista à direita.

https://github.com/user-attachments/assets/9992c302-9794-4474-98a0-8734957d8762


### Partida aleatória
Podem ser iniciadas partidas aleatórias entre dois jogadores que estão na mesma rede. O primeiro jogador pode clicar para iniciar uma partida aleatória e assim que outro jogador fazer o mesmo uma partida será iniciada entre ambos.

Caso algum dos jogadores desista e feche o jogo no meio da partida a vitória será atribuída ao adversário.

https://github.com/user-attachments/assets/2d59a212-35b5-4092-aa98-8e7f31197d84


### Partida contra amigo
Além de partidas aleatórias é possível convidar diretamente um oponente para uma partida, nesse caso você irá enviar um convite e caso o oponente aceite será iniciada a partida entre ambos no mesmo instante.

https://github.com/user-attachments/assets/92166198-b74d-48b6-86c9-4442609d4c77


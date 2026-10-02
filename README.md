**Máquina de Estados — Restaurante**

Simulação em Java com dois agentes, um Cliente e um Cozinheiro, cada um com sua própria máquina de estados. A cada segundo, os dois executam seu estado atual e se comunicam por um pedido compartilhado.

Para compilar e rodar (requer JDK 8 ou superior):

```bash
cd "Maquina de Estados"
javac -encoding UTF-8 -d out src/*.java
java -cp out StateMachine
```

A simulação roda sem parar. Para encerrar, use Ctrl + C. Se os acentos aparecerem como `?`, rode com `java -Dfile.encoding=UTF-8 -cp out StateMachine` (no Java 18 ou superior, use `-Dstdout.encoding=UTF-8`).

O **Cliente** passa por três estados:

- `FicaComFome`: a fome aumenta 1 por segundo. Ao chegar a 10, ele faz um pedido.
- `FazPedido`: escolhe um prato aleatório e espera até o pedido ser entregue.
- `Come`: come por 3 segundos, zera a fome e volta a `FicaComFome`.

O **Cozinheiro** também passa por três estados:

- `AnotaPedido`: espera um pedido. Quando aparece, anota e começa a cozinhar.
- `Cozinha`: prepara o prato (feijoada leva 10 segundos, hambúrguer leva 5).
- `EntregaPedido`: entrega o pedido e volta a `AnotaPedido`.

O status do pedido segue a ordem FEITO → ANOTADO → PRONTO → ENTREGUE.

A cada segundo, o programa mostra o estado de cada agente. As trocas de estado aparecem nestas mensagens:

- `Cliente: garçom! quero uma FEIJOADA!`: o cliente fez o pedido.
- `Pedido anotado!` e `Cozinheiro: Hora de cozinhar!`: o cozinheiro começou a preparar.
- `Cozinheiro: Pedido pronto!`: o prato ficou pronto.
- `Pedido entregue!`: o cozinheiro entregou o pedido.
- `Cliente: Hora de comer!`: o cliente começou a comer.
- `Cliente: to cheio!` e `Cliente: to de boa por enquanto`: o cliente terminou e o ciclo recomeça.

Para ver só essas mensagens, sem o status de cada segundo:

```bash
# Linux / macOS
java -cp out StateMachine | grep -E "^(Cliente|Cozinheiro):|anotado|entregue"
```

```powershell
# Windows (PowerShell)
java -cp out StateMachine | Select-String -Pattern "^(Cliente|Cozinheiro):|anotado|entregue"
```

Para salvar tudo em um arquivo: `java -cp out StateMachine > simulacao.log`

Observação: a mensagem `Cliente: to de boa por enquanto` não aparece no início da execução, só a partir do segundo ciclo. Isso é esperado, porque o estado inicial é definido sem passar pela troca de estado.

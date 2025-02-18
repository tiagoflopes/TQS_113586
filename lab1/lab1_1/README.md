Apesar da _coverage_ dos métodos da classe, existe um cenário em que a classe poderá falhar:
- A entrada de um _null_ na stack: () -> TqsStack.push(null). Esta execução pode causar comportamentos inesperados.
- Remover 0 elementos: () -> TqsStack.popTopN(0). De momento, nenhum elemento é removido e o método retorna _null_.
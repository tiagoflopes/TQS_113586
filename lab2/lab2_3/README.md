O API está online.

Antes de avançar com os testes, clarificar que os testes que terminam em "TEST" são unitários e os que terminam em "IT" são de integração.

Testes:
- `mvn test`: executa apenas os testes unitários. No meu caso, não há testes unitários.
- `mvn package`: compila o código e os testes. Executa os testes unitários (pois _test_ pertence ao lifecycle de _package_).
- `mvn package -DskipTests=true`: compila o código mas não executa testes (útil para criar o artefacto sem ser testado).
- `mvn failsafe:integration-test`: executa apenas os testes de integração (ao contrário do Surefire Plugin, que executa testes unitáios).
- `mvn install`: faz o mesmo que `mvn package`, instala o artefacto no repositório local e executa apenas os testes unitários, a menos que o Failsafe Plugin esteja configurado para corrê-los no _verify_ (como se encontra no pom).
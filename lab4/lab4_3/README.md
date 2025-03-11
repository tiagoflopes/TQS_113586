b)

Utilizo o locator "xpath" na procura dos seguintes elementos:
```java
WebElement searchBar = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[1]/div/input"));
WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[1]/div/button"));
```

e "class" neste:
```java
WebElement bookTitle = driver.findElement(By.className("SearchList_bookTitle__1wo4a"));
WebElement bookAuthor = driver.findElement(By.className("SearchList_bookAuthor__3giPc"));
```

O locator "id" é único por elemento da página, e o "name" também é, geralmente, único por elemento.
Obviamente, um locator que identifica unicamente um elemente é mais robusto porque persiste perante as alterações esperadas no desenvolvimento e manutenção de uma página web.
De qualquer forma, nem sempre é possível recorrer a estes locators, por isso, o uso de "xpath" é espectável.


c)

Depois de alterar os locators para "cssSelector", uma vez que os elementos que utilizo no teste não têm um "id" definido, ao correr o teste atualizado pela primeira vez, obtive o erro que indica que o elemento não foi encontrado. Após revisão, confirmei que os valores dos _css selectors_ dos elementos em questão (na página depois da pesquisa) estavam bem transcritos. Após uma segunda execução, o teste já correu sem problemas.
Justifico o sucedido com o facto de ainda não ter implementado os _explicit waits_ que sem eles, e de acordo com a documentação fornecida, como o _readyState_ se refere apenas ao _loading_ do que está definido em HTML, não tendo em conta o facto de alguns scripts javascript alterem o estado desses elementos carregados, o teste recebe indicação para continuar.

#Extend App
El archivo que se le pasa como argumento al comando `scala` tiene que ser un objeto de nivel superior. Si ese objeto se extiende de App, a continuación, se ejecutarán todas las declaraciones contenidas en ese objeto; de lo contrario hay que añadir un método `main` que actuará como punto de entrada del programa.

Así es como el "Hello, world!" quedaría con el uso de la extensión del objeto `App`:
```
object HelloWorld extends App {
    println("Hello, world!")
}
```    
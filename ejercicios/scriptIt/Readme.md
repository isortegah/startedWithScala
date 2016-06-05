#Ejecución por Script
También podemos ejecutar nuestro ejemplo como script de shell o comando por lotes. Comencemos con el siguiente codigo que se encuentra en el archivo `script.sh`
```
#!/bin/sh
exec scala "$0" "$@"
!#
object HelloWorld extends App {
  println("Hello, world!")
}
HelloWorld.main(args)
```
Se pueden ejecutar directamente desde la consola de comandos:
```
> ./script.sh
```
Arrojando como resultado:
```
Hello, world!
```
Aqui otro ejemplo de script (`script2.sh`):
```
#!/bin/sh
exec scala "$0" "$@"
!#
Console.println("Hello, world!")
```
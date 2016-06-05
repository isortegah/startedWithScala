# Started With Scala

##Compilar y ejecutar

###Compilando un archivo .scala
Empezamos con un archivo que contiene el siempre confiable `Hello, world!` .

    > scalac HelloWorld.scala

El comando `scalac` compila una (o más ) archivo ( s ) fuente Scala y genera código de bytes de Java que puede ser ejecutado en cualquier JVM estándar. El compilador Scala funciona de manera similar a javac

Por defecto `scalac` genera los archivos de clase en el directorio de trabajo actual. Es posible especificar un directorio de salida diferente utilizando la opción -d.

    > scalac -d classes HelloWorld.scala

Como resultado obtendremos en la carpeta `classes`:

    HelloWorld$.class
    HelloWorld.class

###Ejecución

`Scala` nos permite especificar las opciones de comando , como la opción `-classpath` (alias `cp`) para ejecutar nuestro ejemplo de "Hello, world!!" que se encuentra dentro del directorio `classes`:

    > scala -cp classes HelloWorld
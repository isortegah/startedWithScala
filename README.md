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
    
###Instalación de SBT
SBT es una herramienta de construcción de Scala, Java, y más. ver informacion completa en [Guia SBT](http://www.scala-sbt.org/0.13/docs/Getting-Started.html).

###CheatSheet

[CheatSheet Scala Oficial](http://docs.scala-lang.org/cheatsheets/)
[CheatSheet](https://github.com/lampepfl/progfun-wiki/blob/gh-pages/CheatSheet.md)
- - -

##Definiciones
####Classes, Traits, Objects and Packages

#####*Clasess*

Las clases en Scala son muy similares a las clases en Java. Son plantillas que contienen los campos y métodos. Al igual que en Java, las clases se pueden crear instancias utilizando el nuevo constructor, puede haber muchas "instancias" (u "objetos") de la misma clase.

En Scala existe un tipo especial de clases llamada "case classes". 

Las clases en Scala no pueden tener miembros estáticos. Puede utilizar objetos para lograr una funcionalidad similar como con miembros estáticos en Java.

#####*Traits*

Los Traits son como interfaces en Java, pero también pueden contener elementos concretos, es decir, las implementaciones de métodos o definiciones de campo.

#####* Objects*

Object en Scala son como clases, pero por cada definición de objeto sólo hay una única instancia. No es posible crear instancias de objetos utilizando las nuevas, en lugar sólo se puede acceder a los miembros (métodos o campos) de un objeto utilizando su nombre.

######*Packages*

El contenido de un paquete puede ser dispersado a través de muchos archivos. Si se define una clase MyClass en foo.bar paquete, puede importar esa clase específica (y no otra cosa de ese paquete) con `import foo.bar.MyClass`.

En Scala, todo puede ser importado, no sólo los nombres de las clases. Así, por ejemplo, si tiene un objeto en baz foo.bar paquete, a continuación, `import foo.bar.baz._` habría importar todos los miembros de ese objeto.

En Scala, el método principal o punto de entrada está definida en un objeto. Un objeto se puede hacer ejecutable ya sea agregando que se extiende el tipo de `App` o mediante la adición de un método `def main(args: Array[String])`.

####Archivos de código fuente, archivos de clase y la JVM

El código fuente de Scala se almacena en archivos de texto con la extensión .scala. Normalmente los programadores Scala crear un archivo fuente para cada clase, o un archivo fuente para una jerarquía de clases: De hecho, Scala permite múltiples clases y objetos que se definirán en el mismo archivo de origen.

El nombre de un archivo fuente de Scala se puede elegir libremente, pero se recomienda utilizar el nombre de una clase que se define en ese archivo.

Las jerarquías del paquete deben reflejarse en la estructura de directorios: un archivo fuente que define la clase C en el paquete foo.bar debe ser almacenado en un subdirectorio como foo / bar / C.scala. Scala en realidad no cumple esta convención, pero algunas herramientas como el IDE para Eclipse Scala podría tener problemas.

El compilador Scala compila archivos fuente .scala a archivos .class, como el compilador de Java. Los archivos .class son archivos binarios que contienen código para la máquina virtual de Java. Con el fin de ejecutar un programa Scala, la JVM tiene que saber el directorio donde se almacenan los archivos de clase. Este parámetro se denomina la "classpath".
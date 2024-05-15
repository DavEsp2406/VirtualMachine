# VirtualMachine
Proyecto de programación en el que se desarrollará una pequeña máquina virtual.

A continuación se muestran los comandos básicos para su ejecución:
  -HELP: Que muestra información sobre los distintos comandos disponibles.
  
  -QUIT: Cierra la aplicación.
  
  -NEWINST BC: Introduce la instrucción bytecode BC al programa actual. Si BC no
    está correctamente escrito, entonces manda un mensaje de error y no lleva a cabo la
    inserción.
    
  -RUN: Ejecuta el programa actual. En caso de que se produzca un error de ejecución,
    avisa al usuario mediante un mensaje.

  -RESET: Inicializa el programa actual eliminando todas las instrucciones almacena-
    das.

  -REPLACE N: Solicita al usuario una nueva instrucción BC, que en caso de ser correcta
    reemplazará a la instrucción bytecode número N del programa.

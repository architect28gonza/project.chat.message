1. Contruir la el dockerFile

2. Asignar el siguiente comando :
    $ docker build -t <nombre_app> .

3. Colocar el siguiente comando : 
    $ docker run -dp <puerto>:<puerto> <nombre_app>

4. Verificar la Ejecución : 
    $ docker ps

5. Detener el contenedor 
    $ docker stop <ID_O_NOMBRE_APP>

6. Limpieza Automática, Si deseas limpiar tu sistema de todos los contenedores detenidos, redes no utilizadas, imágenes colgadas y cachés de compilación no utilizadas, puedes usar el comando:
    $ docker system prune


# Usar la imagen oficial de Node.js versión 14 como base
FROM node:14

# Establecer el directorio de trabajo en el contenedor
WORKDIR /usr/src/app

# Copiar los archivos de dependencias del proyecto al contenedor
COPY package*.json ./

# Instalar las dependencias del proyecto
RUN npm install

# Copiar el resto de los archivos del proyecto al contenedor
COPY . .

# Exponer el puerto que usa tu aplicación
EXPOSE 8083

# Comando para ejecutar tu aplicación
CMD [ "node", "ace", "serve" ]

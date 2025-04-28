# arqui-soft-II
TP Arquitectura de Software II


### Requerimientos recomendados:

    JDK 21.06-amzn
    Maven 3.8.8

Revisar que estén bien seteadas las variables JAVA_HOME y MAVEN_HOME en computadora. Para corroborarlo puede probar por consola
```echo $JAVA_HOME``` y también  ```echo $MAVEN_HOME``` deben apuntar a cada carpeta correspondiente.
Se recomiendo instalar sdkman lo que le permitirá manejar más fáciles las versiones.

### Instalación
Una vez descargado el proyecto, al abrirlo con cualquier IDE automáticamente detecterá el POM y buscará instalar todas las dependencias. En caso de que haya algún problema o asegurarse que se instale correctamente, se puede ejecutar el comando
```mvn clean install```

### Setup inicial
Para poder levantar el proyecto, previamente se debe tener una cuenta en Atlas Database, creando un entorno gratuito el cual generará un cluster de trabajo. Para ello puede revisar la documentación [acá](https://www.mongodb.com/products/platform/atlas-database).
Luego deberá obtener la url, usuario y contraseña para poder configurar dinámicamente el archivo application.properties bajo la ruta ```src/main/resources/```
Alli se deberá verá que se precisan los siguientes datos
- MONGODB_USER
- MONGODB_PASS
- MONGODB_URL

```
spring.data.mongodb.uri=mongodb+srv://${MONGODB_USER}:${MONGODB_PASS}@${MONGODB_URL}/?retryWrites=true&w=majority&appName=freemarket
```

### Levantar proyecto

Para levantar el proyecto se deberá correr el comando

```mvn spring-boot:run -Dspring-boot.run.arguments="--MONGODB_USER=<USER>,--MONGODB_PASS=<PASS>,--MONGODB_URL=<URL>"```

Se debe esperar que se descarguen dependencias, levante el servidor y visualizará en la consola algo similar a

```2025-04-22T19:33:45.463-03:00  INFO 15696 --- [freemarket] [           main] c.a.s.freemarket.FreemarketApplication   : Started FreemarketApplication in 3.362 seconds (process running for 3.888)```


Esto levantará el servidor para poder recibir las solicitudes desde el front o postman. Notar que la url final será ```http://localhost:8080```

### Estructura del proyecto

Para una correcta organización, el proyeco se dividió en varias carpetas respetando la estructura de Arquitectura Hexagonal.
Dentro de la carpeta ```\src\main\java\com\arqui\soft\freemarket``` encontrará por cada dominio un paquete, actualmente cuenta con
- product
- sales
- seller
- user

Adicionalmente se encuentra la carpeta `commons`: la cual contiene clases en común y cross al proyecto, por ejemplo las exceptions.
Internamente encontrará cada dominio separado en:
- application:
    - usecase: carpeta donde se encuentran los casos de uso que contienen la lógica de cada dominio.
- architecture
  - adapters
    - in:
      - controllers: clases que interactuan con el exterior desde la vista "driving side".
    - out: clases que interactuan con el exterior desde la vista "driven side", son la implementación de las interfaces que se encuentran en `/domain/ports/out` como por ejemplo los repositorios hacia mongo DB.
- domain:
  - models carpeta con todas las clases propiamente del modelo.
  - ports: 
    - in: puertos de entrada, son lo que usan desde la capa adapters/in para realizar los casos de uso.
    - out: puertos de salida, son los interfaces para la conexión con el driven side.


### UML
[UML](/docs/uml)

### Casos de uso

#### Producto
- [Crear](./docs/usecases/product/create_product.md)
- [Actualizar](./docs/usecases/product/update_product.md)
- [Borrar](./docs/usecases/product/delete_product.md)
- [Obtener por nombre](./docs/usecases/product/get_by_name.md)
- [Obtener por categori](./docs/usecases/product/get_by_category.md)
- [Obtener por filtro](./docs/usecases/product/filter_products.md)

#### Vendedor
- [Crear](./docs/usecases/seller/create_seller.md)
- [Actualizar](./docs/usecases/seller/update_seller.md)
- [Borrar](./docs/usecases/seller/delete_seller.md)

#### Usuario
- [Crear](./docs/usecases/users/create_user.md)
- [Actualizar](./docs/usecases/users/update_user.md)
- [Borrar](./docs/usecases/users/delete_user.md)

#### Venta
- [Procesar](./docs/usecases/sale/sale_product.md)


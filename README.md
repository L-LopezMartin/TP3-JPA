<h1>Trabajo Práctico 3 - JPA</h1>
<p>Tercer trabajo práctico de la cátedra Desarrollo de software</p>
<p>El objetivo es lograr la persistencia a una base de datos H2 con JPA, aprovechando las herramientas que nos proporciona Lombok</p>
<hr></hr>
<p>En este proyecto se impelementó la persistencia de a una base de datos del siguiente diagrama de clases:</p>

![image](https://github.com/user-attachments/assets/6b25633f-b7b4-48ac-891c-c3aa794cb16d)

<p>Para implementar la relación de composición entre Factura y DetalleFactura, se reescribió el Builder de Lombok para la clase Factura. Esto fue para que dentro del builder de Factura se pudiera llamar al builder de DetalleFactura y se pudiera guardar la relación de Factura en DetalleFactura. Esto se hizo así porque es el atributo "factura" de Detalle Factura el que es persistido, pero al usar el constructor que provee Lombok no se guarda el atributo.</p>
<hr></hr>
<p>El paquete entidades es el que contiene a todas las entidades que van a ser persistidas.</p>
<p>El paquete org.example contiene el archivo Main.java, donde se instancian las clases y se realiza la transacción para la persistencia</p>

<h3>Ejecución del proyecto</h3>
<p>Para ejecutar el archivo de java que genera la persistencia se deben seguir los siguientes pasos:</p>
<ol>
  <li>Bajar el repositorio como archivo zip</li>
  <li>Descomprimir el archivo zip</li>
  <li>Abrir la carpeta resultante como proyecto de IntelliJ</li>
  <li>Navegar hacia src> main> java> org> example> Main.java</li>
  <li>Ejecutar la clase main</li>
</ol>
<p>Una vez realizado, se habrá persistido en la base de datos de H2. Para acceder a la misma, abrir H2 Console en nuestra pc. Una vez se acceda, se podrán ver las tablas en la base de datos creada</p>

![image](https://github.com/user-attachments/assets/a6531898-e0a3-46e8-ac8a-0497bf570ece)

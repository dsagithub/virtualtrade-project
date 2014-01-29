1-MYSQL

Hay que crear los usuarios sql siguientes:

create user 'libros'@'localhost' identified by 'libros'; grant all privileges on librosdb.* to 'libros'@'localhost'; flush privileges; exit;

create user 'realm'@'localhost' identified by 'realm'; grant all privileges on realmdb.* to 'realm'@'localhost'; flush privileges; exit;

Luego cargamos las bases de datos con las tablas:

mysql -u libros -p libros source (path relativo)/librosdb-schema.sql; source (path relativo)/librosdb-data.sql; exit;

mysql -u realm -p realm source (path relativo)/realmdb-schema.sql; source (path relativo)/realmdb-data.sql; exit;



2-Instalar scripts necesarios para GIT y Maven

3-Clonar el repositorio remoto que hay en GitHub: https://github.com/dsaqt1314g1/virtualtrade-project.git
4-Compilar proyecto Maven en la máquina remota

5-Exportar virtualtrade-api y virtualtrade-auth como archivos .war y cargarlos en el tomcat de la máquina remota

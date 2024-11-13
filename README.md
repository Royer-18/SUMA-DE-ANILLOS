# SUMA DE ANILLOS - JAVA
>[!NOTE]
>Ejercicio suma por anillos
## Ejercicio Propuesto: 
Escribir un algoritmo que dada una matriz cuandrada m de numeros enteros y dimension d, permita sumar los elementos de un "anillo" cualquiera k.
## Analisis y explicación del código
### CODIGO PRINCIPAL
```java
package ejercicioanillo;

import java.util.Scanner;

public class Ejercicioanillo {
    
    public static void main(String[] args) {
        
      Scanner teclado = new Scanner(System.in);
      
System.out.println("Ingrese la dimensión");
int d = teclado.nextInt();
int[][] vector = new int[d][d];

System.out.println("Ingrese los elementos:");
for (int i = 0; i < d; i++) {
    for (int j = 0; j < d; j++) {
        vector[i][j] = teclado.nextInt();
    }
}

// Mostrar matriz
for (int i = 0; i < d; i++) {
    for (int j = 0; j < d; j++) {
        System.out.print("[" + vector[i][j] + "]");
    }
    System.out.println("");
}

System.out.println("Qué anillo desea sumar: ");
int ani = teclado.nextInt();

int cant;
if (d%2==0){
    cant=d/2;
}else{
    cant=(d+1)/2;
}

if (ani > 0 && ani <= cant) {
    if (d % 2 != 0 && ani == cant) {
        int suma = vector[ani - 1][ani - 1];
        System.out.println("La suma del anillo " + ani + " es: " + suma);
    } else {
        int suma = 0;
        // Suma
        for (int j = ani - 1; j <= d - ani; j++) {
            suma += vector[ani - 1][j];
        }
        for (int j = ani - 1; j <= d - ani; j++) {
            suma += vector[d - ani][j];
        }
        for (int i = ani - 1; i <= d - ani; i++) {
            suma += vector[i][ani - 1];
        }
        for (int i = ani - 1; i <= d - ani; i++) {
            suma += vector[i][d - ani];
        }
        int result = suma - vector[ani - 1][ani - 1] - vector[ani - 1][d - ani] - vector[d - ani][d - ani] - vector[d - ani][ani - 1];
        
        System.out.println("La suma del anillo " + ani + " es: " + result);
    }
} else {
    System.out.println("Seleccione un anillo válido");
}
      
    }
    
}
```
### INGRESO DE LA DIMENSION: 
```java
System.out.println("Ingrese la dimensión");
int d = teclado.nextInt();
int[][] vector = new int[d][d];
```
- Inicializamos la variable "d" como entero para recibir la dimension del cuadrado o matriz.
- Asimismo se inializa la matriz con longitudes de "d".

### INGRESO DE LOS ELEMENTOS: 
```java
System.out.println("Ingrese los elementos:");
for (int i = 0; i < d; i++) {
    for (int j = 0; j < d; j++) {
        vector[i][j] = teclado.nextInt();
    }
}
```
- Para ingresar los elementos se hace el uso de dos "for" los cuales permitiran el registro de valores ingresados por el usuario.

>[!IMPORTANT]
>El uso de doble for es aplicable en ejercicios o problemas de matrices. Un for va dentro de otro for para las iteraciones tanto en i como j.

### MOSTRAR MATRIZ:
```java
for (int i = 0; i < d; i++) {
    for (int j = 0; j < d; j++) {
        System.out.print("[" + vector[i][j] + "]");
    }
    System.out.println("");
}
```
- Basicamente se aplica la misma logica que se aplico al momento de ingresar valores a la matriz, solo que en este caso se reemplaza por System.out.print().

### ELECCION DEL ANILLO A SUMAR: 
```java
System.out.println("Qué anillo desea sumar: ");
int ani = teclado.nextInt();
```
- Se establece "ani" como variable para almacenar el nro de anillo seleccionado por el usuario, el cual se ingreso por consola. 

### ESTABLECER LA CANTIDAD DE ANILLOS SEGUN LA DIMENSIÓN: 
```java
int cant;
if (d%2==0){
    cant=d/2;
}else{
    cant=(d+1)/2;
}
```
>[!IMPORTANT]
>En este caso para determinar la cantidad de anillos, nos basamos en la dimension de la matriz. En este caso como se muestra en el codigo, se crea una variable "cant" para almacenar la cantidad de anillos calculada segun dos detalles.
>Si la dimension es par, entonces se divide la dimension/2 (d/2) obteniendo un resultado almacenado en la variable "cant".
>Por otra parte, si la dimensaion fuera impar, entonces se suma +1 a la dimension y se divide entre 2 ((d+1)/2).

### SUMA DE LOS ANILLOS:
```java
if (ani > 0 && ani <= cant) {
    if (d % 2 != 0 && ani == cant) {
        int suma = vector[ani - 1][ani - 1];
        System.out.println("La suma del anillo " + ani + " es: " + suma);
    } else {
        int suma = 0;
        // Suma
        for (int j = ani - 1; j <= d - ani; j++) {
            suma += vector[ani - 1][j];
        }
        for (int j = ani - 1; j <= d - ani; j++) {
            suma += vector[d - ani][j];
        }
        for (int i = ani - 1; i <= d - ani; i++) {
            suma += vector[i][ani - 1];
        }
        for (int i = ani - 1; i <= d - ani; i++) {
            suma += vector[i][d - ani];
        }
        int result = suma - vector[ani - 1][ani - 1] - vector[ani - 1][d - ani] - vector[d - ani][d - ani] - vector[d - ani][ani - 1];
        
        System.out.println("La suma del anillo " + ani + " es: " + result);
    }
} else {
    System.out.println("Seleccione un anillo válido");
}
```
- Se hace uso de dos if - else, el segundo if - else viene correspondiendo dentro del primero. Si el primer if - else cumple se procede con el segundo if, mientras que no se cumpla aparecera como mensaje "Seleccione un anillo valido".
- El primer if-else se emplea para verificar y establecer que el anillo seleccionado sea el correcto, ya sea mayor a 0 y menor que "cant" el cual se vio en la seccion de "ESTABLECER LA CANTIDAD DE ANILLOS SEGUN LA DIMENSION".
- Ya en el segundo if - else, en el if se busca condicionar que la dimension si es impar y a la vez la variable "ani" (anillo seleccionado) y la variable "cant" (cantidad de anillos) son iguales, en este caso se trataria del centro del cuadrado o matriz, ya que cuenta con una dimension impar.

>[!NOTE]
>Se utilizo la libreria "java.util.Scanner" para poder ingresar los valores a la matriz.

>[!TIP]
>Los valores pueden ingresarse de dos maneras: por consola mediante el usuario o aleatoriamente con el uso de otra libreria.


## ANALISIS COMPLEJIDAD

## Cantidad de operaciones
- Asignaciones
- Comparaciones
- Operaciones aritmeticas
- Accesos a memoria
- Iteraciones

### Lectura de dimensión y elementos
- Lectura de dimensión: 1 operación (nextInt())
- Lectura de elementos: d^2 operaciones (d * d * nextInt())
### Mostrar matriz
- Impresión de elementos: d^2 operaciones (d * d * print())
### Cálculo de anillo
- Cálculo de cant: 1 operación (if-else)
- Cálculo de suma:
     * Caso especial (d % 2 != 0 && ani == cant): 1 operación (acceso a vector[ani-1][ani-1])
     * Caso general: 4 iteraciones sobre filas y columnas: 4 * (d - 2 * ani + 1) operaciones
- Resta de elementos repetidos: 4 operaciones
- Total: 4 * (d - 2 * ani + 1) + 4

### Complejidad

- Mejor caso (d % 2 != 0 && ani == cant): O(1)
- Peor caso (ani = 1): O(d)
- Complejidad general: O(d^2) debido a la lectura y impresión de elementos

### Cantidad de operaciones

- Lectura de dimensión y elementos: d^2 + 1
- Mostrar matriz: d^2
- Cálculo de anillo:
- Caso especial: 1
- Caso general: 4 * (d - 2 * ani + 1) + 4
- Total: d^2 + 1 + d^2 + 4 * (d - 2 * ani + 1) + 4

- Aproximadamente: 2d^2 + 4d - 8ani + 5


## Analisis de complejidad en el mejor y peor de los casos 
- Mejor caso: O(1) cuando el anillo es el central (cuando d es impar).
- Peor caso: O(d) cuando k = 1 (anillo exterior).

   * d (dimension)
   * k (anillo elejido)
     
 - La complejidad O(1) no depende del tamaño de la entrada.
 - La complejidad O(d) depende del tamaño de la entrada.  

### Justificación

- En el mejor caso, solo se necesita acceder a un elemento (el central) esto cuando la dimension de la matriz es impar.
- En el peor caso, se necesitan acceder a todos los elementos del anillo exterior, lo que implica recorrer d elementos en cada fila y columna.





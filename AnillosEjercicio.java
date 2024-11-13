/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anillosejercicio;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class AnillosEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
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

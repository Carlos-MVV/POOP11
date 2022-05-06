/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class POOP11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("###############File##############");
        //Los archivos son objetos con una referencia
        File archivo = new File("archivo.txt");
        //Mètodo para buscar el archivo
        System.out.println(archivo.exists());
        //crear archivo si no existe
        if(!archivo.exists()){
            try {
                boolean seCreo = archivo.createNewFile();
                System.out.println(seCreo);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("############FileOutputStream################");
        FileOutputStream fos = null;
        byte[] buffer = new byte[81];
        int nBytes;// bandera que aputa al ùltimo lugar ocupado del buffer
        System.out.println("Escriba texto a guardar en el archivo");
        try {
            nBytes = System.in.read(buffer);
            fos = new FileOutputStream("fos.txt");
            fos.write(buffer,0,nBytes);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally{
            if(fos!= null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println("############FileInputStream################");
        //Leer datos
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("fos.txt");
            nBytes = fis.read(buffer,0,buffer.length);
            String texto = new String(buffer,0,nBytes);
            System.out.println("El texto del archivo es :");
            System.out.println(texto);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        System.out.println("############FileWriter################");
        //Alternativa
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe el texto para el archivo");
        try {
            //Obtener texto
            String texto2 = br.readLine();
            //System.out.println(texto2);
            //Escribir texto en archivo
            FileWriter fw = new FileWriter("fw.csv");
            //Buffer por el que pasa la informaciòn, està conectado a fw
            BufferedWriter bw = new BufferedWriter(fw);
            //Impresora
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto2);
            //Escribir hacia abajo 
            for(int i = 0; i<10;i++){
                salida.println("Linea "+i);
            }
            //Escribir entre columnas(saltar de celda  a la derecha)
            for (int i = 0; i < 10; i++) {
                salida.println("Carlos,Villaseñor,Venegas,318606523"+i+",2"+i);
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally{           
        }
        
        System.out.println("############FileReader################");
        //Utiliza el mismo BufferedReader
        try{
            FileReader fr = new FileReader("fw.csv");
            br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("##############StringTokenizer#############");
        String cadena = "Carlos,Villaseñor,Venegas,3186065237,27";
        StringTokenizer tokenizador = new StringTokenizer(cadena,",");
        while(tokenizador.hasMoreTokens()){
            System.out.println(tokenizador.nextToken());
        }
        
        
        System.out.println("###############Actividad extra################");
        System.out.println("Parte1");
        System.out.println("############FileReaderModificado################");
        //Utiliza el mismo BufferedReader
        try{
            FileReader fr = new FileReader("fw.csv");
            br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            
            while(linea != null){
                //System.out.println(linea);
                StringTokenizer tokenizadorEx = new StringTokenizer(linea,",");
                while(tokenizadorEx.hasMoreTokens()){
                    System.out.print(tokenizadorEx.nextToken()+" ");
                }
                System.out.println("\n");
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        System.out.println("Parte2");
        System.out.println("Escribir");
        Alumno array[] = new Alumno[10];
        BufferedReader ActExR = new BufferedReader(new InputStreamReader(System.in));
        
                  
        array[0] = new Alumno("Carlos","Villasenor","Venegas",318606523,20);
        array[1] = new Alumno("Josue","Amezcua","Granados",317324899,20);
        array[2] = new Alumno("Janette","Tovar","Jara",311088669,23);
        array[3] = new Alumno("Juan","Sanchez","Martinez",316606523,20);
        array[4] = new Alumno("Pedro","Santos","Perez",318506523,20);
        array[5] = new Alumno("Maria","Vargas","Maldonado",318633523,20);
        array[6] = new Alumno("Alan","Munoz","Suarez",315556523,20);
        array[7] = new Alumno("Jesus","Fernandez","Arteaga",318306583,20);
        array[8] = new Alumno("Andres","Gonzalez","Arriola",312606923,20);
        array[9] = new Alumno("Ximena","Cardenas","Perez",314606111,20);
        
        try{
            FileWriter ActExW = new FileWriter("ActExW.csv");
            BufferedWriter bw = new BufferedWriter(ActExW);
            PrintWriter salida = new PrintWriter(bw);
            for (int i = 0; i < 10; i++) {
                
                salida.println(array[i].nombre+","+array[i].apellidoPaterno+","+array[i].apellidoMaterno+","+array[i].numCuenta+","+array[i].edad);
            }
            salida.close();
            
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Parte3");
        System.out.println("Leer");
        
        //Creamos objetos en el arreglo
        Alumno arreglo[] = new Alumno[10];
        
        for (int i = 0; i < 10; i++) {
            Alumno alumno = new Alumno();
            arreglo[i] = alumno;
        }
        
        Alumno alumno0 = new Alumno();
        arreglo[0] = alumno0;
        Alumno alumno1 = new Alumno();
        arreglo[1] = alumno1;
        Alumno alumno2 = new Alumno();
        arreglo[2] = alumno2;
        Alumno alumno3 = new Alumno();
        arreglo[3] = alumno3;
        Alumno alumno4 = new Alumno();
        arreglo[4] = alumno4;
        Alumno alumno5 = new Alumno();
        arreglo[5] = alumno5;
        Alumno alumno6 = new Alumno();
        arreglo[6] = alumno6;
        Alumno alumno7 = new Alumno();
        arreglo[7] = alumno7;
        Alumno alumno8 = new Alumno();
        arreglo[8] = alumno8;
        Alumno alumno9 = new Alumno();
        arreglo[9] = alumno9;
        
        
        String arregloAux[] = new String[5];
        int j=0;
        int k = 0;
        try{
            FileReader fr = new FileReader("ActExW.csv");
            br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            
            
            while(linea != null){
                
                StringTokenizer tokenizadorEx = new StringTokenizer(linea,",");
                while(tokenizadorEx.hasMoreTokens()){                   
                    
                    try{
                        String token = tokenizadorEx.nextToken();
                        arregloAux[j] = token;
                    }
                    catch(Exception ex){
                        
                    }
                    finally{
                       j++;
                    }
                    
                }
                try{
                    
                    arreglo[k].nombre = arregloAux[0];
                    arreglo[k].apellidoPaterno = arregloAux[1];
                    arreglo[k].apellidoMaterno = arregloAux[2];
                    int numCuenta = Integer.parseInt(arregloAux[3]);
                    arreglo[k].numCuenta = numCuenta;
                    int edad = Integer.parseInt(arregloAux[4]);
                    arreglo[k].edad = edad;
                    
  
                }
                catch(Exception ex){
                    
                }
                finally{
                    j=0;
                    k++;
                    linea = br.readLine();
                }
 
            }
            br.close();
        } catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Arreglo creado");
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo[i].nombre); 
            System.out.println(arreglo[i].apellidoPaterno);
            System.out.println(arreglo[i].apellidoMaterno);
            System.out.println(arreglo[i].numCuenta);
            System.out.println(arreglo[i].edad);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadegrafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aluno
 */
public class ListaDeGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
 
        AlgoritmosEmGrafos grafo = null;
        int arestas=0, vertices=0;
        int vertice1,vertice2;
        int primeira_linha=0;
        int peso=0;
        BufferedReader ler = new BufferedReader(new FileReader("‪C:\\Users\\Casa\\Desktop\\grafoa.txt")); 
        while(ler.ready())
        { 
            String linha= ler.readLine();
            String []textosplit= linha.split(" ");
            if(primeira_linha==0)
            {
                vertices=Integer.valueOf(textosplit[0]);
                arestas=Integer.valueOf(textosplit[1]);
                grafo=new AlgoritmosEmGrafos(vertices);
                primeira_linha++;
                System.out.println(vertices+" "+arestas);
            }
            else
            {
                vertice1=Integer.valueOf(textosplit[0]);
                vertice2=Integer.valueOf(textosplit[1]);
                peso=Integer.valueOf(textosplit[2]);
                grafo.insereAresta(vertice1,vertice2 ,peso);
                System.out.println(vertice1+" "+vertice2);
            }
            
	} 
        
	ler.close(); 
    }
    
}

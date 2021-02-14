/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadegrafos;

/**
 *
 * @author Aluno
 */

import java.util.ArrayList;


public class AlgoritmosEmGrafos extends Grafo
{
    
    private final int[] distanciasCMC; //guarda a distancia entre o vertice inicial do algoritmo de Dijkstra e cada um dos outros nos do grafo.
    private final int[] verticeAntecessorCMC; //armazena o vertice antecessor de cada no pertencente a pelo menos um dos caminhos encontrados durante a execucao do algoritmo.
    private final int infinito = Integer.MAX_VALUE;
    
    public AlgoritmosEmGrafos(int vertices){ //construtor
        super(vertices); //inicializa construtor de Grafo
        this.distanciasCMC = new int[vertices];
        this.verticeAntecessorCMC = new int[vertices];
   
    }
    
    public int iniciaCaminhoMaisCurto(int verticeInicial, int verticeFinal){ //calcula o caminho mínimo entre dois vertices do grafo     
        for(int i=0; i<this.numVertice();i++)
        {
            this.distanciasCMC[i] = infinito; //preenche todas as distâncias como infinito
            this.verticeAntecessorCMC[i] = -1; //valor de todos vértices antecessores iniciam com -1
        }
        this.distanciasCMC[verticeInicial] = 0; //distancia do vertice inicial ate ele mesmo é 0  
        return this.distanciasCMC[verticeFinal];
    }
    
    public int[] iniciaCaminhoMaisCurto(int verticeInicial){ //calcula o caminho mais curto entre o vertice inicial e todos os outros.
      
            ArrayList<Integer> VerticesVisitados = new ArrayList<>();
            ArrayList<Integer> VerticesNaoVisitados = new ArrayList<>();
            for(int j=0;j<this.numVertice();j++)
            {
                VerticesNaoVisitados.add(j);
            }
            while(!VerticesNaoVisitados.isEmpty())
            {
               /* ArrayList<Integer> vizinhos = this.listaDeAdjacencia(verticeInicial);
                for(Integer vizinho: vizinhos)
                {
                    this.verticeAntecessorCMC[vizinho]=vizinhos.get(vizinho);
                    if(this.getPeso(verticeInicial, vizinho)+this.distanciasCMC[verticeInicial]<this.distanciasCMC[vizinho])
                    {
                     this.distanciasCMC[vizinho]=this.getPeso(verticeInicial,vizinho)+this.distanciasCMC[verticeInicial];
                    }          
                }*/
                this.caminhoMaisCurto(verticeInicial);
                //Tranfere o ultimo vertice visitado do grupo dos nao visitados para os visitados
                for(int j=0;j<VerticesNaoVisitados.size();j++)
                {
                    if(verticeInicial==VerticesNaoVisitados.get(j))
                    {
                        VerticesNaoVisitados.remove(j);
                        VerticesVisitados.add(verticeInicial);
                    }
                }
                int distancia_min=infinito;
                int verticeaux=-1;
                //seleciona o proximo vertice a ser visitado
                
                for(int j=0;j<VerticesNaoVisitados.size();j++)
                {
                    if(distancia_min>this.distanciasCMC[VerticesNaoVisitados.get(j)])
                    {
                        distancia_min=this.distanciasCMC[VerticesNaoVisitados.get(j)];
                        verticeaux=VerticesNaoVisitados.get(j);
                    }
                }    
                verticeInicial=verticeaux;
            }
            return this.distanciasCMC;
    }
    
    private void caminhoMaisCurto(int verticeInicial)
    { 
        //implementa o algoritmo de Dijkstra.
        ArrayList<Integer> vizinhos = this.listaDeAdjacencia(verticeInicial);
        for(Integer vizinho: vizinhos)
        {
     
            if(this.getPeso(verticeInicial, vizinho)+this.distanciasCMC[verticeInicial]<this.distanciasCMC[vizinho])
            {
                this.verticeAntecessorCMC[vizinho]=vizinhos.get(verticeInicial);
                this.distanciasCMC[vizinho]=this.getPeso(verticeInicial,vizinho)+this.distanciasCMC[verticeInicial];
            }          
        }
    }
    
    public int[] getVerticeAntecessorCMC(){
        return this.verticeAntecessorCMC;
    }
    
}



package com.mycompany.sistema;

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    private Mediciones [] mediciones;
    private int noMediciones;
    
    public void Paciente(){
        
        id = 0;
        nombre = " ";
        edad = 0;
        genero = " ";        
        mediciones = new Mediciones [50];
        noMediciones = 0;
    }
    
    public Paciente(int id, String nombre, int edad, String genero){
      this.id = id;
      this.nombre = nombre;
      this.edad = edad;
      this.genero = genero;
      mediciones = new Mediciones [50];
    }
    
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getGenero(){
        return genero;
    }
    public Mediciones getMediciones(int n){
       return mediciones[n];
    }
    public int getNoMediciones(){
      return noMediciones;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setNoMediciones(int noMediciones){
        this.noMediciones = noMediciones;
    }
    
    public void agregar(Mediciones mediciones){
        this.mediciones[noMediciones++] = mediciones;
    }
      
    @Override
    public String toString(){
        return "\nID #: " + id + "\nNombre: " + getNombre() + "\nEdad: " + edad+"\nGénero: " + genero + "\n";
    }
}

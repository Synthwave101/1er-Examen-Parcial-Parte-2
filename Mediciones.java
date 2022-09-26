
package com.mycompany.sistema;

public class Mediciones {
    private Fecha fecha;
    private double peso;
    private double altura;
    
    public void Mediciones(){
        fecha = new Fecha(0,0,0);
        peso = 0.0;
        altura = 0.0;
    }
    
    public Mediciones(Fecha fecha, double peso, double altura){
        this.fecha = fecha;
        this.peso = peso;
        this.altura = altura;
    }
    
    public Fecha getFecha(){
        return fecha;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double imc(double peso, double altura){
        double IMC = peso/(Math.pow(altura, 2));
        return IMC;
    }
    
    public String clasificacionImc(double imc){
        imc = imc(peso, altura);
        String clasificacion = "";
        if (imc < 18.5){
            clasificacion = "Delgadez";
        }
        else if (imc >= 18.5 && imc < 25){
            clasificacion = "Peso Normal";
        }
        else if (imc >= 25 && imc < 30){
            clasificacion = "Sobrepeso";
        }
        else if (imc >= 30 && imc < 40){
            clasificacion = "Obesidad";
        }
        else if (imc >= 40){
            clasificacion = "Obesidad Mórbida";
        }
        return clasificacion;
    }
    
    @Override
    public String toString(){
        return "\nFecha: " + fecha.toString() + "\nPeso: "+peso + "kg\nAltura: " + altura + "m\nIMC: " + String.format("%.2f", imc(peso,altura)) + "\nClasificación: " + clasificacionImc(imc(peso,altura)) + "\n";
    }
    
}



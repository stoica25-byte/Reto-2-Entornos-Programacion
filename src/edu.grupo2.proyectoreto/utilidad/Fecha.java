package edu.grupo2.proyectoreto.utilidad;

public class Fecha{

    private int anno;
    private int mes;
    private int dia;

    public Fecha(int anno, int mes, int dia){
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
    }

    public void incrementarDias(int diasIncrementados){
        if (diasIncrementados < 0){
            throw new IllegalArgumentException("El numero de dias incrementados no puede ser negativo: "+ diasIncrementados);
        }

        boolean ajustarFecha = true;

        while (ajustarFecha){
            maxDiasMes = 31; //por defecto se asumen 31 dias como maximo//

            switch (this.mes) {
                case 4,6,9,11: //meses con 31 dias//
                    maxDiasMes = 30;
                    break;
                case 2: //febrero, en caso de año bisiesto 29 dias//
                    if( annoBisiesto(this.anno)){
                        maxDiasMes = 29;
                    }else{
                        maxDiasMes = 28;
                    }
                default: //resto de meses con 30 dias//
                    maxDiasMes = 30;
                    break;
            }
             
            
            int diasParaAcabarMes = maxDiasMes - this.dia;

            if (diasIncrementados> diasParaAcabarMes){
                diasIncrementados -= diasParaAcabarMes;
                this.mes++;

                this.dia = 0;

                if (this.mes>12){
                    this.mes = 1;
                    this.anno++;

                }else{
                    this.dia+= diasIncrementados;
                    diasIncrementados = 0;
                }
            }
        }
    }

    private boolean annoBisiesto(int anno){
        
    }



    
}
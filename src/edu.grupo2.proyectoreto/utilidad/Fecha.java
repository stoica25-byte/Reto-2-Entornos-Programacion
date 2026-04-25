package edu.grupo2.proyectoreto.utilidad;

/**
 * Representa una fecha con su dia, mes y año.
 * 
 * <p>El formato utilizado es {@code dd/MM/yyyy}, por ejemplo {@code 09/09/2012}.</p>
 * 
 * @author Wilson Camilo Ortiz Miño
 * @version 1.0 (2026-04-25)
 */
public class Fecha {
    
    /** 
     * Dia de la fecha.
     * 
     * <p>Admite valores entre 1 y el dia maximo del mes correspondiente</p>
     */
    private int dia;

    /** 
     * Mes de la fecha.
     * 
     * <p>Admite valores entre 1 y 12</p>
     */
    private int mes;

    /** 
     * Año de la fecha.
     * 
     * <p>Admite valores entre 1 y 9999</p>
     */
    private int anno;

    /**
     * Crea una fecha con su dia, mes y año.
     * 
     * @param dia   dia del mes, entre {@code 1} y el maximo del mes correspondiente
     * @param mes   mes del año, entre {@code 1} y {@code 12}
     * @param anno  año de la fecha, entre {@code 1} y {@code 9999}
     * 
     * @throws IllegalArgumentException si el mes no está entre {@code 1} y {@code 12},
     *                                  si el año no está entre {@code 1} y {@code 9999},
     *                                  o si el dia no es correcto en base al mes y año especificados
     */
    public Fecha(int dia, int mes, int anno) {

        if (anno < 1 || anno > 9999) {

            throw new IllegalArgumentException("El año de la fecha debe ser un valor entre 1 y 9999");
        }

        if (mes < 1 || mes > 12) {

            throw new IllegalArgumentException("El mes de la fecha debe ser un valor entre 1 y 12");
        }

        if (!isDiaCorrecto(dia, mes, anno)) {

            throw new IllegalArgumentException("El dia de la fecha es incorrecto");
        }

        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    /**
     * Incrementa la cantidad de dias especificados por parametro a la fecha.
     * 
     * @param diasIncrementar dias que se incrementaran a la fecha
     * 
     * @throws IllegalArgumentException si el valor de los dias a incrementar es negativo,
     *                                  o si al incrementar los dias de la fecha, se supera el año {@code 9999}
     */
    public void incrementarDias(int diasIncrementar) {

        if (diasIncrementar < 0) {

            throw new IllegalArgumentException("Los dias a incrementar no puede ser un valor negativo");
        }

        dia += diasIncrementar;

        while (dia > diasDelMes(mes, anno)) {
            
            dia -= diasDelMes(mes, anno);
            mes++;

            if (mes > 12) {

                mes = 1;
                anno++;

                if (anno > 9999) {

                    throw new IllegalArgumentException("Al incrementar los dias, se supera el año permitido: 9999");
                }
            }
        }
    }

    /*
     * Se evalua si el año introducido por parametro es bisiesto.
     * 
     * Devuelve true si el año es bisiesto, y false si el año no es bisiesto.
     * 
     * Para que un año sea bisiesto debe ser divisible entre 4 y que no entre 100 al mismo tiempo,
     * o que sea divisible entre 400.
     */
    private boolean isBisiesto(int anno) {

        return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
    }

    /*
     * Devuelve cuanto dias tiene el mes dependiendo del numero de mes y del año, teniendo en cuenta
     * los años bisiestos.
     */
    private int diasDelMes(int mes, int anno) {

        switch (mes) {
            case 2:
                return isBisiesto(anno) ? 29 : 28;
        
            case 4: case 6: case 9: case 11:
                return 30;

            default:
                return 31;
        }
    }

    /*
     * Se evalua si el dia introducido por parametro es correcto en base al mes y año.
     * 
     * Devuelve true si el dia es correcto, y false si el dia no es correcto.
     */
    private boolean isDiaCorrecto(int dia, int mes, int anno) {

        return dia >= 1 && dia <= diasDelMes(mes, anno);
    }

    /** Devuelve el dia de la fecha. */
    public int getDia() { return dia; }

    /** Devuelve el mes de la fecha. */
    public int getMes() { return mes; }

    /** Devuelve el año de la fecha. */
    public int getAnno() {return anno; }

    /**
     * Devuelve la fecha formateada en el formato {@code dd/MM/yyyy}.
     * 
     * @return cadena con la fecha en formato {@code dd/MM/yyyy}
     */
    @Override
    public String toString() {

        return String.format("%02d/%02d/%04d", dia, mes, anno);
    }
}

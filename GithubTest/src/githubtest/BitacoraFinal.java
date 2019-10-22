
package githubtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *Listado de todas las btiacorias diarias de una asignatura
 * @author Alumno
 */
public class BitacoraFinal {
    private List<BitacoraDiaria> bitacorasDiarias; 

    /**
     * 
     */
    public BitacoraFinal() {
        this.bitacorasDiarias = new ArrayList<>();
    }

    /**
     *
     * @return Un listado de las bitacoras diarias
     */
    public List<BitacoraDiaria> getBitacorasDiarias() {
        return bitacorasDiarias;
    }

    /**
     *
     * @param bitacorasDiarias
     */
    public void setBitacorasDiarias(List<BitacoraDiaria> bitacorasDiarias) {
        this.bitacorasDiarias = bitacorasDiarias;
    }

    /**
     *
     * @return el hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.bitacorasDiarias);
        return hash;
    }

    /**
     *
     * @param obj
     * @return La igualdad entre este objeto y otro del mismo tipo
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BitacoraFinal other = (BitacoraFinal) obj;
        if (!Objects.equals(this.bitacorasDiarias, other.bitacorasDiarias)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Una cadena de caracteres con el listado de bitacoras diarias
     */
    @Override
    public String toString() {
        return "BitacoraFinal{" + "bitacorasDiarias=" + bitacorasDiarias + '}';
    }
    
}

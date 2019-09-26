
package githubtest;

import java.util.List;
import java.util.Objects;

public class BitacoraFinal {
    private List<BitacoraDiaria> bitacorasDiarias; 

    public BitacoraFinal(List<BitacoraDiaria> bitacorasDiarias) {
        this.bitacorasDiarias = bitacorasDiarias;
    }

    public List<BitacoraDiaria> getBitacorasDiarias() {
        return bitacorasDiarias;
    }

    public void setBitacorasDiarias(List<BitacoraDiaria> bitacorasDiarias) {
        this.bitacorasDiarias = bitacorasDiarias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.bitacorasDiarias);
        return hash;
    }

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

    @Override
    public String toString() {
        return "BitacoraFinal{" + "bitacorasDiarias=" + bitacorasDiarias + '}';
    }
    
}

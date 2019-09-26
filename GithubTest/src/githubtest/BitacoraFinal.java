
package githubtest;

import java.util.List;

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
    
}

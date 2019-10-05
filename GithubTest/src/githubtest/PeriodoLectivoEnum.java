package githubtest;

public enum PeriodoLectivoEnum {
    primerCuatrimestre("perimer cuatrimestre"),
    segundoCuatrimestre("segundo cuatrimestre"),
    Anual("anual");

private String descripcion;
 
private  PeriodoLectivoEnum(String desc){
this.descripcion=desc;
}

    @Override
    public String toString() {
        return "PeriodoLectivoEnum{" + "descripcion=" + descripcion + '}';
    }

    public String getDescripcion() {
        return descripcion;
    }
    


    
}

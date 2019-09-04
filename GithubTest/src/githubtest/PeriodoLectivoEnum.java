package githubtest;

enum PeriodoLectivoEnum {
    Cuatrimestral("cuatrimestral"),
    Anual("cuatrimestral");

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

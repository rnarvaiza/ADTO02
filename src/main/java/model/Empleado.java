package model;

public class Empleado {
    private int id;
    private String apellidos;
    private String oficio;
    private String fecha_alta;
    private double salario;
    private double comision;
    private int id_departamento;

    public Empleado(int id, String apellidos, String oficio, String fecha_alta, double salario, double comision, int id_departamento){
        this.setApellidos(apellidos);
        this.setId(id);
        this.setOficio(oficio);
        this.setFecha_alta(fecha_alta);
        this.setSalario(salario);
        this.setComision(comision);
        this.setId_departamento(id_departamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String toString(){
        return "Departamento{" +
                "id=" + id +
                ", apellidos='" + apellidos + '\'' +
                ", oficio='" + oficio + '\'' +
                ", alta='" + fecha_alta + '\'' +
                ", salario='" + salario + '\'' +
                ", comision='" + comision + '\'' +
                ", id_departamento='" + id_departamento + '\'' +
                '}';
    }
}

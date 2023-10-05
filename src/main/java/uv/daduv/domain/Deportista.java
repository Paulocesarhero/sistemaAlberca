package uv.daduv.domain;

public class Deportista {
    private String id;
    private String nombre;
    private String tipo;
    private String modalidad;
    private int edad;
    private String telefono;

    private String noCredencial;
    private String horario;
    private String  sexo;
    private String correo;

    public Deportista(String id, String nombre, String tipo, String modalidad, int edad, String telefono, String noCredencial, String horario, String sexo, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.modalidad = modalidad;
        this.edad = edad;
        this.telefono = telefono;
        this.noCredencial = noCredencial;
        this.horario = horario;
        this.sexo = sexo;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNoCredencial() {
        return noCredencial;
    }

    public void setNoCredencial(String noCredencial) {
        this.noCredencial = noCredencial;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

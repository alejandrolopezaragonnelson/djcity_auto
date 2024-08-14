package app.home.Entities;

public class RequestAdmission {

  String nacionalidad;
  String domicilio;
  String ultimosEstudiosFinalizados;
  String Universidad;
  String annoFinalizacion;
  String motivo;
  String nivelIngles;
  String situacionLaboral;

  public RequestAdmission(
    String nacionalidad,
    String domicilio,
    String ultimosEstudiosFinalizados,
    String universidad,
    String annoFinalizacion,
    String motivo,
    String nivelIngles,
    String situacionLaboral
  ) {
    this.nacionalidad = nacionalidad;
    this.domicilio = domicilio;
    this.ultimosEstudiosFinalizados = ultimosEstudiosFinalizados;
    Universidad = universidad;
    this.annoFinalizacion = annoFinalizacion;
    this.motivo = motivo;
    this.nivelIngles = nivelIngles;
    this.situacionLaboral = situacionLaboral;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public String getUltimosEstudiosFinalizados() {
    return ultimosEstudiosFinalizados;
  }

  public void setUltimosEstudiosFinalizados(String ultimosEstudiosFinalizados) {
    this.ultimosEstudiosFinalizados = ultimosEstudiosFinalizados;
  }

  public String getUniversidad() {
    return Universidad;
  }

  public void setUniversidad(String universidad) {
    Universidad = universidad;
  }

  public String getAnnoFinalizacion() {
    return annoFinalizacion;
  }

  public void setAnnoFinalizacion(String annoFinalizacion) {
    this.annoFinalizacion = annoFinalizacion;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public String getNivelIngles() {
    return nivelIngles;
  }

  public void setNivelIngles(String nivelIngles) {
    this.nivelIngles = nivelIngles;
  }

  public String getSituacionLaboral() {
    return situacionLaboral;
  }

  public void setSituacionLaboral(String situacionLaboral) {
    this.situacionLaboral = situacionLaboral;
  }
}

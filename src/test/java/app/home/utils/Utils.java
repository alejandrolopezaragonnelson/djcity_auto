package app.home.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Utils {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  // Método para leer el JSON y devolver una lista de áreas con programas
  public static List<AreaInfo> ListJsonAreaInfo(String jsonString) {
    List<AreaInfo> result = new ArrayList<>();
    try {
      JsonNode jsonNode = objectMapper.readTree(jsonString);

      Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
      while (fields.hasNext()) {}
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}

class AreaInfo {

  private String area;
  private List<ProgramaInfo> programas;

  public AreaInfo(String area, List<ProgramaInfo> programas) {
    this.area = area;
    this.programas = programas;
  }

  // Getters y setters (puedes generarlos automáticamente en tu IDE)

  @Override
  public String toString() {
    return "AreaInfo{" + "area='" + area + '\'' + ", programas=" + programas + '}';
  }
}

class ProgramaInfo {

  private String nombre;

  public ProgramaInfo(String nombre) {
    this.nombre = nombre;
  }

  // Getters y setters (puedes generarlos automáticamente en tu IDE)

  @Override
  public String toString() {
    return "ProgramaInfo{" + "nombre='" + nombre + '\'' + '}';
  }
}

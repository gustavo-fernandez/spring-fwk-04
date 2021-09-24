package ejemploproxy;

import java.time.LocalDate;

public class ClaseDeNegocioProxy {

  private MyClaseDeNegocio myClaseDeNegocio = new MyClaseDeNegocio();

  public void transferenciaBancaria() {
    if (LocalDate.now().isAfter(LocalDate.of(2020, 10, 10))) {
      throw new RuntimeException("Fecha incorrecta");
    }
    System.out.println("Iniciando transferencia");
    myClaseDeNegocio.transferenciaBancaria();
    System.out.println("Transferencia finalizada");
  }

}

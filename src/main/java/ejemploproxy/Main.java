package ejemploproxy;

public class Main {

  public static void main(String[] args) {
    MyClaseDeNegocio myClaseDeNegocio = new MyClaseDeNegocio();
    myClaseDeNegocio.transferenciaBancaria();

    System.out.println("------");

    ClaseDeNegocioProxy proxy = new ClaseDeNegocioProxy();
    proxy.transferenciaBancaria();
  }

}

package Veiculo;

import java.util.ArrayList;

public abstract class Veiculo  {

  private String modelo;
  private String placa;
  private int anoFabricacao;
  private int numeroLugares;
  private int numeroPortas;
  private int tipoCambio;
  private String cor;
  private boolean isAvailable;
  private EVeiculo tipo;

 

  static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

  public Veiculo(EVeiculo tipo, String modelo, String placa, int anoFabricacao) {
    this.tipo = tipo;
    this.modelo = modelo;
    this.placa = placa;
    this.anoFabricacao = anoFabricacao;
    this.isAvailable = true;
    System.out.println("Veiculo Criado com sucesso");
  }

  public static void addToList(Veiculo veiculo) {
    listaVeiculos.add(veiculo);
    System.out.println("Veiculo salvo na lista");
  }

  public static void printList() {
    System.out.println("**** LISTA DE VEICULOS ****");
    for (Veiculo veiculo : listaVeiculos) {
      System.out.println(
        (listaVeiculos.indexOf(veiculo) + 1) + ". " + veiculo
      );
      // index++;
    }
  }

  public static void removeFromlist(Veiculo veiculo) {
    listaVeiculos.remove(listaVeiculos.indexOf(veiculo));
    System.out.println(
      "Veiculo " + veiculo.getModelo() + " removido da lista"
    );
  }

  @Override
  public String toString() {
    return (
      getTipo() +
      " -> modelo: " +
      getModelo() +
      ", placa: " +
      getPlaca() +
      ", ano de fabricação: " +
      getAnoFabricacao() + 
      ", disponível: " + 
      isAvailable()
    );
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public String getModelo() {
    return modelo;
  }

  public String getPlaca() {
    return placa;
  }

  public int getAnoFabricacao() {
    return anoFabricacao;
  }

  public EVeiculo getTipo() {
    return tipo;
  }
}

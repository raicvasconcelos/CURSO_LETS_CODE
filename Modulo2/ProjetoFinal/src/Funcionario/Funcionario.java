package Funcionario;

import java.util.ArrayList;

public abstract class Funcionario {

  private String nome;
  private String cpf;
  private String senha;
  private double salario;
  private ECargo cargo;
  // private static int index =0;

  static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

  public Funcionario(String nome, String cpf, String senha, ECargo cargo) {
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.cargo = cargo;
    this.salario = cargo.getSalario();
  }

  public static void addToList(Funcionario funcionario) {
    listaFuncionarios.add(funcionario);
    System.out.println("Funcionário salvo na lista");
  }

  public static void printList() {
    System.out.println("**** LISTA DE FUNCINÁRIOS ****");
    for (Funcionario funcionario : listaFuncionarios) {
      System.out.println((listaFuncionarios.indexOf(funcionario)+1) + ". " + funcionario);
      // index++;
    }
  }

  public static void removeFromlist(Funcionario funcionario) {
    listaFuncionarios.remove(listaFuncionarios.indexOf(funcionario));
    System.out.println(
      "Funcionário " + funcionario.getNome()  + " removido da lista"
    );
  }

  public boolean autentica(String senha) {
    if (this.senha == senha) {
      System.out.println("Acesso permitido");
      return true;
    } else {
      System.out.println("Acesso negado");
      return false;
    }
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public ECargo getCargo() {
    return cargo;
  }
}

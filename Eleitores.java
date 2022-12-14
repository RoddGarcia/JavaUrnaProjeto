import java.util.Scanner;

public class Eleitores {
  Scanner userinp = new Scanner(System.in);
  
  private int position = 0;
  String redo;

  public void cadastrar(String lista[][]) { //Cadastrando eleitores para a votação usando listas 2D
    
    while (true) {
      if (position <= 4) {
        System.out.println("\nNome do(a) Eleitor(a):");
        lista[position][0] = userinp.nextLine();

        System.out.println("CPF do Eleitor:");
        lista[position][1] = userinp.nextLine();

        lista[position][2] = "false";

        position += 1;
        System.out.println("Eleitor cadastrado com sucesso.\n");

        System.out.println("Deseja adicionar outro usuário? [Y/N]");
        redo = userinp.nextLine().toUpperCase();
        if (redo.equals("N")) {
          break;
        }
      } else {
        System.out.println("\nVagas disponíveis já estão preenchidas.\n");
        break;
      }
    }
  }
  
  void printar(String lista[][]) {
    // Usar printf para definir o limite de caracteres na tabela, deixando-a
    // alinhada.
    System.out.println("\nLISTA DE ELEITORES");
    System.out.printf("---| %-15s | %-15s | %-15s\n", "Nome", "CPF", "Votou?");
    int ordem = 1;
    for (int linha = 0; linha < 5; linha++) {
      System.out.print(ordem + ". ");
      for (int coluna = 0; coluna < 3; coluna++) {
        System.out.printf("| %-15.15s ", lista[linha][coluna]);
      }
      System.out.println("");
      ordem += 1;
    }
    System.out.println("\n");
  }
  
}
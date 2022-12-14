import java.util.Scanner;

public class Candidato {
  Scanner userinp = new Scanner(System.in);

  String redo;
  String nome;
  String numCandidato;
  String numPartido;
  
  
  public void cadastrar(String lista[][], int position) { // Cadastrando os candidatos em listas 2D 

    while (true) {

      if (position <= 2) {
        System.out.println("\nCandidato n°"+(position+1));
        System.out.println("\nNome do Candidato:");
        lista[position][0] = userinp.nextLine();

        System.out.println("Número do Candidato:");
        lista[position][1] = userinp.nextLine();

        System.out.println("Número do Partido do Candidato:");
        lista[position][2] = userinp.nextLine();

        lista[position][3] = "0";

        position += 1;
        System.out.println("Candidato cadastrado com sucesso.\n");

        System.out.println("Deseja adicionar outro candidato? [Y/N]");
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
    System.out.printf("---| %-15s | %-15s | %-15s | %-15s\n", "Nome", "N° Candidato", "N° Partido", "Votos");
    int ordem = 1;
    for (int linha = 0; linha < 3; linha++) {
      System.out.print(ordem + ". ");
      for (int coluna = 0; coluna < 4; coluna++) {
        System.out.printf("| %-15.15s ", lista[linha][coluna]);
      }
      System.out.println("");
      ordem += 1;
    }
    System.out.println("\n");
  }
}
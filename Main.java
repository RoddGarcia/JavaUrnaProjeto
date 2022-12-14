
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    
    int presPos = 0; // Posições
    int govPos = 0;
    int prefPos = 0;

    Candidato cand = new Candidato();
    Eleitores eleit = new Eleitores();
    String[][] eleitoresLISTA = new String[5][3]; // 5 ELEITORES | 3 OPÇÕES: NOME CPF VOTO
    String[][] presidenteLISTA = new String[3][4]; // 3 PRESIDENTES | 4 OPÇÕES: NOME NUMERO PARTIDO VOTOS
    String[][] governadorLISTA = new String[3][4]; // 3 GOVERNADORES | 4 OPÇÕES: NOME NUMERO PARTIDO VOTOS
    String[][] prefeitoLISTA = new String[3][4]; // 3 PREFEITOS | 4 OPÇÕES: NOME NUMERO PARTIDO VOTOS
    
    Votar voto = new Votar(); //Votação

    int choice; // Escolha do usuário no menu
    int cargo; // Cargo a ser definido para os candidatos

    Scanner userinp = new Scanner(System.in);

    String Menu = ("+++++++ MENU - SIMULADOR DO SISTEMA DE VOTAÇÃO +++++++ \n" +
        "1. Cadastrar Candidatos \n" +
        "2. Cadastrar Eleitores \n" +
        "3. Votar \n" +
        "4. Apurar Resultados \n" +
        "5. Relatório e Estatísticas \n" +
        "6. Encerrar \n" +
        "Opção Escolhida: ");

    do {
      System.out.print(Menu); // Printa o menu.
      choice = userinp.nextInt(); // Usuário digita a sua escolha.
      System.out.println();

      switch (choice) {
        case 1: // Cadastrar Candidato
          System.out.println("\nCadastrar Candidato: ");
          System.out.println("Cargo do Candidato \n1) Presidente\n2) Governador\n3) Prefeito");
          cargo = userinp.nextInt();
          userinp.nextLine();

          if (cargo == 1) {
            cand.cadastrar(presidenteLISTA, presPos);
          } else if (cargo == 2) {
            cand.cadastrar(governadorLISTA, govPos);
          } else if (cargo == 3) {
            cand.cadastrar(prefeitoLISTA, prefPos);
          }
          break;

        case 2: // Cadastrar Eleitores
          eleit.cadastrar(eleitoresLISTA);
          break;

        case 3: // Votar
          for (int i = 0; i < 5; i++) { // Um voto para cada eleitor.
            if (eleitoresLISTA[i][0] == null) {

              System.out.println("Verficar lista de eleitores. Há espaços vazios.\n");
              break;

            } else {

              System.out.println("\nRANKING DO RESULTADO PARA PREFEITO");
              cand.printar(prefeitoLISTA); // Lista de candidatos
              System.out.println("Voto do eleitor(a): \033[0;1m" + eleitoresLISTA[i][0] + "\033[0;0m, CPF: \033[0;1m" + eleitoresLISTA[i][1]);
              System.out.println("Digite o voto do eleitor para Prefeito (Partido do Candidato).");
              voto.votar(prefeitoLISTA);

              System.out.println("\nRANKING DO RESULTADO PARA GOVERNADOR");
              cand.printar(governadorLISTA); // Lista de candidatos
              System.out.println("Voto do eleitor(a): " + eleitoresLISTA[i][0] + ", CPF:" + eleitoresLISTA[i][1]);
              System.out.println("Digite o voto do eleitor para Governador (Partido do Candidato).");
              voto.votar(governadorLISTA);

              
              System.out.println("\nRANKING DO RESULTADO PARA PRESIDENTE");
              cand.printar(presidenteLISTA); // Lista de candidatos
              System.out.println("Voto do eleitor(a): " + eleitoresLISTA[i][0]+", CPF: "+eleitoresLISTA[i][1]);
              System.out.println("Digite o voto do eleitor para Presidente (Partido do Candidato).");
              voto.votar(presidenteLISTA);

              cand.printar(presidenteLISTA); // Atualiza lista de candidatos
              cand.printar(governadorLISTA);
              cand.printar(prefeitoLISTA);
              
              eleitoresLISTA[i][2] = "true";

              continue;
            }
          }
          break;

        case 4: // Apurar Resultados
          voto.apurar(prefeitoLISTA, governadorLISTA, prefeitoLISTA);
          break;

        case 5: // Relatório e Estatísticas
          voto.ordenar(eleitoresLISTA);
          // eleit.printar(eleitoresLISTA);
          break;

      }

    } while (choice < 6);

    System.out.println("O sistema foi encerrado."); // Finalização do sistema

    userinp.close();
  }
}

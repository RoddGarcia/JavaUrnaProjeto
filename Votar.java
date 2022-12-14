import java.util.Scanner;

public class Votar {

  Eleitores eleit = new Eleitores();
  Scanner userinp = new Scanner(System.in);

  int position = 0; // Posição dos eleitores na ordem de votação
  int nulo = 0; // Votos nulos
  int branco = 0; // Votos brancos
  int numVotos = 0; // Votos totais
  String voto;
  String confirm;

  public void votar(String lista[][]) {
    if (position <= 15) {
      voto = userinp.nextLine();
      for (int i = 0; i < 3; i++) {
        if (lista[i][2].equals(voto)) {
          System.out.println("Voto será computado para " + lista[i][2] + ". Confirmar voto? [Y/N]");
          confirm = userinp.nextLine().toUpperCase();
          if (confirm.equals("N")) { 
            break;
          } // REJEITA
          else {
            System.out.println("\nVoto confirmado.\n");
            int candVoto = Integer.parseInt(lista[i][3]); // NUMERO EXIBIDO EM VOTOS DO CANDIDATO.
            candVoto += 1;
            lista[i][3] = Integer.toString(candVoto);
            numVotos += 1;
            position += 1;
            break;
          } // CONFIRMAR
        } 
        else if (voto.equals("-1")) {
          System.out.println("Deseja registrar seu voto em branco? [Y/N]");
          confirm = userinp.nextLine().toUpperCase();
          if (confirm.equals("N")) {
            break;
          }
          else {
            branco += 1;
          }
          break;
        } // Voto em branco
        else if (voto.equals("-2")) {
          System.out.println("Candidato não encontrado, seu voto será nulo. É o que deseja? [Y/N]");
          confirm = userinp.nextLine().toUpperCase();
          if (confirm.equals("N")) {
             break;
           }
          else {
            nulo += 1;
          }
          break;
        } // Voto em nulo
        else {
          continue;
        }
      } // FIM DA VOTAÇÃO
    } else {
      System.out.println("Votação encerrada.");
    } 
  }

  public void apurar (String pref[][], String gov[][], String pres[][]){
    int prefV = 0;
    int govV = 0;
    int presV = 0;
    
    for (int i = 0; i < 3; i++){
      prefV += Integer.parseInt(pref[i][3]);
      govV += Integer.parseInt(gov[i][3]);
      presV += Integer.parseInt(pres[i][3]);
    }
    int total = (prefV+govV+presV+6);
    
    System.out.println("Total de votos: "+total); //Análise dos votos
    System.out.println("Total de votos válidos: "+(((total*100)/15)-((nulo*100)/15)-((branco*100)/15)+"%"));
    System.out.println("Total de votos brancos: "+branco+" | "+((branco*100)/15)+"%");
    System.out.println("Total de votos nulos: "+nulo+" | "+((nulo*100)/15)+"%");
    System.out.println("");

    int pref1 = Integer.parseInt(pref[0][3]);  //Contabilizando votos para cada prefeito
    int pref2 = Integer.parseInt(pref[1][3]); 
    int pref3 = Integer.parseInt(pref[2][3]);
 
    if (pref1 > pref2 && pref1 > pref3) { //Mostra o prefeito vencedor
      System.out.println("O candidato a prefeito "+pref[0][0]+" foi eleito com "+pref[0][3]+ " votos.\n");
    } else if (pref2 > pref1 && pref2 > pref3) {
        System.out.println("O candidato a prefeito "+pref[1][0]+" foi eleito com "+pref[1][3]+ " votos.\n");
    } else if (pref3 > pref1 && pref3 > pref2) {
        System.out.println("O candidato a prefeito "+pref[2][0]+" foi eleito com "+pref[2][3]+ " votos.\n");
    } else {
        
      }

    int gov1 = Integer.parseInt(gov[0][3]); //Contabilizando votos para cada governador
    int gov2 = Integer.parseInt(gov[1][3]); 
    int gov3 = Integer.parseInt(gov[2][3]);
 
    if (gov1 > gov2 && gov1 > gov3) { //Mostra o governador vencedor
      System.out.println("O candidato a governador "+gov[0][0]+" foi eleito com "+gov[0][3]+ " votos.\n");
    } else if (gov2 > gov1 && gov2 > gov3) {
        System.out.println("O candidato a governador "+gov[1][0]+" foi eleito com "+gov[1][3]+ " votos.\n");
    } else if (gov3 > gov1 && gov3 > gov2) {
        System.out.println("O candidato a governador "+gov[2][0]+" foi eleito com "+gov[2][3]+ " votos.\n");
    } else {
        
      }

    int pres1 = Integer.parseInt(pres[0][3]); //Contabilizando votos para cada presidente
    int pres2 = Integer.parseInt(pres[1][3]); 
    int pres3 = Integer.parseInt(pres[2][3]);
 
    if (pres1 > pres2 && pres1 > pres3) { //Mostra o presidente vencedor
      System.out.println("O candidato a presidente "+pres[0][0]+" foi eleito com "+pres[0][3]+ " votos.\n");
    } else if (pres2 > pres1 && pres2 > pres3) {
        System.out.println("O candidato a presidente "+pres[1][0]+" foi eleito com "+pres[1][3]+ " votos.\n");
    } else if (pres3 > pres1 && pres3 > pres2) {
        System.out.println("O candidato a presidente "+pres[2][0]+" foi eleito com "+pres[2][3]+ " votos.\n");
    } else {
        
      }
    }
  
  public void ordenar (String lista[][]) {
    System.out.println("Lista de eleitores que votaram:\n"); //Mostra os eleitores participantes
    for (int i = 0; i < 5; i++){
      if (lista[i][2] == "true"){
        System.out.println((i+1)+". " + lista[i][0]);
      } else{
        System.out.println();
        break;
      }
    }
  }
}
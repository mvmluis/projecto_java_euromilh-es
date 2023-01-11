import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int[] numsEuroSort; // variável geral que guarda temporariamente os números da chave do sorteio para comparações
    static int[] extraEuroSort; // variável geral que guarda temporariamente as estrelas da chave do sorteio para comparações
    static int[] numsEuroSortUt; // variável geral que guarda temporariamente os números da chave aleatória ou do utilizador para comparações
    static int[] extraEuroSortUt; // variável geral que guarda temporariamente as estrelas da chave aleatória ou do utilizador para comparações

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("Bem-vindo ao sorteio do EuroMilhões!");
            System.out.println("Escolha uma das seguintes opções:");
            System.out.println("1-Gerar a chave do concurso do Euromilhões");
            System.out.println("2-Crie as suas chaves do EuroMilhões");
            System.out.println("3-Sortear até ser vencedor do 1º prémio");
            System.out.println("0-Sair");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                chaveSorteio();
            } else if (op == 2) {
                criarChave();
            } else if (op == 3) {
                sorteioVencedor();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (0 != op);
    }

    private static void criarChave() {
        int op;
        do {
            System.out.println("Escolha uma das seguintes opções:");
            System.out.println("1-Crie chaves aleatórias do EuroMilhões e veja se tem prémio");
            System.out.println("2-Crie as suas próprias chaves do EuroMilhões e veja se tem prémio");
            System.out.println("0-Retroceder");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                chavesAleatorias();
                break;
            } else if (op == 2) {
                chaveUtilizador();
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);
    }

    private static void chavesAleatorias() {
        if(numsEuroSort != null) {
            System.out.println("Quantas chaves pretende criar? (escolha entre 1 a 5 chaves - ou digite 0 para voltar ao menu inicial)");
            int qtdChaves = in.nextInt();
            if (qtdChaves == 0) return;
            if (qtdChaves >= 1 && qtdChaves <= 5) {
                for (int j = 0; j < qtdChaves; j++) {

                    int[] euroMilhoesNumsUt = new int[5];
                    int[] euroMilhoesExtraUt = new int[2];
                    int randomNum;
                    System.out.println("Os seus números na " + (j+1) + "ª chave foram: ");
                    for (int i = 0; i < 5; i++) {
                        randomNum = rnd.nextInt(1, 51); // Gerar número aleatório.
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesNumsUt[x] == randomNum) // Verificar se o número aleatório já saiu.
                            {
                                randomNum = rnd.nextInt(1, 51);// Se o número for repetido, gerar novo número.
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }

                        }
                        euroMilhoesNumsUt[i] = randomNum;
                        numsEuroSortUt = euroMilhoesNumsUt;
                    }
                    Arrays.sort(euroMilhoesNumsUt);

                    System.out.print(Arrays.toString(euroMilhoesNumsUt) + " ");

                    System.out.println();
                    System.out.println("As suas estrelas na " + (j+1) + "ª chave foram: ");
                    for (int i = 0; i < 2; i++) {
                        randomNum = rnd.nextInt(1, 13); // Gerar número aleatório.
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesExtraUt[x] == randomNum) // Verificar se o número aleatório já saiu.
                            {
                                randomNum = rnd.nextInt(1, 13);// Se o número for repetido, gerar novo número.
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }

                        }
                        euroMilhoesExtraUt[i] = randomNum;
                        extraEuroSortUt = euroMilhoesExtraUt;
                    }
                    Arrays.sort(euroMilhoesExtraUt);

                    System.out.print(Arrays.toString(euroMilhoesExtraUt) + " ");

                    System.out.println(" ");

                    int contadorNums = 0;
                    //Comparar com os numeros da chave do sorteio
                    for (int i = 0; i < numsEuroSortUt.length; i++) {
                        for (int k = 0; k < numsEuroSort.length; k++) {
                            if (numsEuroSortUt[i] == numsEuroSort[k]) {
                                contadorNums++;
                            }
                        }
                    }

                    int contadorExtra = 0;
                    //Comparar com as estrelas da chave do sorteio
                    for (int i = 0; i < extraEuroSortUt.length; i++) {
                        for (int k = 0; k < extraEuroSort.length; k++) {
                            if (extraEuroSortUt[i] == extraEuroSort[k]) {
                                contadorExtra++;
                            }
                        }
                    }

                    // Condições para verificar se existe prémio
                    if (contadorNums == 5 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o primeiro prémio!");
                    } else if (contadorNums == 5 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o segundo prémio!");
                    } else if (contadorNums == 5 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o terceiro prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quarto prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quinto prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o sexto prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o setimo prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o oitavo prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o nono prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o decimo prémio!");
                    } else if (contadorNums == 1 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o decimo primeiro prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o decimo segundo prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o decimo terceiro prémio!");
                    } else
                        System.out.println("Infelizmente não lhe saiu nenhum prémio! Boa sorte para o próximo sorteio.");
                }
            } else System.out.println("Por favor insira de uma a cinco chaves"); chavesAleatorias(); // caso o utilizador insira um número inválido, chamamos a função chavesAleatorias(). para escapar ao loop o utilizador pode digitar 0. isto evita que ao digitar um número inválido vá parar automáticamente ao menu principal
        } else
            System.out.println("Tem que criar uma chave de sorteio no menu principal antes de criar as suas chaves!");
    }

    private static void sorteioVencedor() {
        if(numsEuroSort != null) {
            boolean venceu = false;
            int j = 0;
                while(venceu != true) {

                    int[] euroMilhoesNumsUt = new int[5];
                    int[] euroMilhoesExtraUt = new int[2];
                    int randomNum;
                    //System.out.println("Os números são: ");
                    for (int i = 0; i < 5; i++) {
                        randomNum = rnd.nextInt(1, 51); // Gerar número aleatório.
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesNumsUt[x] == randomNum) // Verificar se o número aleatório já saiu.
                            {
                                randomNum = rnd.nextInt(1, 51);// Se o número for repetido, gerar novo número.
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }
                        }
                        euroMilhoesNumsUt[i] = randomNum;
                        numsEuroSortUt = euroMilhoesNumsUt;
                    }
                    Arrays.sort(euroMilhoesNumsUt);

                    for (int i = 0; i < 2; i++) {
                        randomNum = rnd.nextInt(1, 13); // Gerar número aleatório.
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesExtraUt[x] == randomNum) // Verificar se o número aleatório já saiu.
                            {
                                randomNum = rnd.nextInt(1, 13);// Se o número for repetido, gerar novo número.
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }

                        }
                        euroMilhoesExtraUt[i] = randomNum;
                        extraEuroSortUt = euroMilhoesExtraUt;
                    }
                    Arrays.sort(euroMilhoesExtraUt);

                    System.out.println("Tentiva número: " + (j + 1));

                    int contadorNums = 0;
                    //Comparar com os números da chave do sorteio
                    for (int i = 0; i < numsEuroSortUt.length; i++) {
                        for (int k = 0; k < numsEuroSort.length; k++) {
                            if (numsEuroSortUt[i] == numsEuroSort[k]) {
                                contadorNums++;
                            }
                        }
                    }

                    int contadorExtra = 0;
                    //Comparar com as estrelas da chave do sorteio
                    for (int i = 0; i < extraEuroSortUt.length; i++) {
                        for (int k = 0; k < extraEuroSort.length; k++) {
                            if (extraEuroSortUt[i] == extraEuroSort[k]) {
                                contadorExtra++;
                            }
                        }
                    }

                    // Condições para verificar se existe prémio
                    if (contadorNums == 5 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o primeiro prémio!");
                        venceu = true;
                    } else if (contadorNums == 5 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o segundo prémio!");
                    } else if (contadorNums == 5 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o terceiro prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quarto prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quinto prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o sexto prémio!");
                    } else if (contadorNums == 4 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o sétimo prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o oitavo prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o nono prémio!");
                    } else if (contadorNums == 3 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o décimo prémio!");
                    } else if (contadorNums == 1 && contadorExtra == 2) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o décimo primeiro prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 1) {
                        System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o décimo segundo prémio!");
                    } else if (contadorNums == 2 && contadorExtra == 0) {
                        System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o décimo terceiro prémio!");
                    } /*else {
                        System.out.println("Infelizmente não lhe saiu nenhum prémio! Boa sorte no próximo sorteio.");
                    }*/
                    j++;
                }

        } else
            System.out.println("Tem que criar uma chave de sorteio primeiro!");
    }

    private static void chaveUtilizador() {
        if(numsEuroSort != null) {
        System.out.println("Quantas chaves pretende criar? (escolha entre 1 a 5 chaves - ou digite 0 para voltar ao menu inicial)");
        int qtdChaves = in.nextInt();
        if (qtdChaves == 0) return;
        if (qtdChaves >= 1 && qtdChaves <= 5) {
            for (int j = 0; j < qtdChaves; j++) {

                int[] euroMilhoesNumsUt = new int[5];
                int[] euroMilhoesExtraUt = new int[2];
                int numero;
                for (int i = 0; i < 5; i++) {
                    System.out.println("Qual o " + (i + 1) + "º número que pretende?");
                    numero = in.nextInt();
                    if (numero > 0 && numero < 51) {
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesNumsUt[x] == numero) // Verificar se o número aleatório já saiu.
                            {
                                System.out.println("Número repetido! Por favor insira um número entre 1 e 50");
                                numero = in.nextInt();
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }

                        }
                        euroMilhoesNumsUt[i] = numero;
                        numsEuroSortUt = euroMilhoesNumsUt;
                    } else {
                        System.out.println(("Por favor insira um número entre 1 e 50"));
                        i--;
                    }
                }
                Arrays.sort(euroMilhoesNumsUt);

                System.out.print("Escolheu os números: " + Arrays.toString(euroMilhoesNumsUt) + " ");

                System.out.println();

                for (int i = 0; i < 2; i++) {
                    System.out.println("Qual é " + (i + 1) + "ª estrela que pretende?");
                    numero = in.nextInt();
                    if (numero > 0 && numero < 13) {
                        for (int x = 0; x < i; x++) {
                            if (euroMilhoesExtraUt[x] == numero) // Verificar se o número aleatório já saiu.
                            {
                                System.out.println("Número repetido! Por favor insira um número entre 1 e 12");
                                numero = in.nextInt();
                                x = -1; // Apagar número repetido e voltar à posição anterior
                            }

                        }
                        euroMilhoesExtraUt[i] = numero;
                        extraEuroSortUt = euroMilhoesExtraUt;
                    } else {
                        System.out.println(("Por favor insira um número entre 1 e 12"));
                        i--;
                    }
                }

                Arrays.sort(euroMilhoesExtraUt);

                System.out.print("Escolheu as estrelas: " + Arrays.toString(euroMilhoesExtraUt) + " ");

                System.out.println();

                int contadorNums = 0;
                //Comparar com os números da chave do sorteio
                for (int i = 0; i < numsEuroSortUt.length; i++) {
                    for (int k = 0; k < numsEuroSort.length; k++) {
                        if (numsEuroSortUt[i] == numsEuroSort[k]) {
                            contadorNums++;
                        }
                    }
                }

                int contadorExtra = 0;
                //Comparar com as estrelas da chave do sorteio
                for (int i = 0; i < extraEuroSortUt.length; i++) {
                    for (int k = 0; k < extraEuroSort.length; k++) {
                        if (extraEuroSortUt[i] == extraEuroSort[k]) {
                            contadorExtra++;
                        }
                    }
                }
                // Condições para verificar se existe prémio
                if (contadorNums == 5 && contadorExtra == 2) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o primeiro prémio!");
                } else if (contadorNums == 5 && contadorExtra == 1) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o segundo prémio!");
                } else if (contadorNums == 5 && contadorExtra == 0) {
                    System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o terceiro prémio!");
                } else if (contadorNums == 4 && contadorExtra == 2) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quarto prémio!");
                } else if (contadorNums == 4 && contadorExtra == 1) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o quinto prémio!");
                } else if (contadorNums == 3 && contadorExtra == 2) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o sexto prémio!");
                } else if (contadorNums == 4 && contadorExtra == 0) {
                    System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o setimo prémio!");
                } else if (contadorNums == 2 && contadorExtra == 2) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o oitavo prémio!");
                } else if (contadorNums == 3 && contadorExtra == 1) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o nono prémio!");
                } else if (contadorNums == 3 && contadorExtra == 0) {
                    System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o decimo prémio!");
                } else if (contadorNums == 1 && contadorExtra == 2) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o decimo primeiro prémio!");
                } else if (contadorNums == 2 && contadorExtra == 1) {
                    System.out.println("Acertou " + contadorNums + " números e " + contadorExtra + " estrelas! Parabéns ganhou o decimo segundo prémio!");
                } else if (contadorNums == 2 && contadorExtra == 0) {
                    System.out.println("Acertou " + contadorNums + " números mas não acertou nenhuma estrela! Parabéns ganhou o decimo terceiro prémio!");
                } else System.out.println("Infelizmente não lhe saiu nenhum prémio! Boa sorte para o próximo sorteio.");
            }
        } else
            System.out.println("Por favor insira de uma a cinco chaves"); chaveUtilizador(); // caso o utilizador insira um número inválido, chamamos a função chaveUtilizador(). para escapar ao loop o utilizador pode digitar 0. isto evita que ao digitar um número inválido vá parar automáticamente ao menu principal.
        } else
            System.out.println("Tem que criar uma chave de sorteio no menu principal antes de criar as suas chaves!");
    }

    private static void chaveSorteio () {
        int[] euroMilhoesNums = new int[5];
        int[] euroMilhoesExtra = new int[2];
        int randomNum;

        for (int i = 0; i < 5; i++) {
            randomNum = rnd.nextInt(1, 51); // Gerar número aleatório.
            for (int x = 0; x < i; x++) {
                if (euroMilhoesNums[x] == randomNum) // Verificar se o número aleatório já saiu.
                {
                    randomNum = rnd.nextInt(1, 51);// Se o número for repetido, gerar novo número.
                    x = -1; // Apagar número repetido e voltar à posição anterior
                }
            }
            euroMilhoesNums[i] = randomNum;
        }

        for (int i = 0; i < 2; i++) {
            randomNum = rnd.nextInt(1, 13); // Gerar número aleatório.
            for (int x = 0; x < i; x++) {
                if (euroMilhoesExtra[x] == randomNum) // Verificar se o número aleatório já saiu.
                {
                    randomNum = rnd.nextInt(1, 13);// Se o número for repetido, gerar novo número.
                    x = -1; // Apagar número repetido e voltar à posição anterior
                }
            }
            euroMilhoesExtra[i] = randomNum;
        }

        System.out.print("A chave vencedora do EuroMilhões foi sorteada! | Números do EuroMilhões: ");
        for (int i = 0; i < euroMilhoesNums.length; i++)
            Arrays.sort(euroMilhoesNums);
        System.out.print(Arrays.toString(euroMilhoesNums) + " ");

        System.out.print("\tEstrelas do EuroMilhões: ");
        for (int i = 0; i < euroMilhoesExtra.length; i++)
            Arrays.sort(euroMilhoesExtra);
        System.out.print(Arrays.toString(euroMilhoesExtra) + " ");
        System.out.println("");

        numsEuroSort = euroMilhoesNums;
        extraEuroSort = euroMilhoesExtra;
    }
}
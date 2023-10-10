import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();

        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica!");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoPf;
                    do {
                        System.out.println("Escolha uma opção: 1 - Cadastrar Pessoa Física / 2 - Listar Pessoa Física / 0 - Voltar ao menu anterior ");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf) {
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome da pessoa física: ");
                                novapf.nome = scanner.next();

                                System.out.println("Digite o CPF: ");
                                novapf.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal (Digite somente números): ");
                                novapf.rendimento = scanner.nextFloat();

                                System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); //recebe como string e converte para localdate
                                Period periodo = Period.between(date, LocalDate.now());
                                //comparação entre a data de nascimento convertida em localdate e data atual(localdate)

                                novapf.dataNascimento = date;

                                if (periodo.getYears() >= 18){      //comparação de maioridade
                                    System.out.println("A pessoa tem mais de 18 anos");
                                } else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPf.logradouro = scanner.next();

                                System.out.println("Digite o número: ");
                                novoEndPf.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoEndPf.enderecoComercial = true;
                                } else {
                                    novoEndPf.enderecoComercial = false;
                                }

                                novapf.endereco = novoEndPf;

                                listaPf.add(novapf);

                                System.out.println("Cadastro realizado com sucesso! ");

                                break;
                            case 2:

                                if(listaPf.size() > 0){
                                    for( PessoaFisica cadaPf : listaPf ) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaoPf = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }

                                break;
                            case 0:
                                System.out.println("Obrigado por utilizar nosso sistema! Forte abraço! ");
                                break;
                            default:
                                System.out.println("Opção inválida, por favor digite uma opção válida! ");
                                break;
                        }
                    } while (opcaoPf != 0);
                    break;
                    case 2:
                        int opcaoPj;
                        do {
                            System.out.println("Escolha uma opção: 1 - Cadastrar Pessoa Jurídica / 2 - Listar Pessoa Jurídica / 0 - Voltar ao menu anterior ");
                            opcaoPj = scanner.nextInt();

                            switch (opcaoPj) {
                                case 1:
                                    PessoaJuridica novapj = new PessoaJuridica();
                                    Endereco novoEndPj = new Endereco();

                                    System.out.println("Digite o Nome Fantasia: ");
                                    novapj.nome = scanner.next();

                                    System.out.println("Digite a Razão Social: ");
                                    novapj.nome = scanner.next();

                                    System.out.println("Digite o CNPJ: ");
                                    novapj.cnpj = scanner.next();

                                    System.out.println("Digite o rendimento mensal (Digite somente números): ");
                                    novapj.rendimento = scanner.nextFloat();

                                    System.out.println("Digite o logradouro: ");
                                    novoEndPj.logradouro = scanner.next();

                                    System.out.println("Digite o número: ");
                                    novoEndPj.numero = scanner.next();

                                    System.out.println("Este endereço é comercial? S/N: ");
                                    String endCom;
                                    endCom = scanner.next();

                                    if (endCom.equalsIgnoreCase("S")) {
                                        novoEndPj.enderecoComercial = true;
                                    } else {
                                        novoEndPj.enderecoComercial = false;
                                    }

                                    novapj.endereco = novoEndPj;

                                    listaPj.add(novapj);

                                    System.out.println("Cadastro realizado com sucesso! ");

                                    break;
                                case 2:

                                    if(listaPj.size() > 0){
                                        for( PessoaJuridica cadaPj : listaPj ) {
                                            System.out.println();
                                            System.out.println("Nome fantasia: " + cadaPj.nome);
                                            System.out.println("Razão Social: " + cadaPj.razaoSocial);
                                            System.out.println("CNPJ: " + cadaPj.cnpj);
                                            System.out.println("Endereço: " + cadaPj.endereco.logradouro + ", " + cadaPj.endereco.numero);
                                            System.out.println("Imposto a ser pago: " + metodosPj.CalcularImposto(cadaPj.rendimento));
                                            System.out.println();
                                            System.out.println("Digite 0 para continuar");
                                            scanner.nextLine();
                                        }

                                        opcaoPj = scanner.nextInt();

                                    } else {
                                        System.out.println("Lista vazia");
                                    }

                                    break;
                        case 0:
                            System.out.println("Obrigado por utilizar nosso sistema! Forte abraço! ");
                            break;
                        default:
                            System.out.println("Opção inválida, por favor digite uma opção válida! ");
                            break;
                    }
                    } while (opcaoPj != 0);
                    case 0:
                        System.out.println("Obrigado por utilizar nosso sistema! Forte abraço! ");
                        break;
                    default:
                        System.out.println("Opção inválida, por favor digite uma opção válida! ");
                        break;
                }

        } while(opcao != 0);
    }
}
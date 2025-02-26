import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static int obterProximoNumeroArquivo() {
        File pasta = new File(".");
        File[] arquivos = pasta.listFiles((dir, name) -> name.matches("\\d+-.*\\.TXT"));

        int maiorNumero = 0;

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                String nomeArquivo = arquivo.getName();
                int numero = Integer.parseInt(nomeArquivo.split("-")[0]);

                if (numero > maiorNumero) {
                    maiorNumero = numero;
                }
            }
        }

        return maiorNumero + 1;
    }

    public static Usuario readFile(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"))) {
            String pergunta;

            pergunta = br.readLine();
            System.out.println(pergunta);
            usuario.setNome(scanner.nextLine());

            pergunta = br.readLine();
            System.out.println(pergunta);
            usuario.setEmail(scanner.nextLine());

            pergunta = br.readLine();
            System.out.println(pergunta);
            usuario.setIdade(Integer.parseInt(scanner.nextLine()));

            pergunta = br.readLine();
            System.out.println(pergunta);
            usuario.setAltura(Double.parseDouble(scanner.nextLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public static void readAllNames() {
        Scanner scanner = new Scanner(System.in);

        String actualDir = System.getProperty("user.dir");
        File dir = new File(actualDir);
        String regex = "^\\d+-[A-Za-z]+\\.TXT$";
        Pattern pattern = Pattern.compile(regex);

        File[] files = dir.listFiles();
        int num = 0;
        if (files != null) {
            for (File file : files) {
                Matcher matcher = pattern.matcher(file.getName());

                if (matcher.matches()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file.getName()))) {
                        String pergunta;

                        pergunta = br.readLine();
                        num += 1;
                        System.out.println(num + " - " + pergunta);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        scanner.close();
    }

    public static void writeFile(Usuario usuario) {
        int numeroArquivo = obterProximoNumeroArquivo();
        String nomeArquivo = numeroArquivo + "-" + usuario.getIdentificacao() + ".TXT";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write(usuario.getNome() + "\n");
            bw.write(usuario.getEmail() + "\n");
            bw.write(usuario.getIdade() + "\n");
            bw.write(String.valueOf(usuario.getAltura()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewQuestion(Scanner scanner, List<String> perguntas) {
        System.out.println("Qual pergunta deseja adicionar?");
        String newQuestion = scanner.nextLine();
        perguntas.add(newQuestion);
        menu(scanner, perguntas);
    }

    public static void menu(Scanner menu, List<String> questions) {
        while (true) {
            System.out.println("------SISTEMA DE CADASTRO------");
            for (String question : questions) {
                System.out.println(questions.indexOf(question) + 1 + " - " + question);
            }

            int menuOption = menu.nextInt();
            menu.nextLine();

            if (menuOption == 1) {
                cadastrar();
                break;
            } else if (menuOption == 2) {
                readAllNames();
                break;
            } else if (menuOption == 3) {
                createNewQuestion(menu, questions);
                break;
            } else if (menuOption == 4) {
                System.out.println("TO_DO");
                break;
            } else if (menuOption == 5) {
                System.out.println("TO_DO");
                break;
            } else {
                System.out.println("OPÇÃO INVALIDA");
                break;
            }

        }
        menu.close();
    }

    public static void cadastrar() {
        Usuario usuario = new Usuario();

        readFile(usuario);
        writeFile(usuario);
    }

    public static void main(String[] args) {
        
        Scanner menu = new Scanner(System.in);
        String[] questions = { "Cadastrar o usuário", "Listar todos os usuários cadastrados",
                "Cadastrar nova pergunta no formulário", "Deletar pergunta do formulário",
                "Pesquisar usuário por nome ou email " };

        List<String> questionList = new ArrayList<>(Arrays.asList(questions));

        menu(menu, questionList);
    }
}
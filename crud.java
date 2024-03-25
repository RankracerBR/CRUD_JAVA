import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Pessoa{
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}

public class crud{
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String []args){
        boolean executando = true;
        while(executando){
            System.out.println("Escolha uma opção");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Remover Pessoa");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    listarPessoas();
                    break;
                case 3:
                    atualizarPessoa();
                    break;
                case 4:
                    removerPessoa();
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void adicionarPessoa(){
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade);
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }
    
    private static void listarPessoas() {
        if (pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa cadastrada");
        } else {
            System.out.println("Lista de Pessoas: ");
            for (Pessoa pessoa : pessoas){
                System.out.println("Nome: "+ pessoa.getNome() +  ", Idade " + pessoa.getIdade());
            }
        }
    }

    public static void atualizarPessoa(){
        System.out.println("Digite o nome da pessoa que deseja atualizar: ");
        String nome = scanner.nextLine();
        for (Pessoa pessoa : pessoas){
            System.out.println("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.println("Digite a nova idade: ");
            int novaIdade = scanner.nextInt();
            scanner.nextLine();

            pessoa.setNome(novoNome);
            pessoa.setIdade(novaIdade);
            System.out.println("Pessoa atualizada com sucesso!");
            return;
        }
        System.out.println("Pessoa não encontrada.");
    }
    
    public static void removerPessoa(){
        System.out.println("Digite o nome da pessoa que deseja remover: ");
        String nome = scanner.nextLine();
        for(Pessoa pessoa : pessoas){
            if(pessoa.getNome().equalsIgnoreCase(nome))
                pessoas.remove(pessoa);
                System.out.println("Pessoa removida com sucess!");
                return;
        }
        System.out.println("Pessoa não encontrada");
    }

}
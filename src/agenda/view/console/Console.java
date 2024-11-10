package agenda.view.console;

import java.util.Scanner;
import agenda.dao.ContatoDAO;
import agenda.model.Contato;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {
    
    public Console(){
        
        Scanner scanner = new Scanner(System.in);
        ContatoDAO contatoDAO = new ContatoDAO();

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato por ID");
            System.out.println("3. Listar Todos os Contatos");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Deletar Contato");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                
                case 1:                    
                    Contato novoContato = new Contato();
                    System.out.print("Nome: ");
                    novoContato.setNome(scanner.nextLine());

                    System.out.print("Telefone: ");
                    novoContato.setTelefone(scanner.nextLine());

                    String email;
                    while (true) {
                        System.out.print("Email: ");
                        email = scanner.nextLine();
                        if (isEmailValido(email)) {
                            novoContato.setEmail(email);
                            break;
                        } else {
                            System.out.println("Insira um email válido (exemplo@dominio.com).");
                        }
                    }

                    System.out.print("Endereço: ");
                    novoContato.setEndereco(scanner.nextLine());

                    String dataNascimento;
                    while (true) {
                        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
                        dataNascimento = scanner.nextLine();
                        if (isDataValida(dataNascimento)) {
                            novoContato.setDataNascimento(parseData(dataNascimento));
                            break;
                        } else {
                            System.out.println("Insira uma data válida no formato DD/MM/AAAA.");
                        }
                    }

                    System.out.print("Observações: ");
                    novoContato.setObservacoes(scanner.nextLine());

                    contatoDAO.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;

                case 2:                    
                    System.out.print("Digite o ID do contato: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    Contato contato = contatoDAO.buscarContatoPorId(id);
                    if (contato != null) {
                        System.out.println(contato);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:                    
                    List<Contato> contatos = contatoDAO.buscarTodosContatos();
                    for (Contato c : contatos) {
                        System.out.println(c);
                    }
                    break;

                case 4:                    
                    System.out.print("ID do contato a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();  

                    Contato contatoAtualizar = contatoDAO.buscarContatoPorId(idAtualizar);
                    
                    if (contatoAtualizar != null) {
                        
                        System.out.print("Novo Nome (deixe em branco para manter): ");
                        String nome = scanner.nextLine();
                        if (!nome.isEmpty()) contatoAtualizar.setNome(nome);

                        System.out.print("Novo Telefone (deixe em branco para manter): ");
                        String telefone = scanner.nextLine();
                        if (!telefone.isEmpty()) contatoAtualizar.setTelefone(telefone);

                        String novoEmail;
                        while (true) {
                        System.out.print("Novo Email: ");
                        novoEmail = scanner.nextLine();
                        if (isEmailValido(novoEmail)) {
                            contatoAtualizar.setEmail(novoEmail);
                            break;
                        } else {
                            System.out.println("Insira um email válido (exemplo@dominio.com).");
                            }
                        }

                        System.out.print("Novo Endereço (deixe em branco para manter): ");
                        String endereco = scanner.nextLine();
                        if (!endereco.isEmpty()) contatoAtualizar.setEndereco(endereco);

                        String novaDataNascimento;
                        while (true) {
                        System.out.print("Nova Data de Nascimento (DD/MM/AAAA): ");
                        novaDataNascimento = scanner.nextLine();
                        if (isDataValida(novaDataNascimento)) {
                            contatoAtualizar.setDataNascimento(parseData(novaDataNascimento));
                            break;
                        } else {
                            System.out.println("Insira uma data válida no formato DD/MM/AAAA.");
                            }
                        }

                        System.out.print("Novas Observações (deixe em branco para manter): ");
                        String observacoes = scanner.nextLine();
                        if (!observacoes.isEmpty()) contatoAtualizar.setObservacoes(observacoes);

                        contatoDAO.atualizarContato(contatoAtualizar);
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 5:                    
                    System.out.print("Digite o ID do contato a ser deletado: ");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine();  
                    Contato contatoDeletar = contatoDAO.buscarContatoPorId(idDeletar);
                    if (contatoDeletar != null) {
                        contatoDAO.deletarContato(contatoDAO.buscarContatoPorId(idDeletar));
                        System.out.println("Contato deletado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
    
    private boolean isEmailValido(String email) {
        String regex = "^[\\w-\\.]+@[\\w-]+(?:\\.[a-z]{2,})+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isDataValida(String data) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([12][0-9]{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    private LocalDate parseData(String data) {
        String[] partes = data.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        return LocalDate.of(ano, mes, dia);
    }
    
}

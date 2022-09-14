package Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Manifestacao> listmanifestacoes = new ArrayList<>();
        while (true){
        System.out.println("Sistema de Ouvidoria da Universidade ABC");
        System.out.println("Escolha uma das opções do menu: ");
        System.out.println("1 - Criar nova manifestação\n2 - Listar todas as manifestações\n3 - Pesquisar manifestação por ID\n4 - Excluir manifestação\n5 - Sair");
        int entradaMenu = Teclado.leInt();
            while (true) { //Verificação de entrada válida do utilizador
                if (entradaMenu > 5 || entradaMenu <= 0) {
                    System.out.println("Entrada inválida, tente novamente");
                    entradaMenu = Teclado.leInt();
                }
                else {break;}}
            Manifestacao novaManifestacao = new Manifestacao(); //Instanciando a classe Manifestação e criando meu objeto
            if (entradaMenu == 1) {
                int numeroManifestacoes = listmanifestacoes.size(); //Lendo o número de elementos da lista
                if (numeroManifestacoes == 0){
                    novaManifestacao.id =1;
                }else {
                    for (Manifestacao m : listmanifestacoes) {

                        int idManifestacao = m.id + 1;
                        novaManifestacao.id = idManifestacao;
                    }
                }



                System.out.println("Para criar uma manifestação você deve fornecer seu nome, escolher a categoria da manifestação e por fim a descrição");
                System.out.print("Nome: ");
                String nome = Teclado.leString();
                novaManifestacao.nome = nome;
                System.out.printf("Categorias disponíveis\n1 - Reclamação\n2 - Sugestão\n3 - Elogio\n");
                System.out.print("Informe a categoria da sua manifestação: ");
                int tipoManifestacao = Teclado.leInt();
                while (tipoManifestacao < 1 || tipoManifestacao > 3) {
                        System.out.print("Opção inválida, tente novamente: ");
                        tipoManifestacao = Teclado.leInt();}
                if(tipoManifestacao == 1){
                    novaManifestacao.tipo = "Reclamação";
                }
                else if (tipoManifestacao == 2) {
                    novaManifestacao.tipo = "Sugestão";
                }
                else {
                    novaManifestacao.tipo = "Elogio";
                }

                System.out.println("Agora digite sua manifestação");
                String texto = Teclado.leString();
                novaManifestacao.texto = texto;

                listmanifestacoes.add(novaManifestacao); //Adicionando objeto a lista

//                System.out.printf("Id:"+novaManifestacao.id+" Nome: "+novaManifestacao.nome+" Tipo: "+novaManifestacao.tipo+" Descrição: "+novaManifestacao.texto+"\n");
                }
            else if (entradaMenu == 2) {
                int numeroManifestacoes = listmanifestacoes.size();;
                if (numeroManifestacoes == 0)
                    System.out.println("Nemhuma manifestação encontrada");
                else {
                for (Manifestacao m:listmanifestacoes){
                    System.out.printf("Id:"+m.id+" Nome: "+m.nome+" Tipo: "+m.tipo+" Descrição: "+m.texto+"\n");
                }
            }
        }
            else if (entradaMenu == 3) {
//                continue;
                if (listmanifestacoes.size() == 0){
                    System.out.printf("Lista de manifestações vazia\n");
                }
                else {
                    System.out.println("Digite o ID da manifestação: ");
                    int idManifestacao =Teclado.leInt();
                    for (Manifestacao m:listmanifestacoes){
                        if (idManifestacao == m.id){
                            System.out.printf("Id:"+m.id+" Nome: "+m.nome+" Tipo: "+m.tipo+" Descrição: "+m.texto+"\n");
                            break;
                        }
                    }
                }

            }
            else if (entradaMenu == 4) {
                if (listmanifestacoes.size() == 0) {
                    System.out.printf("Lista de manifestações vazia\n");
                } else {
                    System.out.println("Digite o ID da manifestação: ");
                    int idManifestacao = Teclado.leInt();
                    for (Manifestacao m : listmanifestacoes) {
                        if (idManifestacao == m.id) {
                            listmanifestacoes.remove(m);
                            System.out.printf("Manifestação excluída com sucesso\n");
                            break;

                        } else {
                            System.out.printf("Id de manifestação não encontrada\n");
                        }
                    }
                }
            }
            else if (entradaMenu == 5) {
            System.out.println("Obrigado por usar nossos sistemas");
            break;
            }
        }
    }
}






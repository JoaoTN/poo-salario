package exec;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Funcionario;
import model.Professor;
import model.STA;
import model.Terceirizado;


public class Principal{
    public static Scanner tc = new Scanner(System.in);
    public static void main(String args[]){
        String opcao = "";
        List<Funcionario> lista = new ArrayList<Funcionario>();

        while(!opcao.equals("sair")){
            System.out.println("Digite uma opção ou digite ajuda");
            opcao = tc.nextLine();
            String escolha[] = opcao.split(" ");
            switch(escolha[0]){
                case "show":
                    int cont = 0;
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[1].equals(lista.get(i).getNome())){
                            System.out.println(lista.get(i).toString());
                            if(lista.get(i) instanceof Professor){
                                System.out.println("Salário: " +((Professor)lista.get(i)).calcularSalario());
                            }
                            else if(lista.get(i) instanceof STA){
                                System.out.println("Salário: " +((STA)lista.get(i)).calcularSalario());
                            }
                            else if(lista.get(i) instanceof Terceirizado){
                                System.out.println("Salário: " +((Terceirizado)lista.get(i)).calcularSalario());
                            }
                            cont++;
                        }
                    }
                    if(cont == 0){
                        System.out.println("Funcionário " + escolha[1] +" não existe");
                    }
                    System.out.println("Done");
                    break;
                case "addProf":
                    char b = escolha[2].charAt(0);
                    Funcionario novo  = new Professor(escolha[1], b);
                    lista.add(novo);
                    System.out.println("Done");
                    break;
                case "addTer":
                    int d = Integer.parseInt(escolha[2]);
                    boolean e = false;
                    if(escolha[2].equals("sim")){
                        e = true;
                    }
                    else if(escolha[2].equals("não")){
                        e = false;
                    }
                    Funcionario novoT  = new Terceirizado(escolha[1], d, e);
                    lista.add(novoT);
                    System.out.println("Done");
                    break;
                case "addSTA":
                    int c = Integer.parseInt(escolha[2]);
                    Funcionario novoS  = new STA(escolha[1], c);
                    lista.add(novoS);
                    System.out.println("Done");
                    break;
                case "rm":
                    int contr = 0;
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[1].equals(lista.get(i).getNome())){
                            System.out.println(lista.get(i).getNome() + " removido com sucesso");
                            System.out.println("Done");
                            lista.remove(i);
                            contr++;
                            break;
                        }
                    }
                    if(contr == 0){
                        System.out.println("funcionario" + escolha[1] + " não existe");
                    }
                    break;
                case "addDiaria":
                    for(int i = 0; i < lista.size(); i++){
                        if(escolha[1].equals(lista.get(i).getNome())){
                            if(lista.get(i).addDiaria()){
                                System.out.println("Done");
                            }
                            else{
                                if(lista.get(i) instanceof Terceirizado){
                                    System.out.println("Não pode receber diaria");
                                }
                                else{
                                    System.out.println("fail: limite de diarias atingido");
                                }
                            }
                        }
                    }
                    break;
                case "setBonus":
                    double resultado,conv;
                    conv = Double.parseDouble(escolha[1]);
                    resultado = conv / lista.size();
                    for(int i = 0; i < lista.size(); i++){
                        lista.get(i).setBonus(resultado);
                    }
                    System.out.println("Done");
                    break;
                case "sair":
                    break;
                case "ajuda":
                    String ajudando = "Você tem as seguintes opções: \n" +
                                        "1 - Adicionar um funcionário: addProf _nome _tipodeprofessor, addTer _nome _horastrabalhadas _salubrilidade, addSTA _nome _nível. \n" +
                                        "2 - Ver funcionários: show _nomedofuncionário. \n" +
                                        "3 - Remover funcionário: rm _nomedofuncionário. \n" +
                                        "4 - Adicionar diária: addDiaria _nomedofuncionário. \n" +
                                        "5 - Dar bônus aos funcionários: setBonus _númerodebônus. \n" +
                                        "6 - Sair do programa: sair.";
                    
                    System.out.println(ajudando);
                    break;
            }
        }
    }   
}
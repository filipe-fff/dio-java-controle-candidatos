package cadidatura;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {

        String[] candidatos = {"Filipe", "Julia", "Pedro", "Erica", "Fernanda", "Matheus", "Luiza", "Ronaldo", "Ivan", "Daniela"};
        ArrayList<String> candidatosSelecionados = new ArrayList<>();

        int candidatoAtual = 0;
        int candidatoAprovado = 0;
        String nome;
        double valor;
        double salario = 2000.0;
        while(candidatoAprovado < 5 && candidatoAtual < candidatos.length) {
            nome = candidatos[candidatoAtual];
            valor = valorSelecionado();
            System.out.printf("O candidato %s quer R$%f.\n", nome, valor);

            if(salario >= valor) candidatosSelecionados.add(nome);
            candidatoAtual++;
        }
        listarCandidatosSelecionados(candidatosSelecionados);
        telefonarSelecionado(candidatosSelecionados);
    }
    public static void telefonarSelecionado(ArrayList<String> candidatos) {
        int tentativa;
        boolean ligou;
        for(String candidato : candidatos) {
            System.out.printf("Ligando para %s:\n", candidato);
            System.out.println("-------------------------------");
            tentativa = 0;
            do {
                System.out.println("discando");
                ligou = telefonando();
                tentativa++;
            } while (!ligou && tentativa < 3);
            if(ligou) System.out.println("\tLigou...");
            else System.out.println("\tNão ligou...");
        }
    }
    public static boolean telefonando() {
        return new Random().nextInt(3) == 1;
    }
    public static double valorSelecionado() {
        return ThreadLocalRandom.current().nextDouble(1000, 3000);
    }
    public static void listarCandidatosSelecionados(ArrayList<String> candidatos) {
        System.out.println("-----------------------------");
        System.out.println("Candidatos selecionados:");
        System.out.println("-----------------------------");
        for (int n = 0; n < candidatos.size(); n++) {
            System.out.printf("N°%d\t\t%s\n\n", n+1, candidatos.get(n));
        };
    };
    public static void analizarCandidato(double valor) {
        double salario = 2000.0;
        if (salario > valor) System.out.println("LIGAR PARA O CANDIDATO.");
        else if (salario == valor) System.out.println("LIGAR PARA O CANDIDATO COM OUTRA PROPOSTA.");
        else System.out.println("ARGUADANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
    }
}
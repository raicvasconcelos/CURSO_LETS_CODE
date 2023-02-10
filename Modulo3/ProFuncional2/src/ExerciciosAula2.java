import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* 
exercicio 1:
Escreva um método que aceite uma lista de pessoas e use Predicates para verificar se há pelo menos uma pessoa com idade acima de 50 anos e que seja solteira.

exercicio 2:
Escreva um método que aceite uma lista de pessoas e use Predicates para verificar se há pelo menos uma pessoa com idade acima de 50 anos e que seja casada.

Exercício 3:
Escreva um método que aceite uma lista de estudantes e use Predicates para verificar se há pelo menos um estudante com idade acima de 18 anos e que tenha uma média de notas acima de 85.

Exercicio 4:
Escreva um método que aceite duas listas de strings e use um BiPredicate para verificar se a primeira string da primeira lista é igual à primeira string da segunda lista, a segunda string da primeira lista é igual à segunda string da segunda lista, e assim por diante.

Exercicio 5:
Escreva um método que aceite uma lista de objetos de funcionários e use uma Function para extrair o nome de cada funcionário e retornar uma lista de strings.

Exercicio 6:
Escreva um método que aceite uma lista de estudantes e use uma Function para extrair a média de notas de cada estudante e retornar uma lista de números inteiros.

Exercicio 7:
Escreva um método que aceite uma lista de estudantes e use um Consumer para calcular a média de notas de todos os estudantes, e depois imprimir o resultado na tela.

Exercicio 8:
Escreva um método que aceite uma lista de números inteiros e use um Consumer para aplicar uma operação matemática (raiz quadrada ou cálculo do quadrado) em cada elemento da lista, e depois imprimir o resultado na tela.

Exercicio 9:
Escreva um método que use um Supplier para gerar uma lista de números inteiros aleatórios. Imprima a lista na tela.

Exercicio 10:
Escreva um método que aceite uma lista de objetos de funcionários e use um UnaryOperator para aumentar o salário de cada funcionário em 10%
*/

public class ExerciciosAula2 {

    private static List<Pessoa> pessoas = Arrays.asList(
            new Pessoa(12, EstadoCivil.SOLTEIRO), 
            new Pessoa(40, EstadoCivil.CASADO), 
            new Pessoa(30, EstadoCivil.DIVORCIADO), 
            new Pessoa(55, EstadoCivil.SOLTEIRO),
            new Pessoa(120, EstadoCivil.CASADO)
            );
    private static List<Estudante> estudantes = Arrays.asList(
                new Estudante(12, Double.valueOf(44.5)), 
                new Estudante(20, Double.valueOf(64.5)),
                new Estudante(19, Double.valueOf(99.5)),
                new Estudante(22, Double.valueOf(88.75)),
                new Estudante(25, Double.valueOf(94.15))
            );

    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
    }

    public static void exercicio1(){
        Predicate<Pessoa> verificaSolteiro = p -> p.getEstadoCivil() == EstadoCivil.SOLTEIRO;
        Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

        System.out.println(filter(pessoas, verifica50anos.and(verificaSolteiro)).toString());
    }

    public static void exercicio2() {
        Predicate<Pessoa> verificaCasado = p -> p.getEstadoCivil() == EstadoCivil.CASADO;
        Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

        System.out.println(filter(pessoas, verifica50anos.and(verificaCasado)).toString());
    }
    
    public static void exercicio3() {
        Predicate<Estudante> verifica18anos = e -> e.getIdade() >= 18;
        Predicate<Estudante> verificaMediaAcima85 = e -> e.getMediaNotas() >= Double.valueOf(85);
        
        System.out.println(filter(estudantes, verifica18anos.and(verificaMediaAcima85)).toString());
    }

    public static void exercicio4() {
        List<String> numeros1 = Arrays.asList("1", "2", "3", "4");
        List<String> numeros2 = Arrays.asList("1", "2", "7", "4");

        BiPredicate<String, String> comparaStrings = (a, b) -> a.equals(b);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> condition){
        List<T> listaFiltrada = new ArrayList<>();
        for (T t : list) {
            if(condition.test(t)){
                listaFiltrada.add(t);
            }
        }
        return listaFiltrada;
    }

    public static <T> List<T> biFilter(List<T> list1, List<T> list2, BiPredicate<T> bicondition) {
        List<T> listaFiltrada = new ArrayList<>();
        for (T t : list) {
            if(condition.test(t)){
                listaFiltrada.add(t);
            }
        }
        return listaFiltrada;
    }
}

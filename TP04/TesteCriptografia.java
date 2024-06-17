public class TesteCriptografia {

    public static void main(String[] args) {
        System.out.println("Teste de Substituição:");
        Criptografia.testarSubstituicao();

        System.out.println("\nTeste de Transposição:");
        Criptografia.testarTransposicao();

        System.out.println("\nTeste de Cifragem Completa:");
        Criptografia.testarCifragemCompleta();
    }
}

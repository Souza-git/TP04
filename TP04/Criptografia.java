import java.util.Arrays;

public class Criptografia {

    private static final String chave = "minha-chave-secreta";  

    // Função de substituição
    private static byte[] substituir(byte[] dados, String chave) {
        byte[] substituicoes = new byte[256];
        for (int i = 0; i < 256; i++) {
            substituicoes[i] = (byte) i;
        }

        for (int i = 0; i < chave.length(); i++) {
            int j = (chave.charAt(i) + i) % 256;
            byte temp = substituicoes[i % 256];
            substituicoes[i % 256] = substituicoes[j];
            substituicoes[j] = temp;
        }

        byte[] resultado = new byte[dados.length];
        for (int i = 0; i < dados.length; i++) {
            resultado[i] = substituicoes[dados[i] & 0xFF];
        }

        return resultado;
    }

    // Funçao de substituição inversa
    private static byte[] substituirInverso(byte[] dados, String chave) {
        byte[] substituicoes = new byte[256];
        for (int i = 0; i < 256; i++) {
            substituicoes[i] = (byte) i;
        }

        for (int i = 0; i < chave.length(); i++) {
            int j = (chave.charAt(i) + i) % 256;
            byte temp = substituicoes[i % 256];
            substituicoes[i % 256] = substituicoes[j];
            substituicoes[j] = temp;
        }

        byte[] inversa = new byte[256];
        for (int i = 0; i < 256; i++) {
            inversa[substituicoes[i] & 0xFF] = (byte) i;
        }

        byte[] resultado = new byte[dados.length];
        for (int i = 0; i < dados.length; i++) {
            resultado[i] = inversa[dados[i] & 0xFF];
        }

        return resultado;
    }

    // Função de transposição
    private static byte[] transpor(byte[] dados, String chave) {
        int tamanho = chave.length();
        byte[] resultado = new byte[dados.length];

        // Inicializando o array de resultado com valores padrão
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = dados[i];
        }

        for (int i = 0; i < dados.length; i++) {
            int j = (i + chave.charAt(i % tamanho)) % dados.length;
            byte temp = resultado[i];
            resultado[i] = resultado[j];
            resultado[j] = temp;
        }

        return resultado;
    }

    // Função de transposção inversa
    private static byte[] transporInverso(byte[] dados, String chave) {
        int tamanho = chave.length();
        byte[] resultado = new byte[dados.length];

        // Inicializando o array de resultado com valores padrão
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = dados[i];
        }

        for (int i = dados.length - 1; i >= 0; i--) {
            int j = (i + chave.charAt(i % tamanho)) % dados.length;
            byte temp = resultado[i];
            resultado[i] = resultado[j];
            resultado[j] = temp;
        }

        return resultado;
    }

    // Funçao para cifrar
    public static byte[] cifrar(byte[] dados, String chave) {
        // Primeira etapa substituição
        byte[] dadosSubstituidos = substituir(dados, chave);
        // Segunda etapa: transposição
        byte[] dadosCifrados = transpor(dadosSubstituidos, chave);
        return dadosCifrados;
    }

    // Função para decifrar
    public static byte[] decifrar(byte[] dados, String chave) {
        // Primeira etapa: transposição inversa
        byte[] dadosTranspostos = transporInverso(dados, chave);
        // Segunda etapa: substituição inversa
        byte[] dadosDecifrados = substituirInverso(dadosTranspostos, chave);
        return dadosDecifrados;
    }

    // Metodo de teste pra substituição
    public static void testarSubstituicao() {
        String texto = "Texto de exemplo para teste de substituição";
        byte[] dados = texto.getBytes();
        System.out.println("Dados Originais: " + Arrays.toString(dados));

        byte[] dadosCifrados = substituir(dados, chave);
        System.out.println("Dados Substituídos: " + Arrays.toString(dadosCifrados));

        byte[] dadosDecifrados = substituirInverso(dadosCifrados, chave);
        System.out.println("Dados Decifrados: " + Arrays.toString(dadosDecifrados));

        String textoDecifrado = new String(dadosDecifrados);
        System.out.println("Texto Decifrado: " + textoDecifrado);

        assert Arrays.equals(dados, dadosDecifrados) : "Falha na substituição";
    }

    // Metodo de teste para transposição
    public static void testarTransposicao() {
        String texto = "Texto de exemplo para teste de transposição";
        byte[] dados = texto.getBytes();
        System.out.println("Dados Originais: " + Arrays.toString(dados));

        byte[] dadosCifrados = transpor(dados, chave);
        System.out.println("Dados Transpostos: " + Arrays.toString(dadosCifrados));

        byte[] dadosDecifrados = transporInverso(dadosCifrados, chave);
        System.out.println("Dados Decifrados: " + Arrays.toString(dadosDecifrados));

        String textoDecifrado = new String(dadosDecifrados);
        System.out.println("Texto Decifrado: " + textoDecifrado);

        assert Arrays.equals(dados, dadosDecifrados) : "Falha na transposição";
    }

    // Metodo de teste pra cifragem e decifragem completa
    public static void testarCifragemCompleta() {
        String texto = "Texto de exemplo para teste de cifragem completa";
        byte[] dados = texto.getBytes();
        System.out.println("Dados Originais: " + Arrays.toString(dados));

        byte[] dadosCifrados = cifrar(dados, chave);
        System.out.println("Dados Cifrados: " + Arrays.toString(dadosCifrados));

        byte[] dadosDecifrados = decifrar(dadosCifrados, chave);
        System.out.println("Dados Decifrados: " + Arrays.toString(dadosDecifrados));

        String textoDecifrado = new String(dadosDecifrados);
        System.out.println("Texto Decifrado: " + textoDecifrado);

        assert Arrays.equals(dados, dadosDecifrados) : "Falha na cifragem completa";
    }
}

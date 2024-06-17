import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private int hashsenha;
    private static final String chave = "minha-chave-secreta";  // Chave de exemplo

    public byte[] toByteArray() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(this.idUsuario);
        dos.writeUTF(this.nome);
        dos.writeUTF(this.email);
        dos.writeInt(this.hashsenha);
        byte[] dados = baos.toByteArray();
        byte[] dadosCifrados = Criptografia.cifrar(dados, chave);
        return dadosCifrados;
    }

    public static Usuario fromByteArray(byte[] bytes) throws Exception {
        byte[] dadosDecifrados = Criptografia.decifrar(bytes, chave);
        ByteArrayInputStream bais = new ByteArrayInputStream(dadosDecifrados);
        DataInputStream dis = new DataInputStream(bais);
        Usuario usuario = new Usuario();
        usuario.idUsuario = dis.readInt();
        usuario.nome = dis.readUTF();
        usuario.email = dis.readUTF();
        usuario.hashsenha = dis.readInt();
        return usuario;
    }

    // Getters e setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHashsenha() {
        return hashsenha;
    }

    public void setHashsenha(int hashsenha) {
        this.hashsenha = hashsenha;
    }
}


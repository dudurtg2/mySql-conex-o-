package DTO;

public class ProdutoDTO {
    private int code;
    private String nome;
    private float preco;
    
    public ProdutoDTO(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public ProdutoDTO(String nome, float preco, int code) {
        this.code = code;
        this.nome = nome;
        this.preco = preco;
    }
    public int getCode() {
        return code;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

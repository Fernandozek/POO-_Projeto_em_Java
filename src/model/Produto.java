
package model;

public class Produto {
    private int id;
    private String categoria;
    private String nome;
    private double preco;
    private int codigo;
    private double ml;
    private double quant;
    private double estoque;
    private String validade;
    private String marca;
    
    private int value;
    private String label;
    

    public Produto(int id, String categoria, String nome, double preco, int codigo, double ml, double quant, String validade, String marca) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.ml = ml;
        this.quant = quant;
        this.validade = validade;
        this.marca = marca;
    }
    
    public Produto(int value, String label) {
        this.value = value;
        this.label = label;
    }
    public Produto( String categoria, String nome, double preco, int codigo, double ml, double quant, String validade, String marca) {
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.ml = ml;
        this.quant = quant;
        this.validade = validade;
        this.marca = marca;
    }
   
    public Produto( String categoria, String nome, double preco, double ml, double quant, String validade, String marca) {
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.ml = ml;
        this.quant = quant;
        this.validade = validade;
        this.marca = marca;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque() {
        this.estoque = this.quant;
    }
    
    
}
    
    

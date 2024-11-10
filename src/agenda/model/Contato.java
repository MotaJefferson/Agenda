package agenda.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contato {
    
    private int contatoId;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;
    private LocalDateTime criadoEm;
    private String observacoes;

    public Contato() {
        this.criadoEm = LocalDateTime.now(); 
    }

    public Contato(String nome, String telefone, String email, String endereco, LocalDate dataNascimento, String observacoes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.criadoEm = LocalDateTime.now();
        this.observacoes = observacoes;
    }

    public int getContatoId() {
        return contatoId;
    }

    public void setContatoId(int contatoId) {
        this.contatoId = contatoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "contatoId=" + contatoId +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", criadoEm=" + criadoEm +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
    
}

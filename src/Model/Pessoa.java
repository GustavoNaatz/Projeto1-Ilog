package Model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public  abstract class Pessoa   {
   public String nome;
   public Integer telefone;
   public LocalDate dataDeNascimento;
   public Long cpf;
   public int cod;

   public Pessoa(String nome, Integer telefone, LocalDate dataDeNascimento, Long cpf, int cod) {
      this.nome = nome;
      this.telefone = telefone;
      this.dataDeNascimento = dataDeNascimento;
      this.cpf = cpf;
      this.cod = cod;
   }

   @Override
   public String toString() {
      return "Pessoa{" +
              "nome='" + nome + '\'' +
              ", telefone=" + telefone +
              ", dataDeNascimento=" + dataDeNascimento +
              ", cpf=" + cpf +
              ", cod=" + cod +
              '}';
   }
   public String relatorio(){
      return  " Codigo: " + cod + " Nome: " + nome + " Cpf: " + cpf; //  String utilizada em "listar"
   }
   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Integer getTelefone() {
      return telefone;
   }

   public void setTelefone(Integer telefone) {
      this.telefone = telefone;
   }

   public LocalDate getDataDeNascimento() {
      return dataDeNascimento;
   }

   public void setDataDeNascimento(LocalDate dataDeNascimento) {
      this.dataDeNascimento = dataDeNascimento;
   }

   public Long getCpf() {
      return cpf;
   }

   public void setCpf(Long cpf) {
      this.cpf = cpf;
   }

   public int getCod() {
      return cod;
   }

   public void setCod(int cod) {
      this.cod = cod;
   }
}
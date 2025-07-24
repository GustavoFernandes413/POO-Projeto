package br.com.ufersa.exceptions;

public class PessoaExisteException extends  Exception {
    public PessoaExisteException(String mensage){
        super(mensage);
    }
}

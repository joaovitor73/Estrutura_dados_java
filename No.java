package org.example;

public class No<T> {

    private T conteudo;
    private No<T> refNo;

    public No(){
        this.refNo = null;
    }

    public No(T conteudo){
        this.conteudo = conteudo;
        this.refNo = null;
    }

    public No(T conteudo, No<T> refNo) {
        this.conteudo = conteudo;
        this.refNo = refNo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No reNo) {
        this.refNo = reNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeada(){
        String str = "No{" +
                "conteudo=" + conteudo +
                '}';
        if(refNo != null){
            str += "-->" + refNo.toString();
        }else{
            str += "-->null";
        }
        return str;
    }
}

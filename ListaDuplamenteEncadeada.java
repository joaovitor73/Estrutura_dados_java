package org.example;

public class ListaDuplamenteEncadeada<T>{

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista ;

    public ListaDuplamenteEncadeada(){
        this. tamanhoLista = 0;
        primeiroNo = null;
        ultimoNo = null;
    }

    public void add(T conteudo){
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProximo(null);
        novoNo.setNoAnterior(ultimoNo);

        if(primeiroNo == null){
            primeiroNo = novoNo;
        }

        if(ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        this.ultimoNo = novoNo;
        this.tamanhoLista++;
    }

    public void add(int index, T conteudo){
        NoDuplo<T> noAux = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoProximo(noAux);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoAnterior(noAux.getNoAnterior());
            novoNo.getNoProximo().setNoAnterior(novoNo);

        }else{
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index==0){
            primeiroNo = novoNo;
        }else{
            novoNo.getNoAnterior().setNoProximo(novoNo);
        }

        this.tamanhoLista++;
    }

    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoAnterior(null);
            }
        }else{
            NoDuplo<T> noAux = getNo(index);
            noAux.getNoAnterior().setNoProximo(noAux.getNoProximo());
            if(noAux != ultimoNo){
                noAux.getNoProximo().setNoAnterior(noAux.getNoAnterior());
            }else{
                ultimoNo = noAux;
            }
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAux = primeiroNo;
        for(int i = 0; ((i < index) && (noAux != null)); i++){
            noAux = noAux.getNoProximo();
        }
        return noAux;
    }

    public int size(){
        return this.tamanhoLista;
    }


    @Override
    public String toString() {
        String str = "";
        NoDuplo<T> noAux = primeiroNo;
        for(int i = 0; i < size(); i++){
            str += "[No{" +
                "conteudo=" + noAux.getConteudo() +
                        "}-->";
            noAux =  noAux.getNoProximo();
        }
        str += "null";
        return str;
    }
}

package org.example;

public class ListaCircular<T>{
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(isEmpity()){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setRefNo(this.cauda);
        }else{
            novoNo.setRefNo(this.cauda);
            this.cabeca.setRefNo(novoNo);
            this.cauda = novoNo;
        }
        tamanho--;
    }

    public void remove(int index){
        if(index >= this.tamanho)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No<T> noAux = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getRefNo();
            this.cabeca.setRefNo(this.cauda);
        }else if(index == 1){
            this.cauda.setRefNo(this.cauda.getRefNo().getRefNo());
        }else{
            for(int i = 0; i < index-1; i++){
                noAux = noAux.getRefNo();
            }
            noAux.setRefNo(noAux.getRefNo().getRefNo());
        }
        this.tamanho--;

    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpity())
            throw new IndexOutOfBoundsException("A lista está vazia!");

        if(index == 0)
            return cauda;

        No<T> noAux = this.cauda;
        for(int i = 0; i < index; i++){
            noAux = noAux.getRefNo();
        }

        return noAux;
    }
    public boolean isEmpity(){
        return tamanho == 0 ? true : false;
    }
    public int size(){
        return this.tamanho;
    }
}

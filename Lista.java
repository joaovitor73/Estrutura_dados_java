package org.example;

public class Lista<T> {

    private No<T> refNoAnterior;

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpity()){
            refNoAnterior = novoNo;
            return;
        }

        No<T> noAux =  refNoAnterior;
        for(int i = 0; i < this.size()-1; i++){
            noAux = noAux.getRefNo();
        }

        noAux.setRefNo(novoNo);
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAux = refNoAnterior;
        No<T> noRetorno = null;
        for(int i = 0; i <= index; i++){
            noRetorno = noAux;
            noAux = noAux.getRefNo();
        }
        return  noRetorno;
    }

    public T remove(int index){

        No<T> noPivo = this.getNo(index);
        if(index == 0){
            refNoAnterior = noPivo.getRefNo();
            return noPivo.getConteudo();
        }

        No<T> noAnterior = this.getNo(index-1);
        noAnterior.setRefNo(noPivo.getRefNo());
        return noPivo.getConteudo();
    }

    public Lista(){
        this.refNoAnterior = null;
    }

    public int size(){
        int tamanho = 0;
        No noAux = refNoAnterior;
        while(true){
            if(noAux != null){
                tamanho++;
                if(noAux.getRefNo() != null){
                    noAux = noAux.getRefNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return  tamanho;
    }

    public boolean isEmpity(){
        return refNoAnterior == null ? true : false;
    }

    private void validaIndice(int index){
        if(index >= this.size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteudo no indice: " + index + ". A lista só vai até o índice: " +  ultimoIndice + ". ");
        }
    }

    @Override
    public String toString() {
        String str = "";
        No<T> noAux = refNoAnterior;

        for(int i = 0; i < this.size(); i++){
            str +=  "[No{" + "conteudo=" +
                    noAux.getConteudo() +
                    "}]-->";
            noAux =  noAux.getRefNo();
        }
        str += "-->null";
        return str;
    }
}

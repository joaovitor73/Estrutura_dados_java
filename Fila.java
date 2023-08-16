package org.example;

public class Fila<T> {

    private No<T> refNoAnterior;

    public Fila(){
        this.refNoAnterior = null;
    }
    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoAnterior);
        refNoAnterior = novoNo;
    }

    public T first(){
        No primeiroNo = refNoAnterior;
        if(!isEmpity()) {
            while (true) {
                if (primeiroNo.getRefNo() != null)
                    primeiroNo = primeiroNo.getRefNo();
                else break;
            }
            return (T) primeiroNo.getConteudo();
        }
        return null;
    }
    public T dequeue(){
        No primeiroNo = refNoAnterior;
        No noAux = refNoAnterior;
        if(!isEmpity()) {
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAux.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getConteudo();
        }
        return null;
    }
    public boolean isEmpity(){
        return refNoAnterior == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAux =  refNoAnterior;

        if(!isEmpity()){
            while(true){
                stringRetorno += "[No{dados=" + noAux.getConteudo() + "}]-->";
                if (noAux.getRefNo() != null) {
                    noAux = noAux.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}

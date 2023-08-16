package org.example;

public class Pilha {

    private No refNoAtual;

    public Pilha(){
        this.refNoAtual = null;
    }

    public void push(No novoNo){
        No refAux = refNoAtual;
        refNoAtual = novoNo;
        refNoAtual.setRefNo(refAux);
    }

    public No pop(){
        if(!this.isEmpity()){
            No nopoped = refNoAtual;
            refNoAtual = refNoAtual.getRefNo();
            return nopoped;
        }
        return null;
    }

    public No top(){
        return refNoAtual;
    }
    public boolean isEmpity(){
        return refNoAtual == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "------------------\n";
        stringRetorno += "\tPilha\n";
        stringRetorno += "------------------\n";

        No refNoAux = refNoAtual;

        while(true){
            if(refNoAux != null){
                stringRetorno += "[No{dados= " + refNoAux.getConteudo() + "}]\n";
                refNoAux = refNoAux.getRefNo();
            }else{
                break;
            }
        }
        stringRetorno += "================\n";
        return stringRetorno;
    }
}

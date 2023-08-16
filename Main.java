package org.example;

public class Main {
    public static void main(String[] args) {
     /*   Pilha minhaPilha = new Pilha();
        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.pop();
        System.out.println(minhaPilha);
    */
/*
        Fila<String> minhaFila = new Fila<>();
        minhaFila.enqueue("1");
        minhaFila.enqueue("2");
        minhaFila.enqueue("3");
        minhaFila.enqueue("4");
        System.out.println(minhaFila);

        minhaFila.dequeue();
        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
*/
       /* Lista<String> minhaLista = new Lista<>();
        minhaLista.add("conteudo 1");
        minhaLista.add("conteudo 2");
        minhaLista.add("conteudo 3");
        minhaLista.add("conteudo 4");

        System.out.println(minhaLista);

        System.out.println(minhaLista.get(0));
        System.out.println(minhaLista.get(1));
        System.out.println(minhaLista.get(2));
        System.out.println(minhaLista.get(3));

        System.out.println(minhaLista.remove(2));
        System.out.println(minhaLista);*/

        ListaDuplamenteEncadeada<String> minhaListaDuplamenteEncadeada = new ListaDuplamenteEncadeada<>();
        minhaListaDuplamenteEncadeada.add("c1");
        minhaListaDuplamenteEncadeada.add("c2");
        minhaListaDuplamenteEncadeada.add("c3");
        minhaListaDuplamenteEncadeada.add("c4");

        System.out.println(minhaListaDuplamenteEncadeada);

       // minhaListaDuplamenteEncadeada.remove(3);

        System.out.println(minhaListaDuplamenteEncadeada);

        minhaListaDuplamenteEncadeada.add(4,"99");
        minhaListaDuplamenteEncadeada.add("4");

        System.out.println(minhaListaDuplamenteEncadeada);


    }
}
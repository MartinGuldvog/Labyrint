import java.util.NoSuchElementException;
import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {

    //Klassen node med konstruktør
    public class Node {
        Node neste = null;
        T data;

        public Node(T elem){
            data = elem;
        }
    }

    public class LenkelisteIterator implements Iterator<T>{
        private Node posisjon;

        public LenkelisteIterator(){
            posisjon = start;
        }

        public boolean hasNext(){
            return posisjon != null;
        }

        public T next(){
            if (posisjon != null){
                T temp = posisjon.data;
                posisjon = posisjon.neste;
                return temp;
            }else {
                throw new NoSuchElementException();
            }
        }
    }

    public Node start = null;
    public int lengde;

    public Iterator<T> iterator(){
        LenkelisteIterator ny = new LenkelisteIterator();
        return ny;
    }

    //sjekker om neste har verdi, hvis ikke bryter loopen. returnerer teller.
    public int stoerrelse(){
        Node temp = start;
        int teller = 0;
        while (temp != null){
            teller++;
            temp = temp.neste;
        }
        lengde = teller;
        return teller;
    }

    //throws om parameter er feil. Oppretter node og setter inn på rett index.
    public void leggTil(int pos, T x){
        if (pos < 0 || pos > lengde){
            throw new UgyldigListeIndeks(pos);
        }
        Node node = new Node(x);
        Node temp = start;
        Node p = start;

        if (start == null){ //dersom lista er tom, opprettes første
            start = node;
        }else if (pos == 0){ //dersom pos er 0 må start bli node.
            start = node;
            start.neste = temp;
        }else{ //for alle andre tilfeller
            for (int i = 0; i < pos-1; i++){
                temp = temp.neste;
            }
            p = temp.neste;
            temp.neste = node;
            node.neste = p;
        }
        lengde++;
    }

    //legger element bakerst i liste
    public void leggTil(T x){
        Node node = new Node(x);

        if (start == null) { //om listen er tom settes start til ny node.
            start = node;
        }else {//Ellers itererer til slutten av listen
            Node temp = start;
            while (temp.neste != null) {
                temp = temp.neste;
            }
            temp.neste = node; //Når neste == null, er neste ny node.
        }
        lengde++;
    }

    //finner rett node, og endrer data.
    public void sett(int pos, T x){
        if (pos >= lengde || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }else{
            Node node = start;
            for (int i = 0; i < pos; i++){
                node = node.neste;
            }
            node.data = x;
        }
    }

    //finner rett node, og returnerer data.
    public T hent(int pos){
        if (pos > lengde-1 || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }

        Node temp = start;
        for (int i = 0; i < pos; i++){
            temp = temp.neste;
        }
        return temp.data;
    }

    //fjerner element etter index
    public T fjern(int pos){
        if (pos > lengde-1 || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }
        //tilfellet det er den første noden skal slettes
        if (pos == 0) {
            return fjern();
        }
        //iterer over listen til vi finner rett node.
        Node temp = start;
        for (int i = 0; i < pos-1; i++){
            temp = temp.neste;
        }
        T retur = temp.neste.data;
        temp.neste = temp.neste.neste;
        lengde--;
        return retur;
    }

    //fjerner første element i lista.
    public T fjern(){
        if (lengde == 0){
            throw new UgyldigListeIndeks(-1);
        }else{
            T retur = start.data;
            start = start.neste;
            lengde--;
            return retur;

        }
    }
}

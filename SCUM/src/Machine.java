public class Machine<T>  {
    //tem de receber argumentos de qualquer tipo

    public Machine() {

    }

    public T mono(MonoOperation<T> monoOperation, T i1){
        return monoOperation.monoOperation(i1);

    }

    public T bio(BioOperation<T> bioOperation, T i1, T i2){
        return bioOperation.bioOperation(i1, i2);
    }




}

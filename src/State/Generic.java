package State;

public class Generic <T>{
    private T data;
    
    public void setValue(T Gendata){
        data = Gendata;
    }
    
    public T getValue(){
        return data;
    }
}

package biblioteca;
//MIXIN?
public abstract class DomainObject {
    private long id;

    public DomainObject(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }
}

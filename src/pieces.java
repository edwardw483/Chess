public class pieces {
    //Properties
    String name;
    String colour;
    boolean movedFromInitial;
    int position;

    public void copy(pieces p){
        this.name = p.name;
        this.colour = p.colour;
        this.movedFromInitial = p.movedFromInitial;
        this.position = p.position;
        return;
    }

    public pieces(){
        movedFromInitial = false;
    }
}

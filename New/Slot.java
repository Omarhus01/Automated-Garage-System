public class Slot implements ISlot{
    private float length;
    private float width;
    private Vehicle occupant;

    public Slot() {
        length = 0;
        width = 0;
        occupant = null;
    }
    
    @Override
    public void setLength(float l){
        length = l;
    }

    @Override
    public void setWidth(float w){
        width = w;
    }

    @Override
    public float getLength(){return length;}

    @Override
    public float getWidth(){return width;}

    @Override
    public float getArea(){return length*width;}

    @Override
    public void setDimention(float l, float w){
        length = l;
        width = w;
    }

    @Override
    public void setOccupant(Vehicle v){
        occupant = v;
    }

    @Override
    public Vehicle getOccupant(){
        return occupant;
    }
}
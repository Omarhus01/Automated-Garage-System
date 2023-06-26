interface ISlot{
    public void setLength(float l);
    public void setWidth(float w);
    public float getLength();
    public float getWidth();
    public float getArea();
    public void setDimention(float l, float w);
    public void setOccupant(Vehicle v);
    public Vehicle getOccupant();
}
class WaterJug{
    private int waterQuantity = 500;
    private WaterJug(){}
    private WaterJug object = null;
    // Method to provide the service of Giving Water.
    public int getWater(int quantity){
        waterQuantity -= quantity;
        return quantity;
    }
    // Method to return the object to the user.
    public static Waterjug getInstance(){
    // Will Create a new object if the object is not already created and return the
        if(object == null){
        object = new WaterJug();
    }
    return object;
    }
}

class Singleton {

    public static void main(Sttring[] args){

        /**
        In the above class, the Constructor is private so we cannot create the object of the
        class. But we can get the object by calling the method getInstance(). And the
        getInstance is static so it can be called without creating the object. And it returns the
        object. Now with that object, we can call getWater() to get the water.
        */

        Waterjug glass1 = WaterJug.getInstance();
        glass1.getWater(1);

    }
}
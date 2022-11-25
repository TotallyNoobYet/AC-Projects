public enum Importance {
    HIGH,
    MEDIUM,
    LOW;

    Importance(){
    }

    public static  Importance importance(int priorityLevel){
        Importance[] importance = Importance.values();
        return importance[priorityLevel];
    }
}

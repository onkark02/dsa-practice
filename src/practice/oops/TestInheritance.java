package practice.oops;

class SimpleEngine{
    public int power;
    public int factor;

    public SimpleEngine(int power){
        this.power = power;
        this.factor = 2;
    }

    public int getTotalForce(){
        return power * factor;
    }
}

class ForcedEngine extends SimpleEngine{
    private int factor;
    public ForcedEngine(int power){
        super(power);
        this.factor = 3;
    }

    @Override
    public int getTotalForce(){
        int simpleForce = super.getTotalForce();
        int forcedForce = this.power * this.factor;
        return simpleForce + forcedForce;
    }
}
public class TestInheritance {
    public static void main(String[] args) {
        ForcedEngine forcedEngine = new ForcedEngine(5);
        System.out.println(forcedEngine.getTotalForce());
    }
}

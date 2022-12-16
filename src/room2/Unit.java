package room2;

public abstract class Unit {
    protected int hp = 0;
    protected String name;

    public Unit(String name) {
        this.name = name;
    }

    void getDamage(int value) {
        this.hp -= value;
    }

    public void setName(String name) {
        this.name = name;
    }

    void status() {
        System.out.println("---------");
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.name);
        System.out.println(this.hp);
        System.out.println("---------");
    }

    boolean isAlive(){
        return hp > 0;
    }
}

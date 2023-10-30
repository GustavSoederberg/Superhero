public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private boolean isHuman;
    private int strength;

    public Superhero(String name, String realName, String superPower, int yearCreated, boolean isHuman, int strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Superhero [" +
                "Name: " + name +
                ", Real name: " + realName +
                ", Superpower: " + superPower +
                ", Year created: " + yearCreated +
                ", Is human: " + isHuman +
                ", Strength: " + strength + "]";
    }
}

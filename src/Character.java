public class Character {

    public String name;
    public String species;
    public int health = 100;
    final int MAXHEALTH = 100;

    public int intelligence;
    public int wisdom;
    public int charm;
    public int strength;
    public int perception;
    public int luck;

    public String characterClass;

    public Character() {}

    public Character(String name, String species, int intelligence, int wisdom, int charm, int strength,
                     int perception, int luck, String charClass) {
        this.name = name;
        this.species = species;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charm = charm;
        this.strength = strength;
        this.perception = perception;
        this.luck = luck;
        this.characterClass = charClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setAllStats(int intelligence, int wisdom, int charm, int strength,
                            int perception, int luck) {
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charm = charm;
        this.strength = strength;
        this.perception = perception;
        this.luck = luck;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
}

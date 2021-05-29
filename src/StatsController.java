public class StatsController {

    int intelligence;
    int wisdom;
    int charm;
    int strength;
    int perception;
    int luck;

    public StatsController() {}

    public StatsController(int intelligence, int wisdom, int charm, int strength, int perception, int luck) {
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charm = charm;
        this.strength = strength;
        this.perception = perception;
        this.luck = luck;
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

    public void adjustSpeciesStats(String species) {
        if (species.equalsIgnoreCase("human")) { //human stats: +1 strength, +2 luck, +1 intell
            this.strength = this.strength + 1;
            this.intelligence = this.intelligence + 1;
            this.luck = this.luck + 2;
        } else if(species.equalsIgnoreCase("elf")) { //elf stats: +1 strength, +2 wisdom, +3 charm
            this.strength = this.strength + 1;
            this.wisdom = this.wisdom + 2;
            this.charm = this.charm + 3;
        } else if(species.equalsIgnoreCase("dwarf")) { //dwarf stats: +3 strength, +1 intell, -1 wisdom
            this.strength = this.strength + 3;
            this.intelligence = this.intelligence + 1;
            this.wisdom = this.wisdom - 1;
        } else if(species.equalsIgnoreCase("nymph")) { //nymph stats: +1 wisdom, +2 charm, +3 perception
            this.wisdom = this.wisdom + 1;
            this.charm = this.charm + 2;
            this.perception = this.perception + 3;
        }
    }
}

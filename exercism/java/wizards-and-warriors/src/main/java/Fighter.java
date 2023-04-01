abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Fighter is a %s", this.getClass().getSimpleName());
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    int damagePoints(Fighter wizard) {
        if(wizard.isVulnerable()){
            return 10;
        }else{
            return 6;
        }
    }
}

class Wizard extends Fighter {

    private boolean spellPrepared = false;
    @Override
    boolean isVulnerable() {
        return !this.spellPrepared;
    }

    @Override
    int damagePoints(Fighter warrior) {
        if(this.spellPrepared){
            return 12;
        }
        else{
            return 3;
        }
    }

    void prepareSpell() {
        if(!spellPrepared){
            this.spellPrepared = true;
        }
    }

}

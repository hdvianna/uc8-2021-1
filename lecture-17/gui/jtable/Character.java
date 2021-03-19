package gui.jtable;

public class Character {
    private String name;
    private String actor;
    private String in;

    public Character(String name, String actor, String in) {
        this.name = name;
        this.actor = actor;
        this.in = in;
    }

    public String getName() {
        return name;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public String getActor() {
        return actor;
    }

    public Character setActor(String actor) {
        this.actor = actor;
        return this;
    }

    public String getIn() {
        return in;
    }

    public Character setIn(String in) {
        this.in = in;
        return this;
    }
}

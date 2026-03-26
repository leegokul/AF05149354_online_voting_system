public class Voter {
    private int id;
    private String name;
    private boolean voted;

    public Voter() {}
    public Voter(int id, String name, boolean voted) {
        this.id = id;
        this.name = name;
        this.voted = voted;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isVoted() { return voted; }
    public void setVoted(boolean voted) { this.voted = voted; }
}
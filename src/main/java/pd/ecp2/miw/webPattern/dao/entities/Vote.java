package pd.ecp2.miw.webPattern.dao.entities;
public class Vote {

    private int id;

    private double vote;

    private Theme theme;

    public Vote() {
    }

    public Vote(int id, double vote, Theme theme) {
        this.id = id;
        this.vote = vote;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public double getVote() {
        return vote;
    }

    public Theme getTheme() {
        return theme;
    }

}

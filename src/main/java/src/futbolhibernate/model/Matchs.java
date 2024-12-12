package src.futbolhibernate.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Matchs {

    @Id
    @GeneratedValue
    private int id_match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division", referencedColumnName = "division")
    private Divisions divisions;

    @Column(name = "match_date")
    private Date match_date;

    @Column(name = "homeTeam")
    private String homeTeam;

    @Column(name = "awayTeam")
    private String awayTeam;

    @Column(name = "FTHG")
    private double FTHG;

    @Column(name = "FTAG")
    private double FTAG;

    @Column(name = "FRT")
    private String FRT;

    @Column(name = "season")
    private int season;

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public Divisions getDivision() {
        return divisions;
    }

    public void setDivision(Divisions divisions) {
        this.divisions = divisions;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public double getFTHG() {
        return FTHG;
    }

    public void setFTHG(double FTHG) {
        this.FTHG = FTHG;
    }

    public double getFTAG() {
        return FTAG;
    }

    public void setFTAG(double FTAG) {
        this.FTAG = FTAG;
    }

    public String getFRT() {
        return FRT;
    }

    public void setFRT(String FRT) {
        this.FRT = FRT;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

//    public String toString() {
//        return id_match + " || " + division + " || " + match_date + " || " + homeTeam + " || " + awayTeam + " || " + FTAG + " || " + FTHG + " || " + FRT + " || " + season;
//    }


    @Override
    public String toString() {
        return "Match{" +
                "id_match=" + id_match +
                ", division=" + divisions +
                ", match_date=" + match_date +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", FTHG=" + FTHG +
                ", FTAG=" + FTAG +
                ", FRT='" + FRT + '\'' +
                ", season=" + season +
                '}';
    }
}

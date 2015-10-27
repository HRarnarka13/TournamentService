package is.rufan.tournament.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class Tournament {

    private int tournamentid;
    private String name;
    private Date startTime;
    private Date endTime;
    private boolean status;
    private double entryFee;
    private int maxEntries;
    private List<Integer> tournamentGames;
    private List<TournamentEnrollment>enrollments;

    public Tournament() {
    }

    public Tournament(int tournamentid, String name, Date startTime, Date endTime, boolean status, double entryFee, int maxEntries, List<Integer> tournamentGames, List<TournamentEnrollment> enrollments) {
        this.tournamentid = tournamentid;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.entryFee = entryFee;
        this.maxEntries = maxEntries;
        this.tournamentGames = tournamentGames;
        this.enrollments = enrollments;
    }

    public Tournament(String name, Date startTime, Date endTime, boolean status, double entryFee, int maxEntries, List<Integer> tournamentGames, List<TournamentEnrollment> enrollments) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.entryFee = entryFee;
        this.maxEntries = maxEntries;
        this.tournamentGames = tournamentGames;
        this.enrollments = enrollments;
    }

    // region getters setters
    public int getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(int tournamentid) {
        this.tournamentid = tournamentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public int getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public List<Integer> getTournamentGames() {
        return tournamentGames;
    }

    public void setTournamentGames(List<Integer> tournamentGames) {
        this.tournamentGames = tournamentGames;
    }

    public List<TournamentEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<TournamentEnrollment> enrollments) {
        this.enrollments = enrollments;
    }


    // endregion
}

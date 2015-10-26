package is.rufan.tournament.domain;

import com.sun.tools.corba.se.idl.StringGen;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class Tournament {

    private int tournamentid;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // endregion
}

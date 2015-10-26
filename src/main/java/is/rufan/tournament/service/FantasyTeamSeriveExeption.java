package is.rufan.tournament.service;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class FantasyTeamSeriveExeption extends RuntimeException {

    public FantasyTeamSeriveExeption() {
    }

    public FantasyTeamSeriveExeption(String message) {
        super(message);
    }

    public FantasyTeamSeriveExeption(String message, Throwable cause) {
        super(message, cause);
    }
}

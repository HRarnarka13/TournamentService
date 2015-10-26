package is.rufan.tournament.service;

/**
 * Created by arnarkari on 26/10/15.
 *
 * @author arnarkari
 */
public class TournamentServiceException extends RuntimeException {

    public TournamentServiceException() {
    }

    public TournamentServiceException(String message) {
        super(message);
    }

    public TournamentServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
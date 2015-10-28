package is.rufan.tournament.process;

import is.rufan.tournament.domain.FantasyPoint;
import is.ruframework.reader.RuAbstractReader;
import is.ruframework.reader.RuJsonUtil;
import is.ruframework.reader.RuReaderException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnarkari on 25/10/15.
 *
 * @author arnarkari
 */
public class FantasyPointReader extends RuAbstractReader {

    public Object parse(String content) throws RuReaderException {

        // Root array
        JSONArray jsonArray = (JSONArray) JSONValue.parse(content);
        JSONObject fantasyData;

        List<FantasyPoint> fantasyPoints = new ArrayList<FantasyPoint>();
        for (int i = 0; i < jsonArray.size(); i++) {
            FantasyPoint fantasyPoint = new FantasyPoint();
            fantasyData = (JSONObject) jsonArray.get(i);

            int playerid = RuJsonUtil.getInt(fantasyData, "PlayerId");

            String string_points = fantasyData.get("FantasyPoints").toString();
            double points = Double.parseDouble(string_points);

            fantasyPoint.setPlayerId(playerid);
            fantasyPoint.setFantasyPoints(points);
            fantasyPoints.add(fantasyPoint);
            readHandler.read(i, fantasyPoint);
        }
        return fantasyPoints;
    }
}




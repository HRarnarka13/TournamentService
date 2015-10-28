package is.rufan.tournament.process;


import is.rufan.tournament.domain.FantasyPoint;
import is.rufan.tournament.service.FantasyPoint.FantasyPointException;
import is.rufan.tournament.service.FantasyPoint.FantasyPointService;
import is.ruframework.process.RuAbstractProcess;
import is.ruframework.reader.RuReadHandler;
import is.ruframework.reader.RuReader;
import is.ruframework.reader.RuReaderException;
import is.ruframework.reader.RuReaderFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by eysteinn on 25/10/15.
 */
public class FantasyPointImportProcess extends RuAbstractProcess implements RuReadHandler {
    private FantasyPointService fantasyPointService;
    MessageSource msg;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void beforeProcess()
    {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:playerapp.xml");
        fantasyPointService = (FantasyPointService) applicationContext.getBean("fantasyPointService");
        msg = (MessageSource) applicationContext.getBean("messageSource");
        logger.info("processbefore: " + getProcessContext().getProcessName());
    }
    @Override
    public void startProcess()
    {
        RuReaderFactory factory = new RuReaderFactory("fantasypointprocess.xml");
        RuReader reader = factory.getReader("fantasyPointReader");

        reader.setReadHandler(this);
        try
        {
            reader.read();
        }
        catch (RuReaderException e)
        {
            String errorMsg = "Unable to read specified file.";
            logger.severe(errorMsg);
        }
    }


    public void read(int count, Object object)
    {
        FantasyPoint fantasyPoint = (FantasyPoint) object;
        try
        {
              fantasyPointService.addFantasyPoint(fantasyPoint);
        }
        catch (FantasyPointException se)
        {
            logger.warning("Fantasy point id " + fantasyPoint.getFantasyPointId() + " not added " + se.getMessage());
        }
    }
}

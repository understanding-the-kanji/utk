package util;

import util.connector.DBConnector;

public class Scheduler {

    private DBConnector databaseConnection;
    private Logger logger;

    public Scheduler(Logger m_logger)
    {
        this.logger = m_logger;
    }
}

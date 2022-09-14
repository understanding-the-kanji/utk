package net.samuelcmace.demo.util;

import net.samuelcmace.demo.util.connector.DBConnector;

public class Scheduler {

    private DBConnector databaseConnection;
    private Logger logger;

    public Scheduler(Logger m_logger)
    {
        this.logger = m_logger;
    }
}

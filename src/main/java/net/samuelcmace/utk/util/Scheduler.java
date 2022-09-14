package net.samuelcmace.utk.util;

import net.samuelcmace.utk.util.connector.DBConnector;

public class Scheduler {

    private DBConnector databaseConnection;
    private Logger logger;

    public Scheduler(Logger m_logger)
    {
        this.logger = m_logger;
    }
}

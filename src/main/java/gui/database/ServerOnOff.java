package gui.database;

import org.hsqldb.server.Server;

public class ServerOnOff {
    private Server hsqlServer = null;

    public void serverInit() {
        hsqlServer = new Server();
        hsqlServer.setLogWriter(null);
        hsqlServer.setSilent(true);
        hsqlServer.setDatabaseName(0, "sportyRFDB");
        hsqlServer.setDatabasePath(0, "file:storage");

        hsqlServer.start();
    }

    public void serverClose() {
        hsqlServer.stop();
        hsqlServer = null;
    }
}

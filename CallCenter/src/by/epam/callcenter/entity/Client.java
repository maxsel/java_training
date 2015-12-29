package by.epam.callcenter.entity;

import by.epam.callcenter.exception.ServiceUnavailableException;
import org.apache.log4j.Logger;

/**
 * Created by maxsel on 06.12.15.
 */
public class Client extends Thread {
    public final static Logger LOG = Logger.getLogger(Client.class);
    private final static int WAIT_TIME = 1700;

    private int clientId;
    private CallCenter callCenter;
    private int attemptsMade;
    private boolean wasServed;

    public Client(CallCenter callCenter, int id) {
        super("Client #" + id);
        this.callCenter = callCenter;
        this.clientId = id;
        LOG.debug(this + " created");
    }

    public void run() {
        Operator operator = null;
        try {
            // each client will eventually be served
            while (!wasServed) {
                operator = tryCall();
            }
        } catch (ServiceUnavailableException e) {
            LOG.error("Service unavailable! "
                    + this + " failed to connect Call Center!");
        } finally {
            if (operator != null) {
                LOG.info(this + " released " + operator);
                try {
                    callCenter.returnOperator(operator);
                } catch (ServiceUnavailableException e) {
                    LOG.error("Service unavailable! " + this
                            + " failed to connect Call Center!");
                }
            }
        }
    }

    public int getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "Client #" + getClientId();
    }

    private Operator tryCall() throws ServiceUnavailableException {
        ++attemptsMade;

        LOG.debug(this + " tries to get operator");

        // wait for a client until WAIT_TIME exceeds
        Operator operator = callCenter.getOperator(WAIT_TIME);

        if (operator != null) {
            LOG.info(this + " took " + operator
                    + " at " + attemptsMade + " attempt");

            operator.serveClient();
            wasServed = true;
        } else {
            LOG.info(this + " made " + attemptsMade + " call attempt");
        }
        return operator;
    }
}

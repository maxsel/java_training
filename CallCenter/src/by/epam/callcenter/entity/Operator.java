package by.epam.callcenter.entity;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by maxsel on 06.12.15.
 */
public class Operator {
    public static final Logger LOG = Logger.getLogger(Operator.class);
    private static final int MAX_SERVE_TIME = 1000;
    private static final int MIN_SERVE_TIME = 100;
    private static Random random = new Random();
    private int operatorId;

    public Operator(int id) {
        super();
        this.operatorId = id;
        LOG.debug(this + " created");
    }

    public int getOperatorId() {
        return operatorId;
    }

    @Override
    public String toString() {
        return "Operator #" + getOperatorId();
    }

    public void serveClient() {
        try {
            // imitation of serving client
            Thread.sleep(MIN_SERVE_TIME + random.nextInt(MAX_SERVE_TIME));
        } catch (InterruptedException e) {
            LOG.error("Oh, woe!" + this + " died when serving a client...");
        }
    }
}

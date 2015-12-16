package by.epam.callcenter.entity;

import by.epam.callcenter.exception.ServiceUnavailableException;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by maxsel on 06.12.15.
 */
public class CallCenter extends Thread {
    public static final Logger LOG = Logger.getLogger(CallCenter.class);
    public static final int NUM_OPERATORS = 5;
    private static CallCenter instance;
    private static volatile boolean instanceCreated;
    private static ReentrantLock creationLock = new ReentrantLock(true);

    private int numAvailable;
    private Queue<Operator> operators = new ArrayDeque<>();
    private ReentrantLock accessLock = new ReentrantLock(true);
    private Condition notFull = accessLock.newCondition();
    private Condition notEmpty = accessLock.newCondition();

    private CallCenter() {
        super("CallCenter");
        numAvailable = NUM_OPERATORS;
        for (int i = 0; i < NUM_OPERATORS; i++) {
            operators.add(new Operator(i+1));
        }

        LOG.info("Call center with " + NUM_OPERATORS
                + " operators created. Available left: " + numAvailable);
    }

    public static CallCenter getInstance() {
        if (!instanceCreated) {
            creationLock.lock();
            try {
                if (!instanceCreated) {
                    instance = new CallCenter();
                    instanceCreated = true;
                }
            } finally {
                creationLock.unlock();
            }
        }
        return instance;
    }

    public Operator getOperator(long maxWaitMillis)
            throws ServiceUnavailableException {
        LOG.debug("Attempt of getting operator. Available left: "
                + numAvailable);
        try {
            if (accessLock.tryLock(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                if (numAvailable <= 0) {
                    if (!notEmpty.await(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                        return null;    // unsuccessfull wait
                    }
                }

                Operator res = operators.remove();
                --numAvailable;
                LOG.info(res + " polled. Available left: " + numAvailable);
                notFull.signal();
                return res;
            } else {
                return null;    // unsuccessfull wait
            }
        } catch (NoSuchElementException e) {
            LOG.error("Threading error! Lock failed to function! " + e);
            return null;
        } catch (InterruptedException e) {
            throw new ServiceUnavailableException(e);
        } finally {
            accessLock.unlock();
        }
    }

    public void returnOperator(Operator operator)
            throws ServiceUnavailableException {
        accessLock.lock();
        try {
            while (numAvailable >= NUM_OPERATORS) {
                notFull.await();
            }
            operators.add(operator);
            ++numAvailable;
            LOG.info(operator + " released. Available left: " + numAvailable);
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new ServiceUnavailableException(e);
        }
        finally {
            accessLock.unlock();
        }
    }
}

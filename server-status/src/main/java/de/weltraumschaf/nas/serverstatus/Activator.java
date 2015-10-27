package de.weltraumschaf.nas.serverstatus;

import de.weltraumschaf.nas.serverstatus.api.ServerStatus;
import de.weltraumschaf.nas.serverstatus.impl.ServerStatusImpl;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Activates the bundle.
 * <p>
 * Provides services of:
 * </p>
 * <ul>
 * <li>{@link ServerStatus}</li>
 * </ul>
 */
public final class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());
    private static final String SERVICE_NAME = ServerStatus.class.getName();

    private ServiceRegistration serverStatus;

    @Override
    public void start(final BundleContext context) throws Exception {
        LOG.info(String.format("Starting bundle: %s...", SERVICE_NAME));
        serverStatus = context.registerService(SERVICE_NAME, new ServerStatusImpl(), null);
        LOG.info(String.format("Bundle %s started.", SERVICE_NAME));
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        LOG.info(String.format("Stopping bundle: %s...", SERVICE_NAME));
        serverStatus.unregister();
        LOG.info(String.format("Bundle %s stopped.", SERVICE_NAME));
    }

}

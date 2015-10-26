package de.weltraumschaf.nas.server.status;

import de.weltraumschaf.nas.server.status.api.ServerStatus;
import de.weltraumschaf.nas.server.status.impl.ServerStatusImpl;
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

    private ServiceRegistration serverStatus;

    @Override
    public void start(final BundleContext context) throws Exception {
        serverStatus = context.registerService(ServerStatus.class.getName(), new ServerStatusImpl(), null);
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        serverStatus.unregister();
    }

}

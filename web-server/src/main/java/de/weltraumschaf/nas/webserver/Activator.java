package de.weltraumschaf.nas.webserver;

import de.weltraumschaf.nas.webserver.api.WebServer;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
//import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(Activator.class.getName());
    private static final String SERVICE_NAME = WebServer.class.getName();
//    private ServiceReference serverStatusReference;

    @Override
    public void start(final BundleContext context) throws Exception {
        LOG.info(String.format("Starting bundle: %s...", SERVICE_NAME));
//        serverStatusReference = context.getServiceReference(ServerStatus.class().getName());
//        final ServerStatus statusApi = (ServerStatus)context.getService(serverStatusReference);
        LOG.info(String.format("Bundle %s started.", SERVICE_NAME));
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        LOG.info(String.format("Stopping bundle: %s...", SERVICE_NAME));
//        context.ungetService(serverStatusReference);
        LOG.info(String.format("Bundle %s stopped.", SERVICE_NAME));
    }

}

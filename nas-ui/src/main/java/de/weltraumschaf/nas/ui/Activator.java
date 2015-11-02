package de.weltraumschaf.nas.ui;

import java.util.Dictionary;
import java.util.Hashtable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;

/**
 */
public final class Activator implements BundleActivator {
    private static final Logger LOG = LoggerFactory.getLogger(Activator.class.getName());

    @Override
    public void start(final BundleContext context) throws Exception {
        LOG.info("Start NAS UI...");
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, Configuration.PID);
        context.registerService(ManagedService.class.getName(), new ConfigurationUpdater(), properties);
        LOG.info("Started NAS UI.");
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        LOG.info("Stop NAS UI...");
        LOG.info("Stopped NAS UI.");
    }

}

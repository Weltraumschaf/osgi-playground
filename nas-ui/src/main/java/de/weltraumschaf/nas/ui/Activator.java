package de.weltraumschaf.nas.ui;

import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;

/**
 */
public final class Activator implements BundleActivator {

    @Override
    public void start(final BundleContext context) throws Exception {
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, Configuration.PID);
        context.registerService(ManagedService.class.getName(), new ConfigurationUpdater(), properties);
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
    }

}

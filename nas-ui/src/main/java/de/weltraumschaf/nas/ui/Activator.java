package de.weltraumschaf.nas.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Servlet;
import javax.ws.rs.core.Application;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 */
public final class Activator implements BundleActivator {

    private static final Logger LOG = LoggerFactory.getLogger(Activator.class.getName());

    private ServiceTracker tracker;

    @Override
    public void start(final BundleContext context) throws Exception {
        LOG.info("Start NAS UI...");
        registerConfig(context);

        //Track all JAX-RS Applications
        tracker = new ServiceTracker(context, Application.class.getName(), new Customizer(context));
        tracker.open();

        LOG.info("Started NAS UI.");
    }

    private void registerConfig(final BundleContext context) {
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, Configuration.PID);
        context.registerService(ManagedService.class.getName(), new ConfigurationUpdater(), properties);
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        LOG.info("Stop NAS UI...");
        tracker.close();
        tracker = null;
        LOG.info("Stopped NAS UI.");
    }
}

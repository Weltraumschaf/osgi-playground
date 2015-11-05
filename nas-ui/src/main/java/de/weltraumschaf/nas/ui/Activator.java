package de.weltraumschaf.nas.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.ws.rs.core.Application;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * This class is used to activate the bundle.
 * <p>
 * The activation is auto wired via the blueprint configuration in
 * {@literal src/main/resources/OSGI-INF/blueprint/context.xml}.
 * </p>
 */
public final class Activator {

    private static final Logger LOG = LoggerFactory.getLogger(Activator.class.getName());

    /**
     * Injected by OSGi container.
     */
    private BundleContext context;
    private ServiceTracker tracker;

    /**
     * Injection point for OSGI container.
     * <p>
     * The injection is auto wired via the blueprint {@literal context.xml}.
     * </p>
     *
     * @param context must not be {@code null}
     */
    public void setContext(final BundleContext context) {
        if (null == context) {
            throw new NullPointerException("Parameter 'context' must not be null!");
        }

        this.context = context;
    }

    /**
     * Called by OSGi container during bundle activation.
     * <p>
     * This method is called after {@link #setContext(org.osgi.framework.BundleContext) the context was injected}.
     * </p>
     *
     * @throws Exception if the bundle can't start.
     */
    public void start() throws Exception {
        LOG.info("#######################");
        LOG.info("### Starting NAS UI ###");
        LOG.info("#######################");
        registerConfigUpdater();
        trackAllJaxRsApplications();
        LOG.info("Started NAS UI.");
    }

    /**
     * Called by OSGi container during bundle deactivation.
     *
     * @throws Exception if bundle can't stop
     */
    public void stop() throws Exception {
        LOG.info("#######################");
        LOG.info("### Stopping NAS UI ###");
        LOG.info("#######################");
        tracker.close();
        tracker = null; // Free memory because activator may still be alive in container.
        LOG.info("Stopped NAS UI.");
    }

    /**
     * Registers a managed service to receive updates of the configuration file.
     */
    private void registerConfigUpdater() {
        LOG.info("Register configuration update for {}.", Configuration.PID);
        @SuppressWarnings("UseOfObsoleteCollectionType")
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, Configuration.PID);
        context.registerService(ManagedService.class.getName(), new ConfigurationUpdater(), properties);
    }

    private void trackAllJaxRsApplications() {
        LOG.info("Track JAX RS applications.");
        tracker = new ServiceTracker(context, Application.class.getName(), new JaxRsCustomizer(context));
        tracker.open();
    }

}

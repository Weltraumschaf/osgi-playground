package de.weltraumschaf.nas.integrationtests;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

import java.io.File;
import java.util.Collection;

import javax.inject.Inject;

import de.weltraumschaf.nas.api.TaskService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.osgi.framework.BundleContext;

@RunWith(PaxExam.class)
public class KarafTest {

    @Inject
    protected BundleContext bundleContext;

    @Inject
    protected TaskService taskService;

    public File getConfigFile(String path) {
        return new File(this.getClass().getResource(path).getFile());
    }

    @Configuration
    public Option[] config() {
        MavenArtifactUrlReference karafUrl = maven()
            .groupId("org.apache.karaf")
            .artifactId("apache-karaf")
            .version("3.0.0").type("tar.gz");
        MavenArtifactUrlReference tasklistRepo = maven()
            .groupId("de.weltraumschaf.nas")
            .artifactId("nas-features")
            .versionAsInProject()
            .type("xml");
        return new Option[]{
            karafDistributionConfiguration().frameworkUrl(karafUrl).name("Apache Karaf")
            .unpackDirectory(new File("target/exam")),
            keepRuntimeFolder(),
            features(tasklistRepo, "nas-service", "nas-ui")
        // KarafDistributionOption.debugConfiguration("5005", true),
        };
    }

    @Test
    public void test1() throws Exception {
        Collection<de.weltraumschaf.nas.api.Task> tasks = taskService.getTasks();
        Assert.assertEquals(2, tasks.size());
    }

}

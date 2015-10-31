package de.weltraumschaf.nas.serverstatus.api;

import java.util.Collection;

/**
 * Gives various status information about the server.
 */
public interface ServerStatus {

    Collection<Disk> disks();
    Collection<Pool> pools();
}

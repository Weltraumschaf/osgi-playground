package de.weltraumschaf.nas.serverstatus.api;

/**
 */
public interface Harddisk {

    String filesystem();
    String size();
    String used();
    String avail();
    String capacity();
    String mountedOn();
}

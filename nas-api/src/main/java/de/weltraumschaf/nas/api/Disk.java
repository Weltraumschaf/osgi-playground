package de.weltraumschaf.nas.api;

/**
 */
public interface Disk {

    String filesystem();
    String size();
    String used();
    String avail();
    String capacity();
    String mountedOn();
}

package de.weltraumschaf.nas.api;

/**
 */
public interface Pool {

    String name();
    String size();
    String alloc();
    String free();
    String frag();
    String expandsz();
    String cap();
    String dedup();
    String health();
}

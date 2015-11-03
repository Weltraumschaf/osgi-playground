#!/bin/bash

TARBALL="apache-karaf-3.0.5.tar.gz"
TARGET="apache-karaf-3.0.5"
SHORTHAND="karaf"

if [ -d "${TARGET}" ] ; then 
    rm -rfv "${TARGET}"
fi

if [ -e "${SHORTHAND}" ] ; then
    rm -v "${SHORTHAND}"
fi

tar xjvf "${TARBALL}"
ln -s "${TARGET}" "${SHORTHAND}"

cd "${SHORTHAND}/etc"
ln -s "../../etc/de.weltraumschaf.nas.ui.cfg"
rm -v org.ops4j.pax.logging.cfg
ln -s "../../etc/org.ops4j.pax.logging.cfg"
cd -
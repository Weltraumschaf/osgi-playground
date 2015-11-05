#!/bin/bash

TARGET="apache-karaf-3.0.5"
#TARGET="apache-karaf-4.0.2"
TARBALL="${TARGET}.tar.gz"
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
rm -v org.ops4j.pax.logging.cfg
ln -s "../../etc/org.ops4j.pax.logging.cfg"
cd -
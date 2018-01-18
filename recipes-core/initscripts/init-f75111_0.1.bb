DESCRIPTION = "f75111 dio Initialization"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://init-f75111"

inherit update-rc.d

INITSCRIPT_NAME = "init-f75111"
INITSCRIPT_PARAMS = "start 32 2 3 4 5 . stop 32 0 1 6 ."

do_install() {
       install -d ${D}${sysconfdir}/init.d
       install -m 0755 ${WORKDIR}/init-f75111 ${D}${sysconfdir}/init.d/init-f75111
}

FILES_${PN} = "${sysconfdir}/init.d/init-f75111" 

COMPATIBLE_MACHINE = "aaeonc"


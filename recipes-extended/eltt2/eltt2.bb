SUMMARY = "Infineon Embedded Linux TPM Toolbox 2 for TPM 2.0"
DESCRIPTION = "This recipe adds Embedded Linux TPM Toolbox 2 (ELTT2). ELTT2 is a single-file executable program intended for testing, performing diagnosis and basic state changes of the Infineon Technologies TPM 2.0."
SECTION = "console/utils"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://License.txt;md5=1e492cfcb05c60002d4bee800bd9c296"

SRC_URI = "file://License.txt \
           file://Makefile \
           file://README.md \
           file://README.txt \
           file://eltt2.c \
           file://eltt2.h"

S = "${WORKDIR}"

do_compile() {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 755 eltt2 ${D}${bindir}
}

FILES_${PN} = "${bindir}/eltt2"

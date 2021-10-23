DESCRIPTION = "IOHK libsodium"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c08ca8cc1736a57429bd464c9ba6eab6"

SRC_URI = "git://github.com/input-output-hk/libsodium.git;protocol=https;nobranch=1"

PV = "1.0+git${SRCPV}"
SRCREV = "66f017f16633f2060db25e17c170c2afa0f2a8a1"

S = "${WORKDIR}/git"

inherit autotools

DISABLE_STATIC = ""
EXTRA_OECONF = " --disable-shared --enable-static"


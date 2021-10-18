DESCRIPTION = "A traceroute implementation using TCP packets"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = " \
	git://github.com/mct/tcptraceroute.git;protocol=https;nobranch=1 \
	file://0001-support-cross-compilation.patch \
"

PV = "1.5beta7"
SRCREV = "1ec970e899245bf3b511856bfe3e514760edde0c"

S = "${WORKDIR}/git"

inherit autotools

DEPENDS = "libnet libpcap"

DISABLE_STATIC = ""
EXTRA_OECONF = ""


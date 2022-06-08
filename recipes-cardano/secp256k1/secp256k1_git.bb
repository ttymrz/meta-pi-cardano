DESCRIPTION = "Optimized C library for ECDSA signatures and secret/public key operations on curve secp256k1."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=67330c75f8bf6a92f6f8a36ae669ba74"

SRC_URI = "git://github.com/bitcoin-core/secp256k1;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "ac83be33d0956faf6b7f61a60ab524ef7d6a473a"

S = "${WORKDIR}/git"

inherit autotools

DISABLE_STATIC = ""
EXTRA_OECONF = "--enable-module-schnorrsig --enable-experimental"


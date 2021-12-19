DESCRIPTION = "cardano-node binary from armada-alliance"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://github.com/armada-alliance/cardano-node-binaries/raw/main/dynamic-binaries/1.32.1/cardano-1_32_1-aarch64-ubuntu_2004.zip"
SRC_URI[sha256sum] = "13199cf3a1ce5f0b6ef81297af10763a4ca4412e76fcf7c10b54fcdc4772b721"

S = "${WORKDIR}/cardano-1_32_1-aarch64-ubuntu_2004"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

DEPENDS = "libsodium-iohk numactl systemd zlib"

do_install () {
	install -d ${D}/opt/cardano/bin
	install -m 0755 ${S}/cardano-node ${D}/opt/cardano/bin/
	install -m 0755 ${S}/cardano-cli ${D}/opt/cardano/bin/
}

FILES_${PN} = "/opt/cardano/bin/*"

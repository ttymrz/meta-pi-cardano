DESCRIPTION = "cardano-node binary from armada-alliance"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://github.com/armada-alliance/cardano-node-binaries/raw/main/static-binaries/1_35_3.zip"
SRC_URI[sha256sum] = "cb1362f4d9a2e5d00b0397402f27fac0ab335f3c063009c25ab493692d7b0d62"

S = "${WORKDIR}/cardano-node"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/opt/cardano/bin
	install -m 0755 ${S}/cardano-node ${D}/opt/cardano/bin/
	install -m 0755 ${S}/cardano-cli ${D}/opt/cardano/bin/
}

FILES_${PN} = "/opt/cardano/bin/*"

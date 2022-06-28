DESCRIPTION = "cardano-node binary from armada-alliance"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://github.com/armada-alliance/cardano-node-binaries/raw/main/static-binaries/1_35_0.zip"
SRC_URI[sha256sum] = "1be9136c25cd8c1d2e330dd31912886f942664a90cb848012b13c57fb344faef"

S = "${WORKDIR}/cardano-node"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/opt/cardano/bin
	install -m 0755 ${S}/cardano-node ${D}/opt/cardano/bin/
	install -m 0755 ${S}/cardano-cli ${D}/opt/cardano/bin/
}

FILES_${PN} = "/opt/cardano/bin/*"

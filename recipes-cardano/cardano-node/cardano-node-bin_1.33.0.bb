DESCRIPTION = "cardano-node binary from armada-alliance"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://github.com/armada-alliance/cardano-node-binaries/raw/main/static-binaries/1_33_0.zip"
SRC_URI[sha256sum] = "baf736dcaee942b83f2c6b7841ce7f0758353b9eec34c4f5167f42f4f077b405"

S = "${WORKDIR}/cardano-node"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/opt/cardano/bin
	install -m 0755 ${S}/cardano-node ${D}/opt/cardano/bin/
	install -m 0755 ${S}/cardano-cli ${D}/opt/cardano/bin/
}

FILES_${PN} = "/opt/cardano/bin/*"

DESCRIPTION = "A community-based cardano-node CLI tool."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://contrib/libsodium/LICENSE;md5=c08ca8cc1736a57429bd464c9ba6eab6"

inherit cargo

SRC_URI = "gitsm://github.com/AndrewWestberg/cncli.git;protocol=https;branch=develop"

PV = "4.0.4+git${SRCPV}"
SRCREV = "91e61b241d92d30e5ebba1acbe395a4be5186254"

S = "${WORKDIR}/git"

DEPENDS = " \
	openssl \
	libsodium-iohk \
"

CARGO_FEATURES = "libsodium-sys"
CARGO_INSTALL_DIR = "${D}/opt/cardano/bin"

FILES_${PN} = "/opt/cardano/bin/*"

# fix CC for cross compiling gmp-mpfr-sys
do_compile() {
	export TARGET_CC="${WRAPPER_DIR}/cc-wrapper.sh"
	export TARGET_CXX="${WRAPPER_DIR}/cxx-wrapper.sh"
	#export CC="${WRAPPER_DIR}/cc-native-wrapper.sh"
	#export CXX="${WRAPPER_DIR}/cxx-native-wrapper.sh"
	export TARGET_LD="${WRAPPER_DIR}/ld-wrapper.sh"
	export LD="${WRAPPER_DIR}/ld-native-wrapper.sh"
	export PKG_CONFIG_ALLOW_CROSS="1"
	export LDFLAGS=""
	export RUSTFLAGS="${RUSTFLAGS}"
	bbnote "which rustc:" `which rustc`
	bbnote "rustc --version" `rustc --version`
	bbnote "which cargo:" `which cargo`
	bbnote "cargo --version" `cargo --version`
	bbnote cargo build ${CARGO_BUILD_FLAGS}
	cargo build ${CARGO_BUILD_FLAGS}
}

# delete unused rlib
do_install_append() {
	rm -fr ${D}/${libdir}
}


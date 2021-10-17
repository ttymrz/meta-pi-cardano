# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " \
	bash \
	bash-completion \
	bc \
	cardano-node-bin \
	coreutils \
	cncli \
	curl \
	dialog \
	e2fsprogs \
	ethtool \
	gnupg \
	htop \
	iproute2 \
	jq \
	less \
	lsof \
	ncurses \
	ncurses-tools \
	procps \
	rng-tools \
	sudo \
	tmux \
	tzdata \
	usbutils \
	vim \
"

IMAGE_LINGUAS = "en-us en-gb"

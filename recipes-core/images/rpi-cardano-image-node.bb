# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " \
	bash \
	bash-completion \
	bc \
	cardano-node-bin \
	cncli \
	curl \
	ethtool \
	htop \
	iproute2 \
	jq \
	less \
	lsof \
	ncurses \
	ncurses-tools \
	rng-tools \
	tmux \
	usbutils \
	vim \
"

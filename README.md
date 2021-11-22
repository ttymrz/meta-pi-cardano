# meta-pi-cardano

Yocto layer for the Cardano on the Raspberry Pi

## Dependencies

This layer depends on:

* URI: git://git.yoctoproject.org/poky
  * branch: hardknott
  * tag: hardknott-3.3.4

* URI: git://git.openembedded.org/meta-openembedded
  * layers: meta-oe, meta-multimedia, meta-networking, meta-python
  * branch: hardknott
  * revision: HEAD

* URI: https://github.com/agherzan/meta-raspberrypi.git
  * branch: hardknott
  * revision: HEAD

* URI: https://github.com/rust-embedded/meta-rust-bin.git
  * branch: master
  * revision: HEAD

## Quick Start

### Directory Structure

```
layers
├── meta-openembedded
├── meta-pi-cardano
├── meta-raspberrypi
├── meta-rust-bin
└── poky
```

### Setup

```console
$ export TEMPLATECONF=<path>/layers/meta-pi-cardano/conf
$ source <path>/layers/poky/oe-init-build-env
```

### Build

```console
$ bitbake rpi-cardano-image-node
```

### SD card

Replace `sdx` with your SD card block device. 

```console
$ cp ./tmp/deploy/images/raspberrypi4-64/rpi-stakepool-image-node-raspberrypi4-64.wic.* ./
$ sudo bmaptool copy rpi-stakepool-image-node-raspberrypi4-64.wic.bz2 /dev/<sdx>
```

### Boot and Run

1. Connect Raspberry Pi UART1 to your PC.
2. Boot Raspberry Pi and login as root.

```console
root@raspberrypi4-64:~# /opt/cardano/bin/cardano-node --version
root@raspberrypi4-64:~# /opt/cardano/bin/cardano-cli --version
root@raspberrypi4-64:~# /opt/cardano/bin/cncli --version
```

## cardano-node and cardano-cli binary

This layer uses pre-built binaries built by [Armada Alliance][Armada], because `cardano-node` and `cardano-cli` cannot be cross-compiled. 

[Armada]:https://github.com/armada-alliance

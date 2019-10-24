Yocto BSP meta layer for AAEON Community boards
===============================================

This README file contains information on building the meta-aaeonc BSP
layer. Please see the corresponding sections below for details.

For more information on these boards, see:
http://www.aaeon.com/en/c/pico-itx-boards

Table of Contents
=================

1. Prerequisites
2. Building the meta-aaeonc BSP layer
3. Booting the live USB image
4. Additional Resources

Prerequisites
=============

Supported Yocto versions
------------------------
* Yocto 2.5 (Sumo)

Supported Hardware
------------------
* AAEON PICO-APL1
* AAEON PICO-APL3

Building the meta-aaeonc BSP layer
==================================

Download the latest Sumo release and enter the poky directory:
```
git clone -b sumo git://git.yoctoproject.org/poky.git
cd poky
```

Download the latest Intel BSP layer version for Sumo:
```
git clone -b sumo git://git.yoctoproject.org/meta-intel.git
```

Download the latest collection of layers for OE-core universe for Sumo:
```
git clone -b sumo git://git.openembedded.org/meta-openembedded
```

Download this AAEON Community BSP layer for Sumo:
```
git clone -b sumo https://github.com/emutex/meta-aaeonc
```

From the poky directory, you can build an image as such:
```
TEMPLATECONF=meta-aaeonc/conf source oe-init-build-env
bitbake aaeonc-image-sato
```

At the end of a successful build, you should have a live image that you
can boot from a USB flash drive (see instructions on how to do that
below).

Booting the live USB image
==========================

This BSP creates bootable live images, which can be used to directly
boot Yocto off of a USB flash drive. Upon completion of a successful
build, described in the previous section, the images are created in a
sub-folder named `./tmp/deploy/images/aaeonc/`.

Under Linux, insert a USB flash drive. Assuming the USB flash drive
takes device `/dev/sdf`, use `dd` to copy the live image to it:

```
dd if=core-image-sato-aaeonc.hddimg of=/dev/sdf
sync
eject /dev/sdf
```

This should give you a bootable USB flash device. Insert the device into
a bootable USB socket on the target, and power on. At the initial BIOS
splash screen, press F7 to display a menu of boot options and select the
USB device. This should result in a system booted to the Sato graphical
desktop.

If you want a terminal, use the arrows at the top of the UI to move to
different pages of available applications, one of which is named
'Terminal'. Clicking that should give you a root terminal.

If you want to ssh into the system, you can use the root terminal to
ifconfig the IP address and use that to ssh in. The root password is
empty, so to log in type 'root' for the user name and hit 'Enter' at the
Password prompt: and you should be in.

If you find you're getting corrupt images on the USB (it doesn't show
the syslinux boot: prompt, or the boot: prompt contains strange
characters), try doing this first:

```
dd if=/dev/zero of=/dev/sdf bs=1M count=512
```

Additional Resources
====================

Please submit any patches against this BSP to the maintainer:
Maintainer: ubilinux team <ubilinux@emutex.com>

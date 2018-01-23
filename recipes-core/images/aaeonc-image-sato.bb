DESCRIPTION = "Linux image for AAEON Community family boards based on core-image-sato"
LICENSE = "GPLv2"

require recipes-sato/images/core-image-sato.bb

IMAGE_FEATURES += "package-management"
IMAGE_FEATURES += "dev-pkgs"
IMAGE_INSTALL += "kernel-modules"
IMAGE_INSTALL += "dmidecode"
IMAGE_INSTALL += "python python3 python3-pip"
IMAGE_INSTALL += "alsa-utils"
IMAGE_INSTALL += "dropbear parted"
IMAGE_INSTALL += "i2c-tools git vim"
IMAGE_INSTALL += "file"
# IMAGE_INSTALL += "lmsensors"
# IMAGE_INSTALL += "init-f75111"


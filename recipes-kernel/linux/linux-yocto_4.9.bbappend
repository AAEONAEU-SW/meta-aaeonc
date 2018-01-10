require recipes-kernel/linux/linux-aaeonc.inc
# replace these SRCREVs with the real commit ids once you've had
# the appropriate changes committed to the upstream linux-yocto repo
SRCREV_machine_pn-linux-yocto_aaeonc ?= "${AUTOREV}"
SRCREV_meta_pn-linux-yocto_aaeonc ?= "${AUTOREV}"

KERNEL_VERSION_SANITY_SKIP="1"

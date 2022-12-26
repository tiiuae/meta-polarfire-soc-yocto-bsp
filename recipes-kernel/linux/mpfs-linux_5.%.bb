require recipes-kernel/linux/mpfs-linux-common.inc

LINUX_VERSION ?= "5.12.1"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "mpfs-linux-5.12.x"
SRCREV = "30aca10363987018dedf93a239be72382766f740"
SRC_URI = " \
    git://github.com/polarfire-soc/linux.git;protocol=https;branch=${BRANCH} \
"

SRC_URI:append:icicle-kit-es = " file://defconfig \
				 file://0001-Custom-PCIe-fix-for-ICICLE-board-device-tree.patch \
"
SRC_URI:append:icicle-kit-es-amp = " file://defconfig"





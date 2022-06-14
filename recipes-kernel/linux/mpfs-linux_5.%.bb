require recipes-kernel/linux/mpfs-linux-common.inc

LINUX_VERSION ?= "5.15"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "mpfs-linux-5.15-next"
SRCREV="${AUTOREV}"
SRC_URI = " \
    git://git@bitbucket.microchip.com/fpga_pfsoc_es/linux.git;protocol=ssh;branch=${BRANCH}  \
"

SRC_URI:append:icicle-kit-es = " file://bsp_cmdline.cfg \
    file://rpi_sense_hat.cfg \
"
SRC_URI:append:icicle-kit-es-amp = " file://bsp_cmdline.cfg \
    file://rpi_sense_hat.cfg \
"

SRC_URI:append:m100pfsevp = "file://m100pfsevp_configs.cfg"

SRC_URI:append:sev-kit-es = " file://bsp_cmdline.cfg "

do_deploy:append() {

    if [ -n "${INITRAMFS_IMAGE}" ]; then

        if [ "${INITRAMFS_IMAGE_BUNDLE}" != "1" ]; then
                ln -snf fitImage-${INITRAMFS_IMAGE_NAME}-${KERNEL_FIT_NAME}${KERNEL_FIT_BIN_EXT} "$deployDir/fitImage"
        fi
    fi
}

addtask deploy after do_install


require gstreamer1.0-plugins-bad.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 "

SRC_URI = " \
    http://gstreamer.freedesktop.org/src/gst-plugins-bad/gst-plugins-bad-${PV}.tar.xz \
    file://configure-allow-to-disable-libssh2.patch \
    file://fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
    file://avoid-including-sys-poll.h-directly.patch \
    file://ensure-valid-sentinels-for-gst_structure_get-etc.patch \
    file://0001-gstreamer-gl.pc.in-don-t-append-GL_CFLAGS-to-CFLAGS.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://0001-Prepend-PKG_CONFIG_SYSROOT_DIR-to-pkg-config-output.patch \
    file://link-with-libvchostif.patch \
    file://0001-vkdisplay-Use-ifdef-for-platform-specific-defines.patch \
    file://0002-vulkan-Use-the-generated-version-of-vkconfig.h.patch \
    file://0001-fix-detection-and-build-of-wayland-stuff-on-vivante.patch \
    file://0001-gst-Clear-floating-flag-in-constructor-of-all-GstObj.patch \
    file://0002-Revert-gl-pkg-config-add-the-configured-platform-api.patch \
    file://0003-Revert-gldisplay-add-a-list-of-glwindow-s.patch \
    file://0004-Revert-gldisplay-add-a-dedicated-event-thread.patch \
    file://0005-Revert-gldisplay-fix-list-leak.patch \
    file://0006-Return-wrong-allocator-instead-of-asserting.patch \
"
SRC_URI[md5sum] = "64bf16cf15edaab1c0e02c8dee7170d0"
SRC_URI[sha256sum] = "0c7857be16686d5c1ba6e34bd338664d3d4599d32714a8eca5c8a41a101e2d08"

S = "${WORKDIR}/gst-plugins-bad-${PV}"

EXTRA_OECONF += "WAYLAND_PROTOCOLS_SYSROOT_DIR=${RECIPE_SYSROOT}"


PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"


PACKAGE_ARCH_imxgpu2d = "${MACHINE_SOCARCH}"

EXTRA_OECONF += "WAYLAND_PROTOCOLS_SYSROOT_DIR=${STAGING_DIR}/${MACHINE}"
EXTRA_OECONF[vardepsexclude] = "MACHINE"


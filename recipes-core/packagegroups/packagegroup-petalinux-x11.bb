DESCRIPTION = "PetaLinux X11 related Packages"
LICENSE = "NONE"

inherit packagegroup

X11_PACKAGES = " \
	packagegroup-core-x11-base \
	xauth \
	xhost \
	xset \
	xtscal \
	xcursor-transparent-theme \
	xinit \
	xinput \
	xinput-calibrator \
	xkbcomp \
	xkeyboard-config \
	xkeyboard-config-locale-en-gb \
	xmodmap \
	xrandr \
	xserver-nodm-init \
	"

MATCHBOX_PACKAGES = " \
       matchbox-config-gtk \
       matchbox-desktop \
       matchbox-keyboard \
       matchbox-keyboard-applet \
       matchbox-panel-2 \
       matchbox-session \
       matchbox-terminal \
       matchbox-theme-sato \
       matchbox-session-sato \
       matchbox-wm \
       settings-daemon \
       "

RDEPENDS_${PN}_append_zynq += " \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' ${X11_PACKAGES} ${MATCHBOX_PACKAGES}', '', d)} \
	"

RDEPENDS_${PN}_append_zynqmp += " ${X11_PACKAGES} ${MATCHBOX_PACKAGES}"

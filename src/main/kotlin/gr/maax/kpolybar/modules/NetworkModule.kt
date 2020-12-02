package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class NetworkModule: Module("network") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "internal/network",
    )

    private val iface by collector.prop(
        propertyName = "interface",
        defaultValue = "\${env:IFACE:}",
    )

    private val interval by collector.prop(
        propertyName = "interval",
        defaultValue = "3.0",
    )

    private val pingInterval by collector.prop(
        propertyName = "ping-interval",
        defaultValue = 10,
    )

    private val formatConnected by collector.prop(
        propertyName = "format-connected",
        defaultValue = "<label-connected>",
    )

    private val labelConnected by collector.prop(
        propertyName = "label-connected",
        defaultValue = "直 %{F-} %essid%",
    )

    private val labelDisconnected by collector.prop(
        propertyName = "label-disconnected",
        defaultValue = "睊",
    )

    private val labelDisconnectedForeground by collector.prop(
        propertyName = "label-disconnected-foreground",
        defaultValue = "#66",
    )

    private val rampSignal0 by collector.prop(
        propertyName = "ramp-signal-0",
        defaultValue = "",
    )

    private val rampSignal1 by collector.prop(
        propertyName = "ramp-signal-1",
        defaultValue = "",
    )

    private val rampSignal2 by collector.prop(
        propertyName = "ramp-signal-2",
        defaultValue = "",
    )

    private val rampSignal3 by collector.prop(
        propertyName = "ramp-signal-3",
        defaultValue = "",
    )

    private val rampSignal4 by collector.prop(
        propertyName = "ramp-signal-4",
        defaultValue = "",
    )

    private val animationPacketloss0 by collector.prop(
        propertyName = "animation-packetloss-0",
        defaultValue = "",
    )

    private val animationPacketloss0Foreground by collector.prop(
        propertyName = "animation-packetloss-0-foreground",
        defaultValue = "#ffa64c",
    )

    private val animationPacketloss1 by collector.prop(
        propertyName = "animation-packetloss-1",
        defaultValue = "",
    )

    private val animationPacketloss1Foreground by collector.prop(
        propertyName = "animation-packetloss-1-foreground",
        defaultValue = "\${bar / top.foreground}",
    )

    private val animationPacketlossFramerate by collector.prop(
        propertyName = "animation-packetloss-framerate",
        defaultValue = 500,
    )

}
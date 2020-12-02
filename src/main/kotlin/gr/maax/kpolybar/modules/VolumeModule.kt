package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class VolumeModule : Module("volume") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "internal/volume",
    )

    private val formatVolume by collector.prop(
        propertyName = "format-volume",
        defaultValue = "<ramp-volume>  <label-volume>",
    )

    private val labelMuted by collector.prop(
        propertyName = "label-muted",
        defaultValue = "  muted",
    )

    private val labelMutedForeground by collector.prop(
        propertyName = "label-muted-foreground",
        defaultValue = "#66",
    )

    private val rampVolume0 by collector.prop(
        propertyName = "ramp-volume-0",
        defaultValue = "",
    )

    private val rampVolume1 by collector.prop(
        propertyName = "ramp-volume-1",
        defaultValue = "",
    )

    private val rampVolume2 by collector.prop(
        propertyName = "ramp-volume-2",
        defaultValue = "",
    )

    private val rampVolume3 by collector.prop(
        propertyName = "ramp-volume-3",
        defaultValue = "",
    )
}
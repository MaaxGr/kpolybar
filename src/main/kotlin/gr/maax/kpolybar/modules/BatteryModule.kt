package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class BatteryModule() : Module("battery") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "internal/battery",
    )
    private val fullAt by collector.prop(
        propertyName = "full-at",
        defaultValue = 98,
    )
    private val timeFormat = collector.prop(
        propertyName = "time-format",
        defaultValue = "%H:%M"
    )
    private val battery = collector.prop(
        propertyName = "battery",
        defaultValue = "BAT1"
    )
    private val adapter = collector.prop(
        propertyName = "adapter",
        defaultValue = "ACAD"
    )
    private val labelCharging = collector.prop(
        propertyName = "label-charging",
        defaultValue = "\uF583 %{F#cccccc}%percentage%%"
    )
    private val labelDischarging = collector.prop(
        propertyName = "label-discharging",
        defaultValue = "\uF583 %{F#cccccc}%percentage%%"
    )
    private val formatCharging = collector.prop(
        propertyName = "format-discharging",
        defaultValue = "<label-charging>"
    )
    private val formatDisDischarging = collector.prop(
        propertyName = "format-discharging",
        defaultValue = "<label-discharging>"
    )
    private val formatFull = collector.prop(
        propertyName = "format-full",
        defaultValue = "<label-full>"
    )

}
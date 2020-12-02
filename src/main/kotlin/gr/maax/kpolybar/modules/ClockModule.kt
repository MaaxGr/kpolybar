package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class ClockModule(
    val format:  String
) : Module("clock") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "custom/script",
    )

    private val exec by collector.prop(
        propertyName = "exec",
        defaultValue = "/usr/bin/date '+%a %e %b %H:%M'",
    )

    private val interval by collector.prop(
        propertyName = "interval",
        defaultValue = 2,
    )

    private val label by collector.prop(
        propertyName = "label",
        defaultValue = " %{F-} %output%",
    )

    private val clickLeft by collector.prop(
        propertyName = "click-left",
        defaultValue = "/usr/bin/gsimplecal",
    )

}
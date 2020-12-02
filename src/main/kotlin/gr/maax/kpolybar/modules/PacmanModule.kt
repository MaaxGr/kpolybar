package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module
import gr.maax.kpolybar.conditions.ConditionBuilder

class PacmanModule(
    val showIf: ConditionBuilder,
    val suffix: String
) : Module("updates") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "custom/script",
    )

    private val exec by collector.prop(
        propertyName = "exec",
        defaultValue = "\"checkupdates | wc -l\"",
    )

    private val execIf by collector.prop(
        propertyName = "exec-if",
        defaultValue = showIf.build(),
    )

    private val interval by collector.prop(
        propertyName = "interval",
        defaultValue = 90,
    )

    private val tail by collector.prop(
        propertyName = "tail",
        defaultValue = true,
    )

    private val format by collector.prop(
        propertyName = "format",
        defaultValue = "<label>",
    )

    private val label by collector.prop(
        propertyName = "label",
        defaultValue = "\"ﮮ %{F#cccccc} %output% $suffix\"",
    )

}
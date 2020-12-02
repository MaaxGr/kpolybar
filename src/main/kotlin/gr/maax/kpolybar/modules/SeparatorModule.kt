package gr.maax.kpolybar.modules

import gr.maax.kpolybar.api.Module

class SeparatorModule() : Module("separator") {

    private val type by collector.prop(
        propertyName = "type",
        defaultValue = "custom/text",
    )

    private val content by collector.prop(
        propertyName = "content",
        defaultValue = "|",
    )

    private val contentForeground by collector.prop(
        propertyName = "content-foreground",
        defaultValue = "#41535b",
    )

    private val contentPadding by collector.prop(
        propertyName = "content-padding",
        defaultValue = 1,
    )

}
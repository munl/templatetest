package com.github.munl.templatetest.src

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.munl.templatetest.src.templates.composeViewTemplate
import com.github.munl.templatetest.src.templates.dataModelTemplate
import com.github.munl.templatetest.src.templates.repositoryTemplate
import com.github.munl.templatetest.src.templates.viewModelTemplate
import org.jetbrains.kotlin.lombok.utils.capitalize

fun RecipeExecutor.mviSetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    composeName: String,
    viewModelName: String,
    dataModelName: String,
    dataModelAsList: Boolean,
    repositoryName: String
) {
    val (_, srcOut, _) = moduleData

    addAllKotlinDependencies(moduleData)


    save(
        composeViewTemplate(packageName, composeName, viewModelName),
        srcOut.resolve("composables/${composeName.capitalize()}.kt")
    )

    if(viewModelName.isNotEmpty() && dataModelName.isNotEmpty()) {
        save(
            viewModelTemplate(packageName, viewModelName, dataModelName, dataModelAsList, repositoryName),
            srcOut.resolve("viewmodel/${viewModelName.capitalize()}.kt")
        )

        save(
            dataModelTemplate(packageName, dataModelName),
            srcOut.resolve("data/${dataModelName.capitalize()}.kt")
        )
    }

    if(repositoryName.isNotEmpty()) {
        save(
            repositoryTemplate(packageName, repositoryName),
            srcOut.resolve("repository/${repositoryName.capitalize()}.kt")
        )
    }
}

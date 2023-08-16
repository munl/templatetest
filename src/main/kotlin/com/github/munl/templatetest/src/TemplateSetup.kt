package com.github.munl.templatetest.src

import com.android.tools.idea.wizard.template.*

val setupTemplate
    get() = template {
        name = "My Custom Template"
        description = "Creates a new View using Compose, ViewModel, and Repository."
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val packageNameParam = defaultPackageNameParameter
        val composeViewName = stringParameter {
            name = "Compose View Name"
            default = "MainScreen"
            help = "The name of the Compose function."
            constraints = listOf(Constraint.NONEMPTY)
        }

        val viewModelName = stringParameter {
            name = "ViewModel Name"
            default = "${composeViewName.value}ViewModel"
            help = "The name of the ViewModel. If left empty, ViewModel will not be created."
        }

        val repositoryName = stringParameter {
            name = "Repository Name"
            default = "${composeViewName.value}Repository"
            help = "The name of the Repository. If left empty, Repository will not be created."
        }

        val dataModelName = stringParameter {
            name = "DataModel Name"
            default = ""
            help = "The DataModel to be associated with the ViewModel and your Compose view. If you provide a ViewModel, you must provide a DataModel"
        }

        val dataModelAsList = booleanParameter {
            name = "DataModel as list"
            default = false
            help = "if Checked, the DataModel will be created as a list within the ViewModel"
        }

        widgets(
            TextFieldWidget(composeViewName),
            LabelWidget(composeViewName.help!!),
            TextFieldWidget(viewModelName),
            LabelWidget(viewModelName.help!!),
            TextFieldWidget(dataModelName),
            LabelWidget(dataModelName.help!!),
            CheckBoxWidget(dataModelAsList),
            LabelWidget(dataModelAsList.help!!),
            TextFieldWidget(repositoryName),
            LabelWidget(repositoryName.help!!),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            mviSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                composeViewName.value,
                viewModelName.value,
                dataModelName.value,
                dataModelAsList.value,
                repositoryName.value
            )
        }
    }

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

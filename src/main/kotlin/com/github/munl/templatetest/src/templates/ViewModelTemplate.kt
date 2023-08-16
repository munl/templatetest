package com.github.munl.templatetest.src.templates

import com.github.munl.templatetest.src.unCapitalizeFirstChar
import org.jetbrains.kotlin.lombok.utils.capitalize

fun viewModelTemplate(
    packageName: String,
    viewModelName: String,
    dataModelName: String,
    dataModelAsList: Boolean,
    repositoryName: String
): String {

    val dataModelFlowValueName = dataModelName.run {
        if (dataModelAsList) {
            return@run this + "s"
        }
        return@run this
    }



    val dataModelFlowType = dataModelName.run {
        if (dataModelAsList) {
            return@run "List<$this>"
        }
        return@run this
    }


    return """package $packageName

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.steamclock.steamclutilitybelt.ui.ContentLoadViewState
import com.steamclock.steamclutilitybelt.ui.ContentDataViewState
import kotlinx.coroutines.flow.asStateFlow

class $viewModelName(
    val ${repositoryName.unCapitalizeFirstChar()}: ${repositoryName.capitalize()}
): ViewModel() {

    private val mutablePostsState = MutableStateFlow<ContentLoadViewState>(ContentLoadViewState.Loading)
    val loadState = mutablePostsState.asStateFlow()

    private val mutable$dataModelFlowValueName =  MutableStateFlow<ContentDataViewState<$dataModelFlowType>>(ContentDataViewState.NoData())
    val ${dataModelFlowValueName.unCapitalizeFirstChar()} = mutable$dataModelFlowValueName.asStateFlow()

}
"""

}
package com.intellij.plugins.nextflow.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

/**
 * Action to create a new Nextflow (.nf) file via File -> New.
 */
class NewNextflowFileAction :
    CreateFileFromTemplateAction(
        "Nextflow File",
        "Create a new Nextflow (.nf) file",
        /* icon = */ null
    ), DumbAware {

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("New Nextflow File")
        builder.addKind("Nextflow file", null, TEMPLATE_NAME)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String =
        "Create Nextflow File"

    companion object {
        private const val TEMPLATE_NAME: String = "Nextflow File"
    }
}
package com.intellij.plugins.nextflow.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/**
 * File type for Nextflow scripts (e.g., .nf) and optionally the config via pattern registration.
 */
class NextflowFileType : LanguageFileType(NextflowLanguage.INSTANCE) {
    override fun getName(): String = "Nextflow"

    override fun getDescription(): String = "Nextflow workflow file"

    override fun getDefaultExtension(): String = "nf"

    override fun getIcon(): Icon? = null // You can set a custom icon later

}
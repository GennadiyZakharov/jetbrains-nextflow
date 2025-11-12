package com.intellij.plugins.nextflow.lang.highlight

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Syntax highlighter factory for Nextflow files.
 * Returns our highlighter that builds on top of Groovy and adds Nextflow keywords.
 */
class NextflowSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return NextflowSyntaxHighlighter()
    }
}
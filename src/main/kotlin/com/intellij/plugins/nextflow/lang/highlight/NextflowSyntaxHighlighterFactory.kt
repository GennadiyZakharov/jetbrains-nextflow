package com.intellij.plugins.nextflow.lang.highlight

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.plugins.groovy.highlighter.GroovySyntaxHighlighter

/**
 * Syntax highlighter factory for Nextflow files.
 * It simply delegates to Groovy's syntax highlighter because Nextflow is Groovy-based.
 */
class NextflowSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return GroovySyntaxHighlighter()
    }
}
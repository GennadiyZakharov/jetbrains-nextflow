package com.intellij.plugins.nextflow.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import com.intellij.plugins.nextflow.lang.NextflowLanguage
import com.intellij.plugins.nextflow.lang.psi.NextflowTokenTypes

/**
 * Basic keyword completion for Nextflow-specific constructs layered over Groovy.
 */
class NextflowCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(NextflowLanguage.INSTANCE),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    for (kw in NextflowTokenTypes.KEYWORDS) {
                        result.addElement(
                            LookupElementBuilder.create(kw)
                                .bold()
                                .withTypeText("Nextflow keyword", true)
                        )
                    }
                }
            }
        )
    }
}
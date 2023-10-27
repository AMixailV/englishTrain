package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Настройка диалогового окна оповещения, отображаемого через [CommonUi.alertDialog]
 */
data class AlertDialogConfig(
    val title: String,
    val message: String,
    val positiveButton: String,
    val negativeButton: String? = null,
)
package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Получить строковые ресурсы без прямой зависимости от контекста.
 */
interface Resources {

    fun getString(id: Int): String

    fun getString(id: Int, vararg placeholders: Any): String

}
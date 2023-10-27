package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Общие действия пользовательского интерфейса, которые можно выполнять где угодно
 */
interface CommonUi {

    /**
     * Покажите короткое всплывающее сообщение пользователю.
     */
    fun toast(message: String)

    /**
     * Покажите простое диалоговое окно оповещения с заголовком, сообщением,
     * положительным действием и необязательным отрицательным действием.
     * @return выбор пользователя (true — положительное действие, false — отрицательное действие)
     */
    suspend fun alertDialog(config: AlertDialogConfig): Boolean

}
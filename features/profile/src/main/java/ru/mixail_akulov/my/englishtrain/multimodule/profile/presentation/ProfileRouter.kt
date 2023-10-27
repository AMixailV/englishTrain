package ru.mixail_akulov.my.englishtrain.multimodule.profile.presentation

interface ProfileRouter {

    /**
     * Запустите экран редактирования имени пользователя.
     */
    fun launchEditUsername()

    /**
     * Вернитесь на предыдущий экран.
     */
    fun goBack()

    /**
     * Закройте все экраны и запустите начальный экран.
     */
    fun restartApp()

}
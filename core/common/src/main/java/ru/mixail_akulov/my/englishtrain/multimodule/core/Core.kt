package ru.mixail_akulov.my.englishtrain.multimodule.core

import kotlinx.coroutines.CoroutineScope

/**
 * Общие глобальные одноэлементные переменные. Вам нужно вызвать
 * [Core.init] перед любым другим взаимодействием с ядром.
 *
 * `Application.onCreate()` — хорошее место для этого.
 */
object Core {

    private lateinit var coreProvider: CoreProvider

    /**
     * @see CommonUi
     */
    val commonUi: CommonUi get() = coreProvider.commonUi

    /**
     * @see Resources
     */
    val resources: Resources get() = coreProvider.resources

    /**
     * @see Logger
     */
    val logger: Logger get() = coreProvider.logger

    /**
     * Глобальная область для запуска асинхронных действий,
     * результаты которых не имеют значения и могут быть проигнорированы.
     * Исключения также игнорируются.
     */
    val globalScope: CoroutineScope get() = coreProvider.globalScope

    /**
     * Глобальный обработчик ошибок по умолчанию для всего приложения.
     * Обычно он используется в viewModelScope для обработки основных ошибок.
     * @see ErrorHandler
     */
    val errorHandler: ErrorHandler get() = coreProvider.errorHandler

    /**
     * Интерфейс, предоставляющий способ перезапуска приложения.
     */
    val appRestarter: AppRestarter get() = coreProvider.appRestarter

    /**
     * Коммуникационный интерфейс для отправки и получения результатов экрана.
     */
    val screenCommunication: ScreenCommunication get() = coreProvider.screenCommunication

    /**
     * Тайм-аут по умолчанию для локальных операций.
     */
    val localTimeoutMillis: Long get() = coreProvider.localTimeoutMillis

    /**
     * Тайм-аут по умолчанию для удаленных операций.
     */
    val remoteTimeoutMillis: Long get() = coreProvider.remoteTimeoutMillis

    /**
     * Период устранения отказов по умолчанию для действий пользовательского интерфейса.
     */
    val debouncePeriodMillis: Long get() = coreProvider.debouncePeriodMillis

    /**
     * Инициализируйте это ядро.
     */
    fun init(coreProvider: CoreProvider) {
        Core.coreProvider = coreProvider
    }

}
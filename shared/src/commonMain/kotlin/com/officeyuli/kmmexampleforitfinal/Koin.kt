package com.officeyuli.kmmexampleforitfinal

import com.officeyuli.kmmexampleforitfinal.ktor.CafeApi
import com.officeyuli.kmmexampleforitfinal.ktor.CafeApiImpl
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoin(appModule: Module) : KoinApplication {
    val koinApplication = startKoin {
        modules(appModule,
            coreModule,
            platformModule
        )
    }
//    val koin = koinApplication.koin
//    val doOnStartup =  koin.get<() -> Unit>()
//    doOnStartup.invoke()

    return koinApplication
}
private val coreModule = module{
    single<CafeApi>{
        CafeApiImpl()
    }
}
internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

expect val platformModule: Module


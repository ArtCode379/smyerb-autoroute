package smyerb.autoparts.smyerbautoroute.di

import androidx.room.Room
import smyerb.autoparts.smyerbautoroute.data.database.VZBXVDatabase
import org.koin.dsl.module

private const val DB_NAME = "vzbxv_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = VZBXVDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<VZBXVDatabase>().cartItemDao() }

    single { get<VZBXVDatabase>().orderDao() }
}
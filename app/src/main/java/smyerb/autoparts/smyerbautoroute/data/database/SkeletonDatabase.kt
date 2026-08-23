package smyerb.autoparts.smyerbautoroute.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import smyerb.autoparts.smyerbautoroute.data.dao.CartItemDao
import smyerb.autoparts.smyerbautoroute.data.dao.OrderDao
import smyerb.autoparts.smyerbautoroute.data.database.converter.Converters
import smyerb.autoparts.smyerbautoroute.data.entity.CartItemEntity
import smyerb.autoparts.smyerbautoroute.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VZBXVDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}
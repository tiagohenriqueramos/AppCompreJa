package br.com.tiago.appcompreja.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tiago.appcompreja.model.ClientePF
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Database(entities = [ClientePF::class], version = 1)
abstract class ClientePFDb: RoomDatabase() {
    abstract fun clientePFDao(): ClientePFDao

    companion object {
        private lateinit var instace: ClientePFDb

        fun getDatabase(context: Context): ClientePFDb {
            if (!::instace.isInitialized) {
                instace = Room.databaseBuilder(
                    context,
                    ClientePFDb::class.java,
                    "clientePJ_tb"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }
    }
}

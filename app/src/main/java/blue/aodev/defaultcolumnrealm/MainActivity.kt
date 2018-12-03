package blue.aodev.defaultcolumnrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRealm()
    }

    private fun setupRealm() {
        Realm.init(this)

        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            val exampleObject = realm.createObject(ExampleObject::class.java, 1).apply {
                default = "Hello"
                other = "World"
            }

            realm.copyToRealmOrUpdate(exampleObject)
        }

        val fromRealm = realm.where(ExampleObject::class.java)
            .equalTo("id", 1L)
            .findFirst()

        Log.d("MainActivity", "fromRealm: $fromRealm")
    }
}

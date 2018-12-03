package blue.aodev.defaultcolumnrealm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ExampleObject : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var default: String? = null
    var other: String? = null
}
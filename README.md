Default Column Realm
====================

Sample repository to reproduce realm-java's [issue #6361](https://github.com/realm/realm-java/issues/6361)

A field named "default" is ignored in a RealmObject.

ExampleObject
-------------

```
open class ExampleObject : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var default: String? = null
    var other: String? = null
}
```

Generated proxy
---------------

The generated proxy has the following column info:

```
static final class ExampleObjectColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long otherIndex;

        ExampleObjectColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ExampleObject");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.otherIndex = addColumnDetails("other", "other", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ...
}
```

Execution
---------

Upon execution the sample repository produces the following log:

`MainActivity: fromRealm: ExampleObject = proxy[{id:1},{other:World}]`


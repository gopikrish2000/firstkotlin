package gopi.kotlintest.initial.advanced

import gopi.kotlintest.initial.helpers.toSnakeCase
import kotlin.reflect.KProperty

class GopiComplexVariableDelegate() {  /*  : ReadWriteProperty<KotlinDelegates, String>*/

   /* operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
*/
  /*  override operator fun getValue(instance: KotlinDelegates, property: KProperty<*>): String {
        println(" called GET GopiComplexVariableDelegate of ${property.name} which is of instance $instance")
        return instance.myComplexVariable
//            return
    }

    override operator fun setValue(instance: KotlinDelegates, property: KProperty<*>, newValue: String) {
        println(" called SET GopiComplexVariableDelegate of ${property.name} which is of instance $instance  with newValue of $newValue" )
        instance.myComplexVariable = newValue
    }*/

    operator fun getValue(instance: KotlinDelegates, property: KProperty<*>): String {
            println(" called GET GopiComplexVariableDelegate of ${property.name.toSnakeCase()} which is of instance $instance")
//            return property.getter()
            return instance.myComplexBackingField
//            return
        }

        operator fun setValue(instance: KotlinDelegates, property: KProperty<*>, newValue: String) {
            println(" called SET GopiComplexVariableDelegate of ${property.name.toSnakeCase()} which is of instance $instance  with newValue of $newValue")
            instance.myComplexBackingField = newValue
        }
   /* companion object {
        operator fun getValue(instance: KotlinDelegates, property: KProperty<*>): String {
            println(" called GET GopiComplexVariableDelegate of ${property.name.toSnakeCase()} which is of instance $instance")
//            return property.getter()
            return instance.myComplexBackingField
//            return
        }

        operator fun setValue(instance: KotlinDelegates, property: KProperty<*>, newValue: String) {
            println(" called SET GopiComplexVariableDelegate of ${property.name.toSnakeCase()} which is of instance $instance  with newValue of $newValue")
            instance.myComplexBackingField = newValue
        }
    }*/
}
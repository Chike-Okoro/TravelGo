package com.example.travelgo.utils

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import com.example.travelgo.utils.PaperPrefs.Companion.INVITELINK_KEY
import io.paperdb.Paper
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PaperPrefs: CoroutineScope, LifecycleObserver {
    // Coroutine's background job
    private val job = Job()
    // Define default thread for Coroutine as Main and add job
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job


    constructor(application: Application){
        Paper.init(application)
    }

    constructor(context: Context){
        Paper.init(context)
    }

    companion object{
        val NAME = "FSOKMWELMW"
        val BANK_NAME = "KNSKWJ"
        val RATE = "FSOKMWELMW"
        val BASE_FEE = "GHJAJK"
        val PRODUCT_CODE = "FSOKelkmermMWELMW"
        val REFERENCE = "HKWJ"
        val RATE_ID = "JNAJ"
        val COUNTRY_CODE = "NUDNIW"
        val CUSTOMER_ID = "HBDUNINA"
        val CUSTOMER_NAME = "UBSYVSJ"
        val FIRST_NAME = "DSNSJZN"
        val LAST_NAME = "UWHSNS"
        val DOCUMENT_STAT = "UYIGSDLIUHWI"
        val LAST_LOGIN = "LODFDHIN"
        val MOBILE_NUMBER = "UHWISOW"
        val GBPWALLET = "PKWJBJUWU"
        val SET_PIN = "JSJSNKSS"
        val IS_FIRST_TIME = "HBJAllNAJ"
        val IS_SET_ID = "JNANA"
        val IS_SET_ADD = "JKSNI"
        val SETPIN = "fwowm"
        val EMAIL = "EMAIL"
        val BENEFICIARIES = "BENEFICIARIES"
        val KYC_LEVEL = "KYC_LEVEL"
        val UNIQUEREF = "UNIQUEREF"
        val NAIRAWALLET = "NAIRAWALLET"
        val NAIRAWALLETACCNO = "NAIRAWALLETACCNO"
        val ADDRESS = "ADDRESS"
        val AUTHTOKEN = "AUTHTOKEN"
        val CITY = "CITY"
        val POSTALCODE = "POSTALCODE"
        val NAIRAWALLETACCBAL = "NAIRAWALLETACCBAL"
        val TRANSACTIONS = "TRANSACTIONS"
        val MYADDRESS = "JNASJK"
        val INVITELINK_KEY = "hbckbskdkanladklmn"
        val DOB = "DOB"

    }

    private fun getStringFromPref(key:String):String{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,"")
            }.await()
        }
    }

    private fun getStringFromPref(key:String,deafult:String):String{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,deafult)
            }.await()
        }
    }

    private fun saveBooleanToPref(key:String,value:Boolean){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,value)
            }
        }
    }

    private fun getBooleanFromPref(key:String):Boolean{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,false)
            }.await()
        }
    }

    private fun getBooleanFromPref(key:String,defaultvalue:Boolean):Boolean{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,defaultvalue)
            }.await()
        }
    }


    private fun <T:Any> saveAnyToPref(key: String,data:T){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,data)
            }
        }
    }

    private fun <T:Any> getAnyFromPref(key:String):T{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key) as T
            }.await()
        }
    }

    private fun <T:Any> getAnyFromPrefNullable(key:String):T?{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key) as T?
            }.await()
        }
    }

    private fun saveStringToPref(key:String,value:String){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,value)
            }
        }
    }


    fun String.getStringPref():String{
        return getStringFromPref(this)
    }

    fun String.getStringPref(default:String):String{
        return getStringFromPref(this,default)
    }

    fun String.saveStringPref(value:String){

        saveStringToPref( this,value)
    }

    fun String.getBooleanPref():Boolean{
        return getBooleanFromPref(this)
    }
    fun String.getBooleanPref(default:Boolean):Boolean{
        return getBooleanFromPref(this,default)
    }

    fun <T:Any> String.getAnyPref():T{
        return getAnyFromPref(this)
    }
    fun <T:Any> String.getAnyPrefNullable():T?{
        return getAnyFromPrefNullable(this)
    }
    fun <T:Any> String.saveAnyPref(data:T){
        return saveAnyToPref(this,data)
    }

    fun String.saveBooleanPref(value:Boolean){
        saveBooleanToPref(this,value)
    }

}
fun PaperPrefs.savePref(key: String, value: Any){

    when(value){
        is String -> {key.saveStringPref(value)}
        is Boolean -> {key.saveBooleanPref(value)}
        else -> {
            key.saveAnyPref(value)
        }
    }
}
fun String.saveStringPref(value:String){
    saveStringToPref( this,value)
}

private fun saveStringToPref(key:String,value:String){
    runBlocking {
        withContext(Dispatchers.IO){
            Paper.book().write(key,value)
        }
    }
}

fun String.getStringPref():String{
    return getStringFromPref(this)
}

private fun getStringFromPref(key:String):String{
    return runBlocking {
        async(Dispatchers.IO){
            Paper.book().read(key,"")
        }.await()
    }
}

fun setInviteLink(inviteLink: String) {
    INVITELINK_KEY.saveStringPref(inviteLink)
}
fun getInviteLink():String{
    return INVITELINK_KEY.getStringPref()
}

fun PaperPrefs.getStringPref(key: String):String{
    return key.getStringPref()
}

fun PaperPrefs.getBooleanPref(key: String):Boolean{
    return key.getBooleanPref()
}


fun PaperPrefs.getBooleanPref(key: String, defaultValue:Boolean):Boolean{
    return key.getBooleanPref(defaultValue)
}
fun <T:Any> PaperPrefs.getAnyPref(key: String):T{
    return key.getAnyPref()
}
fun <T:Any> PaperPrefs.getAnyPrefNullable(key: String):T?{
    return key.getAnyPrefNullable()
}
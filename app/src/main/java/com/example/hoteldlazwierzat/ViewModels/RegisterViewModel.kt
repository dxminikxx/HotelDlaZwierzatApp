package com.example.hoteldlazwierzat.ViewModels

import android.app.Application
import android.provider.ContactsContract.Intents.Insert
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hoteldlazwierzat.data.Entities.Client
import com.example.hoteldlazwierzat.data.Repositories.ClientRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RegisterViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = ClientRepo(app.applicationContext)
    lateinit var loggedClient : Client

    /**
     * In case you want to insert Client outside of a coroutine, this function launches it's own corotuine
     * to insert a Client object
     */
    fun InsertClient(client: Client){
        CoroutineScope(Dispatchers.IO).launch {
            repo.insert(client)
        }
    }
    suspend fun SuspendedInsertClient(client: Client){
        repo.insert(client)
    }
    fun UpdateClient(client: Client){
        CoroutineScope(Dispatchers.IO).launch {
            repo.update(client)
        }
    }
    fun DeleteClient(client: Client){
        CoroutineScope(Dispatchers.IO).launch {
            repo.delete(client)
        }
    }

    fun GetClientByUserName(username:String) : Client {
        return repo.findClientByUserName(username)
    }
    fun getAllClientUsernames() : List<String>{
        return repo.getAllClientUsernames()
    }


    fun RegisterAndLoginClient(client:Client){
        InsertClient(client)
        CoroutineScope(viewModelScope.coroutineContext).launch {
            //loggedClient = GetClientByUserName(client.username).collect {}
        }
    }
}
package com.example.fiscalcode

import androidx.lifecycle.MutableLiveData

class CFViewModel {
    var fiscalCode : MutableLiveData<String> = MutableLiveData()

    fun getFiscalCode(cf : CFModel) {
        fiscalCode.value=cf.encode()

    }
}

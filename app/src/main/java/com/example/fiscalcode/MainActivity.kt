package com.example.fiscalcode


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import com.example.fiscalcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "CF2021"
    }

    private lateinit var binding: ActivityMainBinding
    private var fiscalCode = CFModel()
    private var viewModel = CFViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setViewModel()
        setUIController()

    }


    private fun setUIController() {
        binding.etLastName.doAfterTextChanged {
            fiscalCode.lastName = it.toString()
            viewModel.getFiscalCode(fiscalCode)
        }
        binding.etFirstName.doAfterTextChanged {
            fiscalCode.firstName = it.toString()
            viewModel.getFiscalCode(fiscalCode)
        }
    }

    private fun setViewModel() {
        val fiscalCodeObserver = Observer<String> {  //onChange
                cf ->
            Log.w(TAG, cf)
            binding.tvFiscalCode.text = cf
        }
        viewModel.fiscalCode.observe(this, fiscalCodeObserver)
    }

}

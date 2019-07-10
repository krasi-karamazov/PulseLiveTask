package kpk.dev.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import kpk.dev.presentation.dialog.BaseDialog
import kpk.dev.presentation.dialog.ErrorDialog
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory

abstract class BaseFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    protected fun displayError(errorMessage: String?) {
        val bundle = Bundle()
        bundle.putString(BaseDialog.TITLE_ARG_KEY, "Error")
        bundle.putString(BaseDialog.MESSAGE_ARG_KEY, errorMessage ?: "An error occurred")
        ErrorDialog.getInstance(bundle).show(fragmentManager!!, ErrorDialog::class.java.simpleName)
    }

    private fun performDI() = AndroidSupportInjection.inject(this)

    abstract fun init()

    abstract fun getLayoutId(): Int

    inline fun <reified T: ViewModel> ViewModelFactory.get(): T = ViewModelProviders.of(this@BaseFragment, this)[T::class.java]
}
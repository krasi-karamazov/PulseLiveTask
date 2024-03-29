package kpk.dev.presentation.dialog

import android.app.Dialog
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment


abstract class BaseDialog : DialogFragment() {

    companion object {
        const val TITLE_ARG_KEY = "title"
        const val MESSAGE_ARG_KEY = "message"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity as AppCompatActivity)
        val inflater = activity!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (getIsCustomDialog()) {
            val view = inflater.inflate(getLayoutId(), null, false)
            initUI(view)
            builder.setView(view)
        } else {
            setupDialog(builder)
        }

        return builder.show()
    }

    protected abstract fun initUI(view: View)
    protected abstract fun setupDialog(dialogBuilder: AlertDialog.Builder)
    protected abstract fun getLayoutId(): Int
    protected abstract fun getIsCustomDialog(): Boolean
    protected abstract fun getDialogTag(): String
}
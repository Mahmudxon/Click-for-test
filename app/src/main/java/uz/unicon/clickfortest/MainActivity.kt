package uz.unicon.clickfortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.click.mobilesdk.BuildConfig
import uz.click.mobilesdk.core.ClickMerchant
import uz.click.mobilesdk.core.ClickMerchantConfig
import uz.click.mobilesdk.core.ClickMerchantManager
import uz.click.mobilesdk.core.callbacks.ClickMerchantListener
import uz.click.mobilesdk.impl.paymentoptions.PaymentOptionEnum
import uz.click.mobilesdk.impl.paymentoptions.ThemeOptions

class MainActivity : AppCompatActivity(), ClickMerchantListener {

    private val config : ClickMerchantConfig by lazy { getMerchantConfig() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ClickMerchantManager.logs = BuildConfig.DEBUG
        button?.setOnClickListener { buySomeThing() }
    }

    private fun getMerchantConfig() = ClickMerchantConfig.Builder()
            .serviceId(12345)
            .merchantId(12345)
            .amount(50000.0)
//            .transactionParam("order_id_in_your_server ")
            .locale("EN")
            .theme(ThemeOptions.LIGHT) //ThemeOptions.NIGHT
            .option(PaymentOptionEnum.USSD)
            .productName("Название продкута или услуги")
            .productDescription("Описание продукта или услуги")
            .merchantUserId(12345)
            .build()

    override fun onFailure() {

    }

    override fun onInvoiceCancelled() {

    }

    override fun onReceiveRequestId(id: String) {

    }

    override fun onSuccess(paymentId: Long) {

    }

    private fun buySomeThing()
    {
        ClickMerchant.init(supportFragmentManager, config, this)
    }
}
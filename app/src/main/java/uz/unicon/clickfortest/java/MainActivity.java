package uz.unicon.clickfortest.java;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import uz.click.mobilesdk.core.ClickMerchant;
import uz.click.mobilesdk.core.ClickMerchantConfig;
import uz.click.mobilesdk.core.ClickMerchantManager;
import uz.click.mobilesdk.core.callbacks.ClickMerchantListener;
import uz.click.mobilesdk.impl.paymentoptions.PaymentOptionEnum;
import uz.click.mobilesdk.impl.paymentoptions.ThemeOptions;
import uz.unicon.clickfortest.BuildConfig;
import uz.unicon.clickfortest.R;

public class MainActivity extends AppCompatActivity implements ClickMerchantListener {

    ClickMerchantConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ClickMerchantManager.Companion.setLogs(BuildConfig.DEBUG);
        config = getConfig();
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buySomething();
            }
        });
    }

    private ClickMerchantConfig getConfig() {
        return new ClickMerchantConfig.Builder()
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
                .build();
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onInvoiceCancelled() {

    }

    @Override
    public void onReceiveRequestId(@NotNull String s) {

    }

    @Override
    public void onSuccess(long l) {

    }

    private void buySomething() {
        ClickMerchant.init(getSupportFragmentManager(), config, this);
    }
}
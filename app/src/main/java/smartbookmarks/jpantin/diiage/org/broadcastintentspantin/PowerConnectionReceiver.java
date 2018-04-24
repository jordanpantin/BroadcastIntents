package smartbookmarks.jpantin.diiage.org.broadcastintentspantin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context ctxt, Intent intent)
    {
        // Pourcentage de la batterie.
        int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

        int battery = 20;

        // Si batterie inférieure à "battery" on affiche une alerte.
        if (batteryLevel < battery)
        {
            Toast.makeText(ctxt, "La batterie est inférieur à " + String.valueOf(battery),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
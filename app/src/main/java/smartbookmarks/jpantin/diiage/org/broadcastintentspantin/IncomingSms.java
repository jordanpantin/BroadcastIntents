package smartbookmarks.jpantin.diiage.org.broadcastintentspantin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class IncomingSms extends BroadcastReceiver
{
    /**
     * Evènement lorsqu'un message est reçu
     */
    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    // Le numéro qui envoie le SMS
                    String senderNum = phoneNumber;

                    // Le message du SMS
                    String message = currentMessage.getDisplayMessageBody();

                    // Affiche l'alerte (TOAST).
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();

                }
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
        }
    }
}

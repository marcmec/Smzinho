package smzinho.br.smzinho.Firebase;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Marcos Vinícius on 12/01/2018.
 */

public class CustomFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG="Token";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensagem de" + from);

        if(remoteMessage.getNotification() != null ){
            Log.d(TAG,"Notificação" + remoteMessage.getNotification().getBody());
        }
    }


}

package com.tailscale.ipn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tailscale.ipn.IPNActivity;
// import com.tailscale.ipn.IPNService;
//import com.tailscale.ipn.QuickToggleService;

public class BootUpRec extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      //open the app and minimized
      if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
        Intent i = new Intent(context, IPNActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("BOOT", true);
        context.startActivity(i);

      }
    }
}